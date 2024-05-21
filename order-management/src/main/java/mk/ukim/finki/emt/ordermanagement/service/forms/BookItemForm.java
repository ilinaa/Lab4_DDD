package mk.ukim.finki.emt.ordermanagement.service.forms;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import mk.ukim.finki.emt.ordermanagement.domain.valueobjects.Book;

@Data

public class BookItemForm {
    @NotNull
    private Book book;

    @Min(1)
    private int quantity = 1;
}
