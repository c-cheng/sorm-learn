package top.ccheng.sorm.type;

/**
 * @author ccheng
 * @date 2018/9/5
 * 键类型
 */
public enum  KeyTypeEnum {
    /**
     * 主键
     */
    PRIMARY("PRIMARY","主键"),
    /**
     * 外键
     */
    FOREIGN("FOREIGN","外键")
    ;

    private String code;
    private String name;

    KeyTypeEnum(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public KeyTypeEnum fromCode(String code){
        for (KeyTypeEnum typeEnum : values()) {
            if (typeEnum.getCode().equals(code)){
                return typeEnum;
            }
        }
        return null;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
}
