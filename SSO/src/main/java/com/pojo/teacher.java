package com.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class teacher {
    private String t_id;
    private String t_name;
    private String t_gender;
    private String t_age;
    private String t_faculty;
    private String t_password;
    @Override
    public String toString() {
        return "teacher{id="+t_id+",name="+t_name+",gender="+t_gender+",age="+t_age+",faculty="+t_faculty+",password="+t_password+"}";
    }
}
