package io.idstay.prs.interfaces.dto;

import io.idstay.prs.domain.Room;

public class RoomDto {
    private long roomId;
    private String roomName;
    private int floor = 0;

    public RoomDto() {}
    public RoomDto(final long roomId, final String roomName, final int floor) {
        this.roomId = roomId;
        this.roomName = roomName;
        this.floor = floor;
    }

    public long getRoomId() {
        return roomId;
    }

    public String getRoomName() {
        return roomName;
    }

    public String getfloor() {
        return ""+ floor;
    }

    public static RoomDto toDto(Room room) {
        return new RoomDto(
                room.getId(),
                room.getRoomName(),
                room.getFloor());
    }

}
