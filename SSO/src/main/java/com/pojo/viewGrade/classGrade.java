package com.pojo.viewGrade;

import lombok.Data;

@Data
public class classGrade {
    private String s_id;
    private String s_name;
    private String t_id;
    private String t_name;
    private String c_id;
    private String c_room;
    private String co_id;
    private String co_name;
    private int finalGrade;
    private String c_time;


    @Override
    public String toString() {
        return "classGrade{" +
                "s_id='" + s_id + '\'' +
                ", s_name='" + s_name + '\'' +
                ", t_id='" + t_id + '\'' +
                ", t_name='" + t_name + '\'' +
                ", c_id='" + c_id + '\'' +
                ", c_room='" + c_room + '\'' +
                ", co_id='" + co_id + '\'' +
                ", co_name='" + co_name + '\'' +
                ", finalGrade=" + finalGrade +
                ", c_time='" + c_time + '\'' +
                '}';
    }
}