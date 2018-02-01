package com.example.achar.javatokotlin.activity.bravh;

/**
 * Created by ext.charles.ma on 18/1/5.
 */

public class SampleData {
    private String Name;
    private int age;
    private String content;
    Boolean isDraged;

    private SampleData() {
    }

    public SampleData(String name, int age, String content,Boolean isDraged) {
        Name = name;
        this.age = age;
        this.content = content;
        this.isDraged = isDraged;
    }

    public Boolean getDraged() {
        return isDraged;
    }

    public void setDraged(Boolean draged) {
        isDraged = draged;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
