package the_data_jpa;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import the_data_jpa.entity.Book;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

        BookServcie bean = context.getBean(BookServcie.class);
        Book book = bean.findBookByCond("jQuery", 33f);
        System.out.println(book);
    }
}
