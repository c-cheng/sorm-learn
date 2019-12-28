package top.ccheng;

import top.ccheng.sorm.bean.TableInfo;
import top.ccheng.sorm.core.DbManager;
import top.ccheng.sorm.core.TableContext;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {
        TableInfo user = TableContext.getTableInfo("user");
        System.out.println(user);
    }
}
