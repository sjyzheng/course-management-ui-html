package com.example.wbdvsp20onlinespringbootjzheng.models;

import java.awt.*;

public class Widget {
    private String id;
    private String type = "HEADING";
    private int order = 0;
    private String text = "Heading text";
//    private String url;
    private int size = 1;
//    private int width, height;
//    private String ccsClass;
//    private String style;
//    private String value;
    private String topicId;

    private String title = "Heading Widget";


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTopicId() {
        return topicId;
    }

    public void setTopicId(String topicId) {
        this.topicId = topicId;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
