package com.itheima.service.impl;

import com.itheima.dao.EmpDao;
import com.itheima.pojo.Emp;
import com.itheima.pojo.PageBean;
import com.itheima.service.EmpService;
import com.itheima.util.MysqlUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class EmpServiceImpl implements EmpService {


    @Autowired
    private EmpDao dao;


    /**
     * 查詢所有
     *
     * @return
     */
    @Override
    public List<Emp> selectAll() {
        List<Emp> emps = dao.selectAll();

        return emps;
    }

    /**
     * 根據ID查詢一個
     *
     * @param id
     * @return
     */
    @Override
    public Emp selectById(int id) {

        Emp emp = dao.selectById(id);
        return emp;
    }

    /**
     * 插入一條數據
     *
     * @param emp
     */
    @Override
    public void InsertOne(Emp emp) {
        MysqlUtil.setJoinDate(emp);
        dao.InsertOne(emp);
    }

    /**
     * 根據id刪除一個
     *
     * @param id
     */
    @Override
    public void deleteById(int id) {
        dao.deleteById(id);
    }

    /**
     * 查詢總記錄數
     *
     * @return
     */
    @Override
    public Integer selectCount() {
        Integer integer = dao.selectCount();
        return integer;
    }


    /**
     * 分頁查詢
     *
     * @param currentPage
     * @param pageSize
     * @return
     */
    @Override
    public PageBean<Emp> selectByPage(int currentPage, int pageSize) {
        if (currentPage < 1) {
            currentPage = 1;
        }


        currentPage = currentPage - 1;
        List<Emp> emps = dao.selectByPage(currentPage, pageSize);


        PageBean<Emp> pageBean = new PageBean<>();
        pageBean.setData(emps);
        return pageBean;
    }


    /**
     * 根據id刪除多條數據
     *
     * @param emps
     */
    @Override
    public void deleteByIds(List<Emp> emps) {
        List<Integer> list = new ArrayList<Integer>();

        for (int i = 0; i < emps.size(); i++) {
            list.add(emps.get(i).getId());
        }
        dao.deleteByIds(list);
    }


    /**
     * 插入多條數據
     *
     * @param emps
     */
    @Override
    public void InsertEmps(List<Emp> emps) {

        /**
         * 設置時間
         */
        for (int i = emps.size() - 1; i >= 0; i--) {
            MysqlUtil.setUpdateDate(emps.get(i));
        }
        dao.InsertEmps(emps);
    }


    /**
     * 更新一條數據
     *
     * @param emp
     */
    @Override
    public void updateById(Emp emp) {
        MysqlUtil.setUpdateDate(emp);
        dao.updateById(emp);
    }


    /**
     * 批量更新數據
     *
     * @param emps
     */

    @Override
    public void updateByIds(List<Emp> emps) {
        for (Emp emp : emps) {
            MysqlUtil.setUpdateDate(emp);
            dao.updateById(emp);
        }
    }


    /**
     * 模糊查詢
     *
     * @param emp
     * @return
     */
    @Override
    public List<Emp> fuzzySelect(Emp emp) {
        List<Emp> list = dao.fuzzySelect(emp);
        for (Emp emp1 : list) {
            System.out.println("查詢到的數據為：" + emp1);
        }
        System.out.println(list.size());
        return list;
    }
}
