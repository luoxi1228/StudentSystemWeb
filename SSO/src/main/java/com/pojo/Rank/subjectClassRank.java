package com.pojo.Rank;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class subjectClassRank {
    private String s_id;
    private String s_name;
    private int finalGrade;
    private int rank;
    @Override
    public String toString() {
        return "subjectClassRank{" +
                "s_id='" + s_id + '\'' +
                ", s_name='" + s_name + '\'' +
                ", finalGrade='" + finalGrade + '\'' +
                ", subject_rank='" + rank + '\'' +
                '}';
    }
}
