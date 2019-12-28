package top.ccheng.sorm.core;

/**
 * @author chencheng
 * @date 2018/9/5
 * 提供Java数据类型与数据库数据类型的转换
 */
public interface TypeConvertor {

    /**
     * 给定一个Java类型名称，返回对应的数据库类型名称
     * @param javaType Java类型名称
     * @return 数据库类型名称
     */
    public String javaType2DbType(String javaType);

    /**
     * 给定一个数据库类型名称，返回对应的Java类型名称
     * @param dbType 数据库类型名称
     * @return Java类型名称
     */
    public String dbType2JavaType(String dbType);
}
