package com.example.demo.service;

import com.example.demo.entity.Music;

public interface MusicService {
    Iterable<Music> findAll();
    void insertMusic(Music music);
    Music findById(int id);
    void deleteMusic(int id);
    void updateMusic(Music music);  // メソッドを追加
}
