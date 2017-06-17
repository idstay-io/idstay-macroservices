package idstay.domain.model;


import lombok.Data;
import lombok.Getter;
import lombok.ToString;
import org.apache.commons.lang3.Validate;

import javax.persistence.*;

@Entity
@Table(name="CUSTOMER")
@Data
@ToString
public class Customer {
    @Id
    private CustomerNo customerNo;

    @GeneratedValue
    private Long id;
    private String fullname;
    private String email;

    private CustomerProfile profile;

    public Customer email(String email) {
        this.email = email;
        return this;
    }

    Customer() {
        //Needed by hibernate
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
