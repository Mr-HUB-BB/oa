package com.big_fish.oa.dao;

import com.big_fish.oa.entity.User;
import com.big_fish.oa.utils.MybatisUtils;

/**
 * ClassName: UserDao
 * Description:
 * date: 2022/1/30 1:01
 *
 * @author: 孟家宝
 * @version:
 * @since: JDK 1.8
 */
public class UserDao {
    /**
    * @author 孟家宝
    * @Descrption 按用户名查询用户表
    * @Date 1:07 2022/1/30 
    * @Param [username] 用户名
    * @return com.big_fish.oa.entity.User User包含用户信息，返回null则不存在
    */        
    public User selectByUsername(String username){
        User user = (User) MybatisUtils.executeQuery(session -> session.selectOne("usermapper.selectByUsername",username));
        return user;
    }
}
