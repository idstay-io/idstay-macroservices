package io.idstay.prs.interfaces.dto;

import io.idstay.prs.domain.RoomType;

public class RoomTypeDto {
    private String roomTypeName;

    public RoomTypeDto(final String roomTypeName) {
        this.roomTypeName = roomTypeName;
    }

    public String getRoomTypeName() {
        return roomTypeName;
    }

    public static RoomTypeDto toDto(RoomType roomType) {
        return new RoomTypeDto(roomType.getRoomTypeName());
    }


}
