package top.ccheng.sorm.core;
import top.ccheng.sorm.bean.Configuration;

import java.io.IOException;
import java.util.Properties;

/**
 * @author ccheng
 * @date 2018/9/6
 * 装载者，对框架进行初始化
 */
public class Loader {

    public static Configuration config;

    static {
        loadConfig();
    }

    /**
     * 装载配置信息
     */
    private static void loadConfig(){
        Properties properties = new Properties();
        try {
            properties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("db.properties"));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("装载配置文件失败！");
            System.exit(0);
        }
        config = new top.ccheng.sorm.bean.Configuration();
        config.setJdbcType(properties.getProperty("jdbc.type"));
        config.setJdbcDriver(properties.getProperty("jdbc.driver"));
        config.setJdbcUrl(properties.getProperty("jdbc.url"));
        config.setJdbcUser(properties.getProperty("jdbc.user"));
        config.setJdbcPwd(properties.getProperty("jdbc.pwd"));
        config.setJdbcPoolMinSize(Integer.parseInt(properties.getProperty("jdbc.pool.minSize")));
        config.setJdbcPoolMaxSize(Integer.parseInt(properties.getProperty("jdbc.pool.maxSize")));
        config.setSrcPath(properties.getProperty("srcPath"));
        config.setPoPackage(properties.getProperty("poPackage"));
    }

}
