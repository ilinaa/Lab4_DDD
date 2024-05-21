package mk.ukim.finki.emt.ordermanagement.service.impl;


import jakarta.transaction.Transactional;
import jakarta.validation.Validator;
import lombok.AllArgsConstructor;
import mk.ukim.finki.emt.ordermanagement.domain.model.BookItemId;
import mk.ukim.finki.emt.ordermanagement.domain.model.Order;
import mk.ukim.finki.emt.ordermanagement.domain.model.OrderId;
import mk.ukim.finki.emt.ordermanagement.domain.repository.OrderRepository;
import mk.ukim.finki.emt.ordermanagement.service.OrderService;
import mk.ukim.finki.emt.ordermanagement.service.forms.BookItemForm;
import mk.ukim.finki.emt.ordermanagement.service.forms.OrderForm;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class OrderServiceImpl  implements OrderService {
    private final OrderRepository orderRepository;
    //private final DomainEventPublisher domainEventPublisher;

//    @Override
//    public OrderId placeOrder(OrderForm orderForm) {
//        Objects.requireNonNull(orderForm,"order must not be null.");
//        var constraintViolations = validator.validate(orderForm);
//        if (constraintViolations.size()>0) {
//            throw new RuntimeException();
//        }
//        var newOrder = orderRepository.saveAndFlush(toDomainObject(orderForm));
//
//        return newOrder.getId();
//    }

    @Override
    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public Optional<Order> findById(OrderId id) {
        return orderRepository.findById(id);
    }

    @Override
    public void addItem(OrderId orderId, BookItemForm bookItemForm) {
        Order order = orderRepository.findById(orderId).orElseThrow(RuntimeException::new);
        order.addItem(bookItemForm.getBook(),bookItemForm.getQuantity());
        orderRepository.saveAndFlush(order);
      //  domainEventPublisher.publish(new OrderItemCreated(orderItemForm.getProduct().getId().getId(),orderItemForm.getQuantity()));
    }

    @Override
    public void deleteItem(OrderId orderId, BookItemId bookItemId) {
        Order order = orderRepository.findById(orderId).orElseThrow(RuntimeException::new);
        order.removeItem(bookItemId);
        orderRepository.saveAndFlush(order);
    }
//    private Order toDomainObject(OrderForm orderForm) {
//        var order = new Order(Instant.now(),orderForm.getCurrency());
//        orderForm.getItems().forEach(item->order.addItem(item.getBook(),item.getQuantity()));
//        return order;
//    }
}
