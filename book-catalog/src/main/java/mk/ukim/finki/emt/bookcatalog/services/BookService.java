package mk.ukim.finki.emt.bookcatalog.services;

import mk.ukim.finki.emt.bookcatalog.domain.models.Book;
import mk.ukim.finki.emt.bookcatalog.domain.models.BookID;
import mk.ukim.finki.emt.bookcatalog.services.forms.BookForm;

import java.util.List;
import java.util.Optional;

public interface BookService {
    List<Book> findAll();
    Optional<Book> findById(BookID id);
    Book createProduct(BookForm form);
    Book bookOrdered(BookID id, Integer quantity);
    Book bookReturned(BookID id, Integer quantity);
}
