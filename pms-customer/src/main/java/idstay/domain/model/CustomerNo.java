package idstay.domain.model;



import idstay.domain.support.IDGenerator;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@ToString @EqualsAndHashCode
public class CustomerNo implements Serializable {
    @Column(name="CUSTOMER_NO")
    private String customerNo;

    private CustomerNo(final String customerNo) {
        this.customerNo = customerNo;
    }
    public static CustomerNo of(String id) {
        return new CustomerNo(id);
    }
    public static CustomerNo gen() {
        return new CustomerNo(IDGenerator.newId());
    }

    CustomerNo() {}
}
