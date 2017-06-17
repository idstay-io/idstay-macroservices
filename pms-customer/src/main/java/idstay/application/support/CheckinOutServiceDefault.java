package idstay.application.support;



public class CheckinOutServiceDefault  {
    /*
    private final RoomBookingRepository roomBookingRepository;

    @Autowired
    public CheckinOutServiceDefault(final RoomBookingRepository roomBookingRepository) {
        this.roomBookingRepository = roomBookingRepository;
    }

    @Override @Transactional
    public RoomBookingID checkin(RoomBookingID bookingID) {
        RoomBooking roomBooking = roomBookingRepository.findOne(bookingID);
        roomBooking.checkin();
        roomBookingRepository.save(roomBooking);
        return roomBooking.id();
    }

    @Override @Transactional
    public RoomBookingID checkout(RoomBookingID bookingID) {
        RoomBooking roomBooking = roomBookingRepository.findOne(bookingID);
        roomBooking.checkout();
        roomBookingRepository.save(roomBooking);
        return roomBooking.id();
    }

    @Override @Transactional
    public RoomBookingID noshow(RoomBookingID bookingID) {
        RoomBooking roomBooking = roomBookingRepository.findOne(bookingID);
        roomBooking.noshow();
        roomBookingRepository.save(roomBooking);
        return roomBooking.id();
    }

    @Override @Transactional
    public RoomBookingID cancelAction(RoomBookingID bookingID) {
        RoomBooking roomBooking = roomBookingRepository.findOne(bookingID);
        roomBooking.cancelAction();
        roomBookingRepository.save(roomBooking);
        return roomBooking.id();
    }

    @Override @Transactional
    public RoomBookingID cancel(RoomBookingID bookingID) {
        RoomBooking roomBooking = roomBookingRepository.findOne(bookingID);
        roomBooking.cancel();
        roomBookingRepository.save(roomBooking);
        return roomBooking.id();
    }
    */
}
