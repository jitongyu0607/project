package com.itheima.service;

import com.itheima.pojo.Emp;
import com.itheima.pojo.PageBean;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Map;

public interface EmpService {

    List<Emp> selectAll();

    Emp selectById(int id);

    void InsertOne(Emp emp);

    void deleteById(int id);

    Integer selectCount();

    PageBean<Emp> selectByPage(int currentPage, int pageSize);

    void deleteByIds(List<Emp> emps);

    void InsertEmps(List<Emp> emps);

    void updateById(Emp emp);

    void updateByIds(List<Emp> emps);

    List<Emp>fuzzySelect(Emp emp);
}
