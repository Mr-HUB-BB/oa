package com.big_fish.oa.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.function.Function;

/**
 * ClassName: MybatisUtils
 * Description:
 * date: 2022/1/29 19:37
 *
 * @author: 孟家宝
 * @version: 对Mybatis进行初始化工作：
 * 0.完成全局唯一SqlSessionFactory对象初始化
 * 1. 当第一次调用完成SqlSessionFactory初始化工作
 * 2. 使用完成后自动断开、回收数据库连接释放资源
 * @since: JDK 1.8
 */
public class MybatisUtils {
    private static SqlSessionFactory sqlSessionFactory = null; //全局唯一对象
    //在初始化类的时候进行SqlSessionFactory实例化
    static {
        Reader reader = null;
        try {
            reader= Resources.getResourceAsReader("mybatis-config.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (IOException e) {
            //出现异常的时候抛出异常通知调用者
            throw new ExceptionInInitializerError(e);
        }
    }
/**
* @author 孟家宝
* @Descrption 执行指定的sql用于数据的查询
* @Date 19:48 2022/1/29
* @Param [func] 函数式接口,要执行查询语句的代码块
* @return java.lang.Object
*/
    public static Object executeQuery(Function<SqlSession,Object> func){
        SqlSession session = sqlSessionFactory.openSession();
        try {
            Object obj = func.apply(session);
            return obj;
        } finally {
            session.close();
        }
    }
    /**
    * @author 孟家宝
    * @Descrption 执行INSERT/UPDATE/DELETE写操作SQL
    * @Date 20:35 2022/1/29 
    * @Param [func] 要执行的代码
    * @return java.lang.Object 写操作的饭后结果
    */        
    public static Object executeUpdate(Function<SqlSession,Object> func){
        SqlSession session = sqlSessionFactory.openSession(false);
        try {
            Object obj = func.apply(session);
            session.commit();
            return obj;
        }catch (RuntimeException e){
           session.rollback();
           throw e;
        }finally {
            session.close();
        }
    }
}
