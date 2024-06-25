package com.pojo.selectCourse;

import lombok.AllArgsConstructor;
import lombok.Data;


@AllArgsConstructor
@Data
public class classTeacher {
    private String c_id;
    private String t_id;
    private String co_id;
    private String c_room;
    private int s_num;
    private String c_time;
    private String t_name;
    private String t_gender;
    private String t_age;
    private String t_faculty;
    @Override

    public String toString() {
        return "classTeacher{" +
                "c_id='" + c_id + '\'' +
                ", t_id='" + t_id + '\'' +
                ", co_id='" + co_id + '\'' +
                ", c_room='" + c_room + '\'' +
                ", s_num=" + s_num +
                ", c_time='" + c_time + '\'' +
                ", t_name='" + t_name + '\'' +
                ", t_gender='" + t_gender + '\'' +
                ", t_age='" + t_age + '\'' +
                ", t_faculty='" + t_faculty + '\'' +
                '}';
    }
}
