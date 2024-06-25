package com.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class classroom {
    private String c_id;
    private String t_id;
    private String co_id;
    private String c_room;
    private int s_num;
    private String c_time;
    @Override
    public String toString() {
        return "classroom[c_id="+c_id+",t_id="+t_id+",co_id="+
                co_id+",c_room="+c_room+",s_num="+s_num+",c_time="+c_time+"]";
    }
}
