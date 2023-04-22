package com.itheima.dao;


import com.itheima.pojo.Emp;
import com.itheima.pojo.PageBean;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface EmpDao {

    /**
     * 查詢所有
     * @return
     */
    List<Emp> selectAll();



    /**
     * 按照id查詢
     * @param id
     * @return
     */
    Emp selectById(int id);



    /**
     * 插入數據
     */
    void InsertOne(Emp emp);


    /**
     * 刪除數據
     */
    void deleteById(int id);

    /**
     * 查詢總記錄數
     */
    Integer selectCount();

    /**
     * 分頁查詢
     */
    List<Emp> selectByPage(int currentPage,int pageSize);

    /**
     * 根據條件刪除
     */
    void deleteByIds(List<Integer> emps);


    /**
     * 批量添加
     * @param emps
     */
    void InsertEmps(List<Emp> emps);

    /**
     *更新
     */
    void updateById(Emp emp);


    void updateByIds(List<Emp> emps);

    /**
     * 模糊查詢
     * @param emp
     * @return
     */
    List<Emp> fuzzySelect(Emp emp);
}
