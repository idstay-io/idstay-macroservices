package idstay.web.frontoffice.support;

import lombok.Data;
import lombok.ToString;
import org.hibernate.validator.constraints.NotEmpty;

@Data @ToString
public class RoomRequestCommand {

    /*

      #reservation
            <input type="text" id="reservationId" placeholder="#123456" th:field="*{reservationId}" />
            <input type="text" id="roomType" placeholder="12/31/2017" th:field="*{roomType}" />
            <input type="text" id="checkin" placeholder="12/31/2017" th:field="*{checkin}" />
            <input type="text" id="checkout" placeholder="12/31/2017" th:field="*{checkout}" />
            <select th:field="*{adult}">
            <input type="text" id="childern" placeholder="12/31/2017" th:field="*{children}" />

      #guest
            <input type="text" class="form-control" id="guestName" placeholder="HONG gildong" th:field="*{guestName}" />
            <input type="text" class="form-control" id="phone" placeholder="+82-10-4717-0000" th:field="*{phone}" />

      #agency
            <input type="text" class="form-control" id="agency" placeholder="Expedia" th:field="*{agency}" />
            <input type="text" class="form-control" id="registrationNo" placeholder="#123456" th:field="*{registrationNo}" />
            <input type="text" class="form-control" id="memo" placeholder="HONG gildong" th:field="*{memo}" />

    <h1>Payment</h1>
            <input type="text" class="form-control" id="discount" placeholder="1,000" th:field="*{discount}" />
            <input type="text" class="form-control" id="cash" placeholder="1,000" th:field="*{cash}" />
            <input type="text" class="form-control" id="card" placeholder="1,000" th:field="*{card}" />
            <input type="text" class="form-control" id="agencyPayment" placeholder="1,000" th:field="*{agencyPayment}" />
            <input type="text" class="form-control" id="deposit" placeholder="1,000" th:field="*{deposit}" />
     */

    //reservation

    private String reservationId;

    private String roomType;

    private String checkin;

    private String checkout;

    private int adult;

    private int children;

    //guest info

    private String guestName;
    private String phone;


    //agency
    private String agency;
    private String registrationNo;
    private String memo;

    //Payment
    private long discount;
    private long cash;
    private long card;
    private long agencyPayment;
    private long deposit;

}
