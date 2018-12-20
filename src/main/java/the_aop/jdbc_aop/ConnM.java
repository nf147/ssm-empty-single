package the_aop.jdbc_aop;

import java.sql.Connection;

public class ConnM {
    public static ThreadLocal<Connection> threadLocal = null;

    public static Connection getConn() {
        return threadLocal.get();
    }
}
