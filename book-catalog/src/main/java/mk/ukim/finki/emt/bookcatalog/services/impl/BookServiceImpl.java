package mk.ukim.finki.emt.bookcatalog.services.impl;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import mk.ukim.finki.emt.bookcatalog.domain.models.Book;
import mk.ukim.finki.emt.bookcatalog.domain.models.BookID;
import mk.ukim.finki.emt.bookcatalog.domain.repository.BookRepository;
import mk.ukim.finki.emt.bookcatalog.services.BookService;
import mk.ukim.finki.emt.bookcatalog.services.forms.BookForm;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Optional<Book> findById(BookID id) {
        return bookRepository.findById(id);
    }

    @Override
    public Book createProduct(BookForm form) {
        Book product = new Book(form.getBookName(), form.getPrice(), form.getBookAuthor(),form.getSales(), form.getQuantity());
        return bookRepository.saveAndFlush(product);
    }

    @Override
    public Book bookOrdered(BookID id, Integer quantity) {
        Book product = bookRepository.findById(id).orElseThrow(RuntimeException::new);
        product.addSales(quantity);
        return bookRepository.saveAndFlush(product);
    }

    @Override
    public Book bookReturned(BookID id, Integer quantity) {
        Book product = bookRepository.findById(id).orElseThrow(RuntimeException::new);
        product.returnSales(quantity);
        return bookRepository.saveAndFlush(product);
    }


}
