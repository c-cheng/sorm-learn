package top.ccheng.sorm.core;

import com.mysql.cj.protocol.Resultset;
import top.ccheng.sorm.bean.Configuration;
import top.ccheng.sorm.util.CloseUtil;

import java.io.Closeable;
import java.io.IOException;
import java.sql.*;

/**
 * @author ccheng
 * @date 2018/9/5
 * 管理数据库连接相关
 */
public class DbManager {

    /**
     * 获取一个数据库连接
     * @return 数据库连接
     */
    public static Connection getConnection() {
        return DbPool.getConnection();
    }

    /**
     * 关闭一个数据库连接
     * @param connection 数据库连接
     */
    public static void closeConnection(Connection connection){
        CloseUtil.close(connection);
    }

    /**
     * 关闭一个数据库连接
     * @param connection 数据库连接
     * @param statement 连接声明
     */
    public static void closeStatement(Connection connection, Statement statement){
        CloseUtil.close(connection, statement);
    }

    /**
     * 关闭一个数据库连接
     * @param connection 数据库连接
     * @param statement 连接声明
     * @param resultSet 结果集
     */
    public static void closeStatement(Connection connection, Statement statement, ResultSet resultSet){
        CloseUtil.close(connection, statement, resultSet);
    }

}
