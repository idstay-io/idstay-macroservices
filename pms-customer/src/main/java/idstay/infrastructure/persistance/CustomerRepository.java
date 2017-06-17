package idstay.infrastructure.persistance;


import idstay.domain.model.Customer;
import idstay.domain.model.CustomerNo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, CustomerNo> {
    Customer findByEmail(String email);
}
