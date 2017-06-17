package idstay.domain.model;



import org.apache.commons.lang3.Validate;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;

@Embeddable
public class Stay {
    @Embedded
    private TravelDate travelDate;
    private int adults;
    private int kids;

    private Stay(final TravelDate travelDate, final int adults, final int kids) {
        Validate.notNull(travelDate, "Travel Date is required");
        Validate.notNull(adults, "Adult is required");
        Validate.notNull(kids, "Kids is required");
        this.travelDate = travelDate;
        this.adults = adults;
        this.kids = kids;
    }



    public static Stay of(final TravelDate travelDate, final int adults, final int kids) {
        return new Stay(travelDate, adults, kids);
    }

    @Override
    public String toString() {
        return "Stay{" +
                "travelDate=" + travelDate +
                ", adults=" + adults +
                ", kids=" + kids +
                '}';
    }

    Stay() {
        //Needed by Jpa
    }

}
