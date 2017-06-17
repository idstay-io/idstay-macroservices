package idstay.domain.model;

import org.apache.commons.lang3.Validate;

import javax.persistence.Embeddable;

@Embeddable
public class TravelDate {
    private String fromDate;
    private String toDate;

    TravelDate() {}
    private TravelDate(final String fromDate, final String toDate) {
        Validate.notNull(fromDate, "From Date is required");
        Validate.notNull(toDate, "To Date is required");
        verifyTravelDate(fromDate, toDate);
        this.fromDate = fromDate;
        this.toDate = toDate;
    }

    public static TravelDate of(final String fromDate, final String toDate) {
        return new TravelDate(fromDate, toDate);
    }

    private void verifyTravelDate(final String fromDate, final String toDate) {
        //if(toDate <= fromDate) throw new RuntimeException("To Date is smaller or equal to From Date");
    }

    public String getFromDate() {
        return fromDate;
    }

    public String getToDate() {
        return toDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TravelDate that = (TravelDate) o;

        if (getFromDate() != null ? !getFromDate().equals(that.getFromDate()) : that.getFromDate() != null)
            return false;
        return getToDate() != null ? getToDate().equals(that.getToDate()) : that.getToDate() == null;
    }

    @Override
    public int hashCode() {
        int result = getFromDate() != null ? getFromDate().hashCode() : 0;
        result = 31 * result + (getToDate() != null ? getToDate().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "TravelDate{" +
                "fromDate=" + fromDate +
                ", toDate=" + toDate +
                '}';
    }
}
