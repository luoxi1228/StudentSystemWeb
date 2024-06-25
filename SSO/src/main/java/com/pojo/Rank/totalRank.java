package com.pojo.Rank;

import lombok.Data;

import java.math.BigInteger;
@Data
public class totalRank {
    private String s_id;
    private String s_name;
    private int s_grade;
    private int total_rank;
    @Override
    public String toString() {
        return "totalRank{" +
                "s_id='" + s_id + '\'' +
                ", s_name='" + s_name + '\'' +
                ", s_grade=" + s_grade +
                ", total_rank=" + total_rank +
                '}';
    }
}
