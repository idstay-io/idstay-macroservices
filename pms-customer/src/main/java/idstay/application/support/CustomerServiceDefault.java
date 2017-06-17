package idstay.application.support;

import idstay.application.CustomerService;
import idstay.domain.model.Customer;
import idstay.domain.model.CustomerNo;
import idstay.infrastructure.persistance.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


public class CustomerServiceDefault implements CustomerService {
    private final CustomerRepository customerRepository;

  //  public CustomerNo newIitinerary(Customer customer, ) {

  //  }

    @Override
    public Customer getCustomer(CustomerNo customerNo) {
        return null; //customerRepository.findOne(customerNo);
    }

    @Override
    public Customer getCustomerByEmail(String email) {
        return customerRepository.findByEmail(email);
    }
/*
    @Override
    public boolean isRegistedCustomer(String email, String name, String passport, String phone) {
        if (!email.isEmpty() && customerRepository.findByEmail(email) != null) {
            return true;
        }

        if (!name.isEmpty() && !passport.isEmpty() && customerRepository.findByNameAndPassport(name, passport) != null) {
            return true;
        }

        if (!name.isEmpty() && !phone.isEmpty() && customerRepository.findByNameAndPhone(name, phone) != null) {
            return true;
        }

        return false;
    }
*/
    @Autowired
    public CustomerServiceDefault(final CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
}
