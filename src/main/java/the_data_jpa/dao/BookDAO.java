package the_data_jpa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import the_data_jpa.entity.Book;

public interface BookDAO extends JpaRepository<Book, Integer> {

    Book findByNameAndPrice(String name, float price);

}
