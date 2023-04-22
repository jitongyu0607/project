package com.itheima.controller;


import com.itheima.pojo.Emp;
import com.itheima.pojo.PageBean;
import com.itheima.service.EmpService;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping("/emp")
public class EmpController {


    @Autowired
    private EmpService service;


    /**
     * 查詢所有
     *
     * @return
     */

    @GetMapping
    List<Emp> selectAll() {
        List<Emp> emps = service.selectAll();
        return emps;

    }


    /**
     * 按照id查詢
     *
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Emp selectById(@PathVariable int id) {

        Emp emp = service.selectById(id);

        return emp;
    }

    /**
     * 插入一條數據
     */
    @PostMapping
    public void InsertOne(@RequestBody Emp emp) {
        Date date=new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String detetime = simpleDateFormat.format(date);
        emp.setJoindate(detetime);
        service.InsertOne(emp);
    }


    /**
     *批量添加
     */
@PostMapping("/insertEmps")
public void InsertEmps(@RequestBody List<Emp> emps) {

    for (Emp emp : emps) {

    }

    service.InsertEmps(emps);
}


    /**
     * 根據id刪除數據
     */

    @DeleteMapping("/{id}")
    void deleteById(@PathVariable int id) {
        service.deleteById(id);
    }


    /**
     * 根據id刪除一條或者多條數據
     */
    @DeleteMapping
void deleteByIds(@RequestBody List<Emp> emps){
        service.deleteByIds(emps);
    }

    /**
     * 查詢總記錄數
     */
    @GetMapping("/count")
    Integer selectCount() {
        Integer count = service.selectCount();
        return count;
    }


    /**
     * 分頁查詢
     */

    @GetMapping("/{currentPage}/{pageSize}")
    public PageBean<Emp> selectByPage(PageBean pageBean) {
        int currentPage = pageBean.getCurrentPage();
        int pageSize = pageBean.getPageSize();


        PageBean<Emp> empPageBean = service.selectByPage(currentPage, pageSize);
        empPageBean.setCurrentPage(currentPage);
        System.out.println("當前頁：" + currentPage);
        empPageBean.setPageSize(pageSize);
        System.out.println("每頁顯示:" + pageSize);
        return empPageBean;
    }


    /**
     * 更新數據
     */
    @PutMapping
    void updateById(@RequestBody Emp emp){
        service.updateById(emp);
    }

    /**
     * 批量更新數據
     */
    @PutMapping("/update")
    void updateByIds(@RequestBody List<Emp> emps){
        service.updateByIds(emps);
    }

    /**
     * 模糊查詢練習,and
     */
    @GetMapping("/fuzzyselect")
    List<Emp>fuzzySelect(@RequestBody Emp emp){
        return service.fuzzySelect(emp);
    }

}
