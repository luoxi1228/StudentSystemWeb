package com.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
public class admin {
    private String account;
    private String password;

    @Override
    public String toString() {
        return "admin[account:"+account+"password:"+password+"]";
    }
}
