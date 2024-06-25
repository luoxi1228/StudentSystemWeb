package com.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class course {
    private String co_id;
    private String co_name;
    @Override
    public String toString() {
        return "course [co_id=" + co_id + ", co_name=" + co_name + "]";
    }
}
