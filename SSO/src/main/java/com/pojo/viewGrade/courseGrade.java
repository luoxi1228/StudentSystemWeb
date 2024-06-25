package com.pojo.viewGrade;

import lombok.Data;
import lombok.ToString;

@Data
public class courseGrade {
    private String s_id;
    private String c_id;
    private String co_id;
    private String co_name;
    private int midGrade;
    private int labGrade;
    private int examGrade;
    private int usualGrade;
    private int finalGrade;
    private String c_room;
    private String c_time;
    @Override
    public String toString() {
        return "CourseGrade{" +
                "s_id='" + s_id + '\'' +
                ", c_id='" + c_id + '\'' +
                ", co_id='" + co_id + '\'' +
                ", co_name='" + co_name + '\'' +
                ", midGrade=" + midGrade +
                ", labGrade=" + labGrade +
                ", examGrade=" + examGrade +
                ", usualGrade=" + usualGrade +
                ", finalGrade=" + finalGrade +
                ", c_room='" + c_room + '\'' +
                ", c_time='" + c_time + '\'' +
                '}';
    }
}
