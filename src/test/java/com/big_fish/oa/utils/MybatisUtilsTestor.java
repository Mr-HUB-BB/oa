package com.big_fish.oa.utils;

import org.junit.Test;

/**
 * ClassName: MybatisUtilsTestor
 * Description:
 * date: 2022/1/29 20:18
 *
 * @author: 孟家宝
 * @version:
 * @since: JDK 1.8
 */

public class MybatisUtilsTestor {
    /**
    * @author 孟家宝
    * @Descrption 测试utils工具类，返回Success为成功
    * @Date 20:44 2022/1/29
    * @Param []
    * @return void
    */        
    @Test
    public void testcase1(){
        String s1 = (String)MybatisUtils.executeQuery(session -> {
            String s = (String) session.selectOne("test.sample");
            return s;
        });
        System.out.println(s1);
    }
}
