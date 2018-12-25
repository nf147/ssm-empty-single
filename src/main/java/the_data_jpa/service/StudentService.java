package the_data_jpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import the_data_jpa.dao.StudentDAO;
import the_data_jpa.entity.Student;


@Service
@Transactional
public class StudentService {

    @Autowired
    StudentDAO studentDAO;

    public void saveStudent() {
        Student student = new Student();
        student.setName("abc");

        studentDAO.save(student);
    }

}
