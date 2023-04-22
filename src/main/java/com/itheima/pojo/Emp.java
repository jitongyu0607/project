package com.itheima.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Emp {

    private int id;
    private String ename;
    private int jobId;
    private int mgr;
    private String joindate;
    private String updatedate;
    private BigDecimal salary;
    private BigDecimal bonus;
    private int deptId;

    @Override
    public String toString() {
        return "Emp{" +
                "id=" + id +
                ", ename='" + ename + '\'' +
                ", jobId=" + jobId +
                ", mgr=" + mgr +
                ", joindate='" + joindate + '\'' +
                ", updatedate='" + updatedate + '\'' +
                ", salary=" + salary +
                ", bonus=" + bonus +
                ", deptId=" + deptId +
                '}';
    }
}
