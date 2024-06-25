package com.pojo.changeGrade;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class studentGrade {
    private String s_id;
    private String s_name;
    private String s_gender;
    private String s_age;
    private String s_faculty;
    private int s_grade;

    private String c_id;
    private int midGrade;
    private int labGrade;
    private int examGrade;
    private int usualGrade;
    private int finalGrade;
    @Override
    public String toString() {
        return "studentGrade{" +
                "s_id='" + s_id + '\'' +
                ", s_name='" + s_name + '\'' +
                ", s_gender='" + s_gender + '\'' +
                ", s_age='" + s_age + '\'' +
                ", s_faculty='" + s_faculty + '\'' +
                ", s_grade=" + s_grade +
                ", c_id='" + c_id + '\'' +
                ", midGrade=" + midGrade +
                ", labGrade=" + labGrade +
                ", examGrade=" + examGrade +
                ", usualGrade=" + usualGrade +
                ", finalGrade=" + finalGrade +
                '}';
    }
}
