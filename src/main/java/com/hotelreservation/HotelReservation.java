package com.hotelreservation;

import java.util.ArrayList;
import java.util.List;

public class HotelReservation {
    public static List<HotelDetails> hotelDetails = new ArrayList<>();

    public void addHotel(HotelDetails hotelDetail){
        hotelDetails.add(hotelDetail);
    }
}
