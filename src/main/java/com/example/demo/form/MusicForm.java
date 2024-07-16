package com.example.demo.form;

import lombok.Data;

@Data
public class MusicForm {
	private int id;
    private String name;
    private String singer; // 追加

    // コンストラクタ
    public MusicForm() {
        // デフォルトのコンストラクタ
    }

    // GetterとSetter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }
    public void setId(int id) {
    	this.id=id;
    }
}
