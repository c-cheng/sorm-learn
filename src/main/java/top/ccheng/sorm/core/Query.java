package top.ccheng.sorm.core;

import java.util.List;

/**
 * @author chencheng
 * @date 2018/9/5
 * 对SQL执行的封装
 */
public interface Query {
    /**
     * 执行给定的SQL，返回受影响的行数
     * @param sql 给定的SQL
     * @param params SQL需要的参数
     * @return 数据库中受影响的行数
     */
    public int execute(String sql, Object... params);

    /**
     * 将指定对象存储到数据库中
     * @param obj 需要存储的对象
     * @return 是否更新成功
     */
    public boolean insert(Object obj);

    /**
     * 将指定对象从数据库中删除
     * @param obj 需要删除的对象
     * @return 是否更新成功
     */
    public boolean delete(Object obj);

    /**
     * 根据ID从数据库中删除指定类型的数据
     * @param clazz 给定的数据类型，与数据库中的表对应的class类
     * @param id 主键ID
     * @return 是否更新成功
     */
    public boolean delete(Class clazz, Object id);

    /**
     * 根据指定的字段列表将对象更新到数据库
     * @param obj 对象值
     * @param fieldNames 需要更新到数据库的字段名称列表
     * @return 是否更新成功
     */
    public boolean update(Object obj, String... fieldNames);

    /**
     * 从数据库中查询多行记录，并封装成指定实体类的list
     * @param sql 查询SQL
     * @param clazz 实体类对应的class
     * @param params SQL参数
     * @return 查询结果
     */
    public <T> List<T> queryForList(String sql , Class<T> clazz, Object... params);

    /**
     * 从数据库中查询一行记录，并封装成指定实体类
     * @param sql 查询SQL
     * @param clazz 实体类对应的class
     * @param params SQL参数
     * @return 查询结果
     */
    public <T> T queryForEntity(String sql, Class<T> clazz, Object... params);

    /**
     * 从数据库中查询指定类型的一个值（一行一列）
     * @param sql 查询SQL
     * @param clazz 值对应的class
     * @param params SQL参数
     * @return 结果值
     */
    public <T> T queryForValue(String sql, Class<T> clazz, Object... params);
}
