package mk.ukim.finki.emt.ordermanagement.service;

import mk.ukim.finki.emt.ordermanagement.domain.model.BookItemId;
import mk.ukim.finki.emt.ordermanagement.domain.model.Order;
import mk.ukim.finki.emt.ordermanagement.domain.model.OrderId;
import mk.ukim.finki.emt.ordermanagement.service.forms.BookItemForm;
import mk.ukim.finki.emt.ordermanagement.service.forms.OrderForm;

import java.util.List;
import java.util.Optional;

public interface OrderService {
   // OrderId placeOrder (OrderForm orderForm);

    List<Order> findAll();

    Optional<Order> findById(OrderId id);

    void addItem(OrderId orderId, BookItemForm bookItemForm) ;

    void deleteItem(OrderId orderId, BookItemId bookItemId);

}
