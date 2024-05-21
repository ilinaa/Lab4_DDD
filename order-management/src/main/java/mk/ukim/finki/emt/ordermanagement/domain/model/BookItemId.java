package mk.ukim.finki.emt.ordermanagement.domain.model;

import jakarta.persistence.Entity;
import mk.ukim.finki.emt.sharedkernel.domain.base.DomainObjectId;


public class BookItemId extends DomainObjectId {
    protected   BookItemId (){
        super(BookItemId.randomId(BookItemId.class).getId());
    }
    public BookItemId(String uuid) {
        super(uuid);
    }

}
