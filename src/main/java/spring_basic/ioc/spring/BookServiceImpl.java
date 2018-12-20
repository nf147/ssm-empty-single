package spring_basic.ioc.spring;

public class BookServiceImpl implements BookService {

    private BookDAO bookDAO;

    @Override
    public void sayHello() {
        // 这个类要解决问题，要解决的是企业级的问题
        // 所以，按理来说，他会很大
        // 上千行，上万行都有可能
        // 逻辑复杂，初始化也复杂
        System.out.println("Hello world !!!");
    }

    public BookDAO getBookDAO() {
        return bookDAO;
    }

    public void setBookDAO(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }
}
