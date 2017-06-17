package idstay.web.frontoffice.support;


import lombok.Data;
import lombok.ToString;
import org.hibernate.validator.constraints.NotEmpty;

@Data @ToString
public class OtaInvoiceCommand {
    @NotEmpty
    private String invoice;
}
