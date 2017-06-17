package idstay.application;

import idstay.domain.model.Customer;
import idstay.domain.model.CustomerNo;

/**
 * Created by min on 5/3/17.
 */
public interface CustomerService {
    Customer getCustomer(CustomerNo customerNo);
    Customer getCustomerByEmail(String email);

        /*
            Customer findByEmail(String email);
    Customer findByNameAndPassport(String name, String passport);
    Customer findByNameAndPhone(String name, String phone);
         */
}
