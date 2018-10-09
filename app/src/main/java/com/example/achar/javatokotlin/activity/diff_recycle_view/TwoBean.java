package com.example.achar.javatokotlin.activity.diff_recycle_view;

/**
 * Created by ext.charles.ma on 18/2/8.
 */

public class TwoBean implements BaseBean{
    private String context;
    public int order;

    public TwoBean() {
    }

    public TwoBean(int order,String context) {
        this.order = order;
        this.context = context;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    @Override
    public int getOrder() {
        return order;
    }

    @Override
    public void setOrder(int order) {
        this.order = order;
    }

    //    @Override
//    public int getOrder() {
//        return order;
//    }
//
//    @Override
//    public void setOrder(int order) {
//        this.order = order;
//    }
//    @Override
//    public int compareTo(@NonNull BaseBean o) {
//        return this.order - o.getOrder();
////        return 0;
//    }
}
