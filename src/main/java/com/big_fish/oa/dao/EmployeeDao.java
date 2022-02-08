package com.big_fish.oa.dao;

import com.big_fish.oa.entity.Employee;

/**
 * ClassName: EmployeeDao
 * Description: 员工数据查询接口
 * date: 2022/2/4 23:53
 *
 * @author: 孟家宝
 * @version:
 * @since: JDK 1.8
 */
public interface EmployeeDao {
    /**
    * @author 孟家宝
    * @Descrption 通过id查找员工对象
    * @Date 23:55 2022/2/4 
    * @Param [employeeId 员工编号]
    * @return com.big_fish.oa.entity.Employee 员工实体类
    */        
    public Employee employeeSelectById(Long employeeId);
}
