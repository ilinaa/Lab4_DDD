package mk.ukim.finki.emt.bookcatalog.config;

import jakarta.annotation.PostConstruct;
import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import mk.ukim.finki.emt.bookcatalog.domain.models.Book;
import mk.ukim.finki.emt.bookcatalog.domain.repository.BookRepository;
import mk.ukim.finki.emt.bookcatalog.domain.valueobjects.Quantity;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Currency;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Money;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@AllArgsConstructor
public class DataInitializer {
    private final BookRepository bookRepository;


    @PostConstruct
    public void initData(){
        Book b1 = Book.build("Clean code","Robert Cecil Martin", Money.valueOf(Currency.MKD, 1400),  5,20);
        Book b2 = Book.build("Designing Data-Intensive Applications","Martin Kleppmann", Money.valueOf(Currency.MKD, 3500),  10,30);

        if(bookRepository.findAll().isEmpty()){
            bookRepository.saveAll(Arrays.asList(b1, b2));
        }

    }
}
