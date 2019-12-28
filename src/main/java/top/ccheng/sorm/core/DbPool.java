package top.ccheng.sorm.core;

import top.ccheng.sorm.util.CloseUtil;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;

/**
 * @author ccheng
 * @date 2018/9/6
 * 数据库连接池
 */
public class DbPool {

    private static LinkedList<Connection> dbPool = null;
    private static int poolSize = 0;

    /**
     * 从连接池中获取一个数据库连接
     */
    static Connection getConnection(){
        if(null == dbPool){
            synchronized (DbPool.class) {
                initPool();
            }
        }

        Connection connection;
        if(dbPool.size() > 0) {
            connection = dbPool.removeFirst();
        }else {
            if (poolSize < Loader.config.getJdbcPoolMaxSize()){
                connection = createConnection();
            }else{
                throw new RuntimeException("数据库繁忙，超过最大数据库连接数");
            }
        }

        return buildConnectionProxy(connection);
    }

    /**
     * 初始化连接池
     */
    private static void initPool(){
        if (null != dbPool){
            return;
        }
        try {
            Class.forName(Loader.config.getJdbcDriver());
            dbPool = new LinkedList<>();
            while (dbPool.size() < Loader.config.getJdbcPoolMinSize()){
                dbPool.add(createConnection());
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 创建一个数据库连接
     * @return 数据库连接
     */
    private static Connection createConnection(){
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(Loader.config.getJdbcUrl(), Loader.config.getJdbcUser(), Loader.config.getJdbcPwd());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        poolSize++;
        return connection;
    }

    /**
     * 创建一个连接代理，目的是控制close方法的访问，当调用close方法时，把连接放回连接池
     * @param connection 真实的数据库连接
     * @return 连接代理
     */
    private static Connection buildConnectionProxy(final Connection connection){
        if (null == connection){
            return null;
        }
        return (Connection) Proxy.newProxyInstance(connection.getClass().getClassLoader(), connection.getClass().getInterfaces(), (proxy, method, args) -> {
            if ("close".equals(method.getName())){
                closeConnection(connection);
                return null;
            }else {
                return method.invoke(connection,args);
            }
        });
    }

    /**
     * 关闭一个连接，把连接放回连接池
     */
    private static void closeConnection(Connection connection){
        if (dbPool.size() >= Loader.config.getJdbcPoolMaxSize()){
            CloseUtil.close(connection);
            poolSize--;
        }else {
            dbPool.add(connection);
        }
    }

}
