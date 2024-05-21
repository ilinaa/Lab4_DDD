package mk.ukim.finki.emt.bookcatalog.domain.models;

import lombok.NoArgsConstructor;
import mk.ukim.finki.emt.sharedkernel.domain.base.DomainObjectId;
import org.springframework.lang.NonNull;
//import javax.persistence.Embeddable;


public class BookID extends DomainObjectId {
    protected BookID() {
        super(BookID.randomId(BookID.class).getId());
    }


    public BookID(@NonNull String uuid) {
        super(uuid);
    }


//OVAAA
    public static BookID of(String uuid) {
        BookID p = new BookID(uuid);
        return p;
    }




}
