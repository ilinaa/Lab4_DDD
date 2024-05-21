package mk.ukim.finki.emt.ordermanagement.domain.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NonNull;
import mk.ukim.finki.emt.ordermanagement.domain.valueobjects.BookId;
import mk.ukim.finki.emt.sharedkernel.domain.base.AbstractEntity;
import mk.ukim.finki.emt.sharedkernel.domain.base.DomainObjectId;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Money;

@Entity
@Table(name = "book_item")
@Getter
public class BookItem extends AbstractEntity<BookItemId> {

    private Money itemPrice;

    @Column(name = "qty", nullable = false)
    private  int quantity;

    @AttributeOverride(name = "id", column = @Column(name = "book_id",
    nullable = false))
    private BookId bookId;

    protected BookItem() {
        super(DomainObjectId.randomId(BookItemId.class));
    }
    public  BookItem(@NonNull BookId bookId, @NonNull Money itemPrice, int qty){
        super(DomainObjectId.randomId(BookItemId.class));
        this.itemPrice = itemPrice;
        this.quantity = qty;
    }



    public Money subtotal(){
        return  itemPrice.multiply(quantity);
    }

}
