package the_data_jpa.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import the_data_jpa.entity.Student;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

@Repository
public class StudentDAO {

    @Autowired
    EntityManagerFactory emf;

    public void save(Student student) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        em.persist(student);

        em.getTransaction().commit();
        em.close();
    }

    public void delete(Student student) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        em.persist(student);

        em.getTransaction().commit();
        em.close();
    }

}
