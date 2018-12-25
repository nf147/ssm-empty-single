package the_data_jpa.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import the_data_jpa.dao.BookDAO;
import the_data_jpa.entity.Book;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    private BookDAO bookDAO;

    public Optional<Book> getBookById() {
        Optional<Book> book = bookDAO.findById(3);
        System.out.println(book);
        return book;
    }

    public Book findBookByCond(String name, float price) {
        return bookDAO.findByNameAndPrice(name, price);
    }

    public Book findByName(String name) {
        return bookDAO.findByName(name);
    }

    public Book findFuzzy() {
        return bookDAO.findwoyebuzhidaozenmshuo();
    }

    public List<Book> listCond(String name, float price) {
        return bookDAO.findByNameOrPrice(name, price);
    }

}
