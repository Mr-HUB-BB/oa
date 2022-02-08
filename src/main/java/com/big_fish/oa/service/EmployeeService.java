package com.big_fish.oa.service;

import com.big_fish.oa.dao.EmployeeDao;
import com.big_fish.oa.entity.Employee;
import com.big_fish.oa.utils.MybatisUtils;

/**
 * ClassName: EmployeeService
 * Description: 员工相关的Service
 * date: 2022/2/4 23:59
 *
 * @author: 孟家宝
 * @version:
 * @since: JDK 1.8
 */
public class EmployeeService {
    public Employee selectById(Long employeeId){
       return(Employee) MybatisUtils.executeQuery(session -> {
            EmployeeDao employeeDao = session.getMapper(EmployeeDao.class);
           return employeeDao.employeeSelectById(employeeId);
        });
    }
}
