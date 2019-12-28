package top.ccheng.sorm.core;

import top.ccheng.sorm.bean.TableInfo;
import top.ccheng.sorm.util.CloseUtil;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

/**
 * 持有数据库表信息的上下文
 * @author ccheng
 * @date 2018/9/5
 */
public class TableContext {
    /**
     * 所有表信息
     * key-表名
     * value-表信息
     */
    private static Map<String, TableInfo> tableMap = new HashMap<String, TableInfo>();

    static {
        Connection connection = null;
        try {
            connection = DbManager.getConnection();
            DatabaseMetaData metaData = connection.getMetaData();
            ResultSet tables = metaData.getTables(null, "%", "%", new String[]{"TABLE"});
            while (tables.next()){
                String tableName = tables.getString("TABLE_NAME");
                ResultSet columns = metaData.getColumns(null, "%", tableName, "%");
                while (columns.next()){
                    ResultSetMetaData metaData1 = columns.getMetaData();
                    String columnName = columns.getString("COLUMN_NAME");
                }
                System.out.println(tableName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            CloseUtil.close(connection);
        }
    }

    public static TableInfo getTableInfo(String tableName){
        return tableMap.get(tableName);
    }

    public static TableInfo getTableInfo(Class clazz){
        return tableMap.get(clazz.getName());
    }
}
