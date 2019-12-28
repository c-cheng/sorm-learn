package top.ccheng.sorm.bean;

/**
 * @author ccheng
 * @date 2018/9/5
 * 封装了配置信息 
 */
public class Configuration {
    /**
     * 数据库类型
     */
    private String jdbcType;
    /**
     * 数据库驱动全包名
     */
    private String jdbcDriver;
    /**
     * 数据库连接URL
     */
    private String jdbcUrl;
    /**
     * 数据库用户名
     */
    private String jdbcUser;
    /**
     * 数据库密码
     */
    private String jdbcPwd;
    /**
     * 数据库连接池最小数量
     */
    private int jdbcPoolMinSize;
    /**
     * 数据库连接池最大数量
     */
    private int jdbcPoolMaxSize;
    /**
     * 源码路径
     */
    private String srcPath;
    /**
     * 生成的po对应的包名
     */
    private String poPackage;

    public String getJdbcType() {
        return jdbcType;
    }

    public void setJdbcType(String jdbcType) {
        this.jdbcType = jdbcType;
    }

    public String getJdbcDriver() {
        return jdbcDriver;
    }

    public void setJdbcDriver(String jdbcDriver) {
        this.jdbcDriver = jdbcDriver;
    }

    public String getJdbcUrl() {
        return jdbcUrl;
    }

    public void setJdbcUrl(String jdbcUrl) {
        this.jdbcUrl = jdbcUrl;
    }

    public String getJdbcUser() {
        return jdbcUser;
    }

    public void setJdbcUser(String jdbcUser) {
        this.jdbcUser = jdbcUser;
    }

    public String getJdbcPwd() {
        return jdbcPwd;
    }

    public void setJdbcPwd(String jdbcPwd) {
        this.jdbcPwd = jdbcPwd;
    }

    public int getJdbcPoolMinSize() {
        return jdbcPoolMinSize;
    }

    public void setJdbcPoolMinSize(int jdbcPoolMinSize) {
        this.jdbcPoolMinSize = jdbcPoolMinSize;
    }

    public int getJdbcPoolMaxSize() {
        return jdbcPoolMaxSize;
    }

    public void setJdbcPoolMaxSize(int jdbcPoolMaxSize) {
        this.jdbcPoolMaxSize = jdbcPoolMaxSize;
    }

    public String getSrcPath() {
        return srcPath;
    }

    public void setSrcPath(String srcPath) {
        this.srcPath = srcPath;
    }

    public String getPoPackage() {
        return poPackage;
    }

    public void setPoPackage(String poPackage) {
        this.poPackage = poPackage;
    }
}
