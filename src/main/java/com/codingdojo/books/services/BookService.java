package com.codingdojo.books.services;
        import com.codingdojo.books.models.book;
        import com.codingdojo.books.repositories.BookRepository;
        import org.springframework.stereotype.Service;
        import java.util.List;
        import java.util.Optional;

@Service
public class BookService {
    // adding the book repository as a dependency
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // returns all the books
    public List<book> allBooks() {
        return bookRepository.findAll();
    }

    // creates a book
    public book createBook(book b) {
        return bookRepository.save(b);
    }

    // retrieves a book
    public book findBook(Long id) {
        Optional<book> optionalBook = bookRepository.findById(id);
        if (optionalBook.isPresent()) {
            return optionalBook.get();
        } else {
            return null;
        }
    }
    public book updateBook(long id, String title, String desc, String lang, int numOfPages) {
        Optional<book> optionalBook = bookRepository.findById(id);
        if (optionalBook.isPresent()) {
            book book=optionalBook.get();
            book.setTitle(title);
            book.setDescription(desc);
            book.setLanguage(lang);
            book.setNumberOfPages(numOfPages);
            bookRepository.save(book);
            return book;
        } else {
            return null;
        }
    }
    public void deleteBook(long id){
        Optional<book> optionalBook = bookRepository.findById(id);
        if (optionalBook.isPresent()) {
            bookRepository.deleteById(id);
        }

    }
}
