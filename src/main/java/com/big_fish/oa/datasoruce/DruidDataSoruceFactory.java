package com.big_fish.oa.datasoruce;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.datasource.unpooled.UnpooledDataSourceFactory;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * ClassName: DruidDataSoruceFactory
 * Description:
 * date: 2022/1/29 20:44
 *
 * @author: 孟家宝
 * @version:
 * @since: JDK 1.8
 */
public class DruidDataSoruceFactory extends UnpooledDataSourceFactory {

    public DruidDataSoruceFactory(){
        this.dataSource=new DruidDataSource();

    }

    @Override
    public DataSource getDataSource() {
        try {
            ((DruidDataSource)this.dataSource).init(); //初始化Druid数据源
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return this.dataSource;
    }
}
