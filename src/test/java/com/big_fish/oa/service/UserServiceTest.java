package com.big_fish.oa.service;

import com.big_fish.oa.entity.Node;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * ClassName: UserServiceTest
 * Description:
 * date: 2022/1/30 1:26
 *
 * @author: 孟家宝
 * @version:
 * @since: JDK 1.8
 */
public class UserServiceTest {
    private UserService userService = new UserService();
    /**
    * @author 孟家宝
    * @Descrption 用户名不存在
    * @Date 1:28 2022/1/30 
    * @Param []
    * @return void
    */        
    @Test
    public void checkLogin1() {
        userService.checkLogin("uu","1234");
    }
    /**
    * @author 孟家宝
    * @Descrption 密码错误
    * @Date 1:29 2022/1/30 
    * @Param []
    * @return void
    */        
    @Test
    public void checkLogin2() {
        userService.checkLogin("m8","1234");
    }
    /**
    * @author 孟家宝
    * @Descrption 正常登录
    * @Date 1:34 2022/1/30
    * @Param []
    * @return void
    */        
    @Test
    public void checkLogin3() {
        userService.checkLogin("m8","test");
    }

    @Test
    public void test(){
        List<Node> list = userService.selectNodeById(5l);
        for (Node n :
                list) {
            System.out.println(n.getNodeName());
        }
    }
}