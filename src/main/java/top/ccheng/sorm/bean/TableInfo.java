package top.ccheng.sorm.bean;

import java.util.List;
import java.util.Map;

/**
 * @author ccheng
 * @date 2018/9/5
 * 封装了一个表结构信息
 */
public class TableInfo {
    /**
     * 表名
     */
    private String tName;

    /**
     * 主键
     */
    private ColumnInfo primaryKey;

    /**
     * 联合主键
     */
    private List<ColumnInfo> unionKey;

    /**
     * 所有字段
     */
    private Map<String, ColumnInfo> columns;

    public TableInfo() {
    }

    public TableInfo(String tName, ColumnInfo primaryKey, List<ColumnInfo> unionKey, Map<String, ColumnInfo> columns) {
        this.tName = tName;
        this.primaryKey = primaryKey;
        this.unionKey = unionKey;
        this.columns = columns;
    }

    public String gettName() {
        return tName;
    }

    public void settName(String tName) {
        this.tName = tName;
    }

    public ColumnInfo getPrimaryKey() {
        return primaryKey;
    }

    public void setPrimaryKey(ColumnInfo primaryKey) {
        this.primaryKey = primaryKey;
    }

    public List<ColumnInfo> getUnionKey() {
        return unionKey;
    }

    public void setUnionKey(List<ColumnInfo> unionKey) {
        this.unionKey = unionKey;
    }

    public Map<String, ColumnInfo> getColumns() {
        return columns;
    }

    public void setColumns(Map<String, ColumnInfo> columns) {
        this.columns = columns;
    }
}
