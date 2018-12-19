package the.jdbc_aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

        UserDAO userDAO = context.getBean(UserDAO.class);
        userDAO.save("tttt");
    }
}
