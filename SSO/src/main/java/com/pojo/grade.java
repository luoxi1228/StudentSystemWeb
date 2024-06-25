package com.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class grade {
    private String s_id;
    private String c_id;
    private int midGrade;
    private int labGrade;
    private int examGrade;
    private int usualGrade;
    private int finalGrade;
    @Override
    public String toString() {
        return "grade{s_id=" + s_id + ", c_id=" + c_id + ", midGrade="+midGrade+",labGrade="+labGrade+
                ",examGrade="+examGrade+",usualGrade="+usualGrade+",finalGrade="+finalGrade+"}";
    }

}
