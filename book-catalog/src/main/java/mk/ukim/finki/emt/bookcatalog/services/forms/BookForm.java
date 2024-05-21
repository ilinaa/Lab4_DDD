package mk.ukim.finki.emt.bookcatalog.services.forms;

import lombok.Data;
import mk.ukim.finki.emt.bookcatalog.domain.valueobjects.Quantity;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Money;

@Data
public class BookForm {

    private String bookName;
    private String bookAuthor;
    private Quantity quantity;
    private Money price;
    private int sales;

}
