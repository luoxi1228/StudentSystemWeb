package com.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class student {
    private String s_id;
    private String s_name;
    private String s_gender;
    private String s_age;
    private String s_faculty;
    private String s_password;
    private int s_grade;
    @Override
    public String toString() {
      return  "student{id="+s_id+",name="+s_name+",gender="+s_gender+",age="+s_age+
              ",faculty="+s_faculty+",password="+s_password+",grade="+s_grade+"}";
    }
}
