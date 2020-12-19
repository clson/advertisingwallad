package utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

//jdbcTemplate
public class ConnectDatabase {
    private static DataSource ds;
    static {
        try {
            //加载配置文件
            Properties properties = new Properties();
            properties.load(ConnectDatabase.class.getClassLoader().getResourceAsStream("druid.properties"));
            //初始化连接池对象
            ds= DruidDataSourceFactory.createDataSource(properties);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }
    public static DataSource getDataSource(){
        return ds;
    }
}
