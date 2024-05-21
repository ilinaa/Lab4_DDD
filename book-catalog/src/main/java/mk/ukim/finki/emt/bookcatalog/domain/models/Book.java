package mk.ukim.finki.emt.bookcatalog.domain.models;


//import javax.persistence.EmbeddedId;

import jakarta.persistence.*;
import lombok.Getter;
import mk.ukim.finki.emt.bookcatalog.domain.valueobjects.Quantity;
import mk.ukim.finki.emt.sharedkernel.domain.base.AbstractEntity;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Money;

@Entity
@Table(name = "book")
@Getter
public class Book  extends AbstractEntity<BookID> {

    private String bookName;
    private String bookAuthor;
    private int quantity;

    @AttributeOverrides({
            @AttributeOverride(name="amount", column = @Column(name="price_amount")),
            @AttributeOverride(name="currency", column = @Column(name="price_currency"))
    })
    private Money price;
    private int sales = 0;

    public Book(String bookName, Money price, String bookAuthor, int sales, Quantity quantity) {

    }

    public static Book build(String bookName, String bookAuthor, Money price, int sales, int quantity) {
        Book p = new Book();
        p.price = price;
        p.bookName = bookName;
        p.bookAuthor = bookAuthor;
        p.sales = sales;
        p.quantity = quantity;
        return p;
    }

    //    @Override
//    @EmbeddedId
//    public BookID getId() {
//        return super.getId();
//    }
    public Book() {
        super(BookID.randomId(BookID.class));
    }

    public void addSales(int qty) {
        this.sales += qty;
    }
    public void returnSales(int qty) {
        this.sales -= qty;
    }
}
