package the.jdbc_aop;


import org.springframework.stereotype.Component;

import java.sql.SQLException;

// 设计，该怎么写
@Component
public class UserDAO {
    public void save(String name) throws SQLException {
        // 主干代码如果能这么简单该多好啊
        ConnM.getConn().createStatement()
            .execute("insert into t_user (name) values ('" + name + "')");

        // 主干代码如果能这么简单该多好啊
        ConnM.getConn().createStatement()
                .execute("insert into t_user2 (name) values ('" + name + "')");
    }

    // Connection.close() statement.close()
    // Statement.close()  resultset.close()
}
