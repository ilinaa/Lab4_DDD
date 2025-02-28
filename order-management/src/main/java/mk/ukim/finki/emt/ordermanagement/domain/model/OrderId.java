package mk.ukim.finki.emt.ordermanagement.domain.model;

import mk.ukim.finki.emt.sharedkernel.domain.base.DomainObjectId;

public class OrderId extends DomainObjectId {

    private OrderId() {
        super(OrderId.randomId(OrderId.class).getId());
    }

    public OrderId(String uuid) {
        super(uuid);
    }

}
