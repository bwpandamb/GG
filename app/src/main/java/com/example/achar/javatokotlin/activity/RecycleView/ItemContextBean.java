package com.example.achar.javatokotlin.activity.RecycleView;

/**
 * Created by ext.charles.ma on 18/2/2.
 */

public class ItemContextBean {

    private String context;
    private String introduction;
    private Class<?> activity;

    public ItemContextBean() {
    }

    public Class<?> getActivity() {
        return activity;
    }

    public void setActivity(Class<?> activity) {
        this.activity = activity;
    }

    public ItemContextBean(String context, String introduction, Class<?> activity) {
        this.context = context;
        this.introduction = introduction;
        this.activity = activity;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }
}
