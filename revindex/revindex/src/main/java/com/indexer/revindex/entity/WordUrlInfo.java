package com.indexer.revindex.entity;
import jakarta.persistence.*;
@Entity
@Table(name = "word_url_info")
public class WordUrlInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "word", nullable = false)
    private RevData revData;

    @Column(length = 2048, nullable = false)
    private String url;

    private int numberValue;

    private double doubleValue;

    public WordUrlInfo() {}

    public WordUrlInfo(RevData revData, String url, int numberValue, double doubleValue) {
        this.revData = revData;
        this.url = url;
        this.numberValue = numberValue;
        this.doubleValue = doubleValue;
    }

    public RevData getRevData() {
        return revData;
    }

    public void setRevData(RevData revData) {
        this.revData = revData;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getNumberValue() {
        return numberValue;
    }

    public void setNumberValue(int numberValue) {
        this.numberValue = numberValue;
    }

    public double getDoubleValue() {
        return doubleValue;
    }

    public void setDoubleValue(double doubleValue) {
        this.doubleValue = doubleValue;
    }
}
