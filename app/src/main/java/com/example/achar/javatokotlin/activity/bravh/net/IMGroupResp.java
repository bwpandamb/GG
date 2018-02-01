package com.example.achar.javatokotlin.activity.bravh.net;

import java.util.List;

/**
 * Created by ext.charles.ma on 18/1/11.
 */

public class IMGroupResp {
    String imUserId;
    List<String> groupIds;

    public IMGroupResp(String imUserId, List<String> groupIds) {
        this.imUserId = imUserId;
        this.groupIds = groupIds;
    }

    public IMGroupResp() {
    }

    public String getImUserId() {
        return imUserId;
    }

    public void setImUserId(String imUserId) {
        this.imUserId = imUserId;
    }

    public List<String> getGroupIds() {
        return groupIds;
    }

    public void setGroupIds(List<String> groupIds) {
        this.groupIds = groupIds;
    }
}
