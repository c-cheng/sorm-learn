package top.ccheng.sorm.bean;

/**
 * @author ccheng
 * @date 2018/9/5
 * 封装了表中一个字段信息
 */
public class ColumnInfo {
    /**
     * 字段名
     */
    private String name;

    /**
     * 数据类型
     */
    private String dataType;

    /**
     * 键类型(KeyTypeEnum)
     */
    private String keyType;

    public ColumnInfo() {

    }                                                                 

    public ColumnInfo(String name, String dataType, String keyType) {
        this.name = name;
        this.dataType = dataType;
        this.keyType = keyType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public String getKeyType() {
        return keyType;
    }

    public void setKeyType(String keyType) {
        this.keyType = keyType;
    }
}
