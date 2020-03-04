package com.example.wbdvsp20onlinespringbootjzheng.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "widgets")
public class Widget {
    @Id
    @GeneratedValue (strategy= GenerationType.IDENTITY)
    private Integer id;

    private String type = "HEADING";
    private String text = "Heading text";
//    private String url;
    private int widgetOrder = 0;
    private int size = 1;
    private String title = "Heading Widget";

    @ManyToOne
    @JsonIgnore
    private Topic topic;

//    private int width, height;
//    private String ccsClass;
//    private String style;
//    private String value;


    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public int getOrder() {
        return widgetOrder;
    }

    public void setOrder(int order) {
        this.widgetOrder = order;
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
