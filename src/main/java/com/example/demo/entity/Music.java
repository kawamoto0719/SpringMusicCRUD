package com.example.demo.entity;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Music {
    @Id
    private Integer song_id;
    private String song_name;
    private String singer;
    
    public Integer getId() {
        return song_id;
    }

    public void setId(Integer song_id) {
        this.song_id = song_id;
    }
}
