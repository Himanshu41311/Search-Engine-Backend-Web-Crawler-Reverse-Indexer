package com.indexer.revindex.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "revdata")
public class RevData {
    @Id
    private String word;

    @OneToMany(mappedBy = "revData", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<WordUrlInfo> wordUrlInfoList = new ArrayList<>();

    public RevData() {}

    public RevData(String word) {
        this.word = word;
    }

    public List<WordUrlInfo> getWordUrlInfoList() {
        return wordUrlInfoList;
    }

    public void setWordUrlInfoList(List<WordUrlInfo> wordUrlInfoList) {
        this.wordUrlInfoList = wordUrlInfoList;
    }
}

