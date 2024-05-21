package mk.ukim.finki.emt.ordermanagement.domain.model;

import jakarta.persistence.*;
import lombok.NonNull;
import mk.ukim.finki.emt.ordermanagement.domain.valueobjects.Book;
import mk.ukim.finki.emt.sharedkernel.domain.base.AbstractEntity;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Currency;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Money;


import java.time.Instant;
import java.util.Objects;
import java.util.Set;
import java.util.HashSet;

@Entity
@Table(name = "orders")
public class Order extends AbstractEntity <OrderId>{
    private Instant  date;
    private String destination;
   // private Money total;
    @Column(name = "order_currency")
    @Enumerated(EnumType.STRING)
    private Currency currency;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<BookItem> bookItemList = new HashSet<>();

    protected Order() {
        super(OrderId.randomId(OrderId.class));
    }
    public Order(Instant now, mk.ukim.finki.emt.sharedkernel.domain.financial.Currency currency,String destination) {
        super(OrderId.randomId(OrderId.class));
        this.date = now;
        this.currency = currency;
        this.destination = destination;
    }///OVAAA ????

    public Money total(){
        return  bookItemList.stream().map(BookItem::subtotal)
                .reduce(new Money(currency,0),Money::add);
    }
    public BookItem addItem(@NonNull Book book, int qty) {
        Objects.requireNonNull(book,"product must not be null");
        var item  = new BookItem(book.getId(), book.getPrice(), qty);
        bookItemList.add(item);
        return item;
    }

    public void removeItem(@NonNull BookItemId bookItemId) {
        Objects.requireNonNull(bookItemId,"Order Item must not be null");
        bookItemList.removeIf(v->v.getId().equals(bookItemId));
    }


}
