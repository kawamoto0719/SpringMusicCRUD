package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.demo.entity.Music;
import com.example.demo.form.MusicForm;
import com.example.demo.service.MusicService;

@Controller
public class MusicController {

    @Autowired
    MusicService service;

    @GetMapping("index")
    public String indexView() {
        return "menu";
    }

    @PostMapping(value = "menu", params = "view")
    public String listView(Model model) {
        Iterable<Music> list = service.findAll();
        model.addAttribute("list", list);
        return "list";
    }

    @PostMapping(value = "menu", params = "insert")
    public String musicInputView() {
        return "music-input";
    }

    @PostMapping("insert")
    public String musicInsertView(MusicForm f) {
        Music music = new Music();
        music.setSong_name(f.getName());
        music.setSinger(f.getSinger());
        service.insertMusic(music);
        return "music-complete";
    }

    @PostMapping(value = "menu", params = "update")
    public String updateView(Model model) {
        Iterable<Music> list = service.findAll();
        model.addAttribute("list", list);
        return "music-update";
    }

    @PostMapping("update-form")
    public String musicUpdate(@RequestParam("song_id") int songId, Model model) {
        Music music = service.findById(songId);
        if (music != null) {
            model.addAttribute("music", music);
            MusicForm musicForm = new MusicForm();
            musicForm.setId(music.getId());
            musicForm.setName(music.getSong_name());
            musicForm.setSinger(music.getSinger());
            model.addAttribute("musicForm", musicForm);
        }
        Iterable<Music> list = service.findAll();
        model.addAttribute("list", list);
        return "music-update-b";
    }

    @PostMapping("update-complete")
    public String updateComplete(MusicForm f) {
        Music music = new Music();
        music.setId(f.getId());  
        music.setSong_name(f.getName());
        music.setSinger(f.getSinger());
        service.updateMusic(music);
        return "menu";
    }

    @PostMapping(value = "menu", params = "delete")
    public String deleteView(Model model) {
        Iterable<Music> list = service.findAll();
        model.addAttribute("list", list);
        return "music-delete";
    }

    @PostMapping("delete")
    public String deleteMusic(@RequestParam("song_id") int songId) {
        service.deleteMusic(songId);
        return "music-delete-comp";
    }
}
