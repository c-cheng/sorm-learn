package top.ccheng.sorm.util;

import java.io.Closeable;

/**
 * @author ccheng
 * @date 2018/9/6
 */
public class CloseUtil {

    public static void close(Closeable closeable){
        if (null != closeable){
            try {
                closeable.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void close(Closeable... closeables){
        if (null != closeables && closeables.length > 0){
            for (Closeable closeable : closeables) {
                close(closeable);
            }
        }
    }

    public static void close(AutoCloseable closeable){
        if (null != closeable){
            try {
                closeable.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void close(AutoCloseable... closeables){
        if (null != closeables && closeables.length > 0){
            for (AutoCloseable closeable : closeables) {
                close(closeable);
            }
        }
    }
}
