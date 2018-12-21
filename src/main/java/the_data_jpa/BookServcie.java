package the_data_jpa;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import the_data_jpa.dao.BookDAO;
import the_data_jpa.entity.Book;

import java.util.Optional;

@Service
public class BookServcie {
    @Autowired
    private BookDAO bookDAO;

    public Optional<Book> getBookById () {
        Optional<Book> book = bookDAO.findById(3);
        System.out.println(book);
        return book;
    }

    public Book findBookByCond(String name, float price) {
        return bookDAO.findByNameAndPrice(name, price);
    }

}
