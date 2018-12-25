package the_data_jpa;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import the_data_jpa.service.StudentService;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
//
//        BookServcie bean = context.getBean(BookServcie.class);
//        List<Book> book = bean.listCond("jQuery", 121);

        // System.out.println(book1);
        //System.out.println(war_and_peace.getPrice());

        StudentService servcie = context.getBean(StudentService.class);
        servcie.saveStudent();
    }
}
