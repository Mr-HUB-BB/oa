package com.big_fish.oa.service;

import com.big_fish.oa.dao.RbacDao;
import com.big_fish.oa.dao.UserDao;
import com.big_fish.oa.entity.Node;
import com.big_fish.oa.entity.User;
import com.big_fish.oa.service.exception.BussinessException;

import java.util.List;

/**
 * ClassName: UserService
 * Description:
 * date: 2022/1/30 1:08
 *
 * @author: 孟家宝
 * @version:
 * @since: JDK 1.8
 */
public class UserService {
    private UserDao userDao = new UserDao();
    private RbacDao rbacDao = new RbacDao();
    public User checkLogin(String username,String password){
        User user = (User)userDao.selectByUsername(username);
        if(user == null){ //如果用户不存在抛出用户不存在异常
            throw new BussinessException("L001","用户名不存在");
        }

        if(!password.equals(user.getPassword())){ //密码错误
            throw new BussinessException("LOO2","密码错误");
        }
        return user; // 检查成功允许登录
    }
    public List<Node> selectNodeById(Long userId){
        List<Node> list = rbacDao.selectNodeById(userId);
        return list;
    }
}
