package com.example.achar.javatokotlin.activity.diff_recycle_view;

/**
 * Created by ext.charles.ma on 18/2/8.
 */

public class OneBean implements BaseBean {

    public int order;
    private String name;

    public OneBean(int order,String name) {
        this.order = order;
        this.name = name;
    }

    @Override
    public int getOrder() {
        return order;
    }

    @Override
    public void setOrder(int order) {
        this.order = order;
    }

    public OneBean() {
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
