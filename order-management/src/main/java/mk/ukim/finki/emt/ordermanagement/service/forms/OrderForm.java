package mk.ukim.finki.emt.ordermanagement.service.forms;

import lombok.Data;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Currency;


import java.util.ArrayList;
import java.util.List;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Data
public class OrderForm {
    @NotNull
    private Currency currency;

    @Valid
    @NotEmpty
    private List<BookItemForm> items = new ArrayList<>();
}
