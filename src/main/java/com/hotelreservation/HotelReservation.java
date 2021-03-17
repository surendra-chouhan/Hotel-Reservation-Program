package com.hotelreservation;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class HotelReservation {
    public static List<HotelDetails> hotelDetails = new ArrayList<>();

    public void addHotel(HotelDetails hotelDetail) {
        hotelDetails.add(hotelDetail);
    }

    public HotelDetails findCheapestHotel(LocalDate startDate, LocalDate endDate) {
        long days = ChronoUnit.DAYS.between(startDate, endDate);
        HotelDetails cheapest = Collections.min(hotelDetails, Comparator.comparing(hotelDetail -> hotelDetail.price));
        int cheapestRate = (int)(days* cheapest.getPrice());
        System.out.println("Cheapest Hotel is " + cheapest.getName() + "\nTotal Rate is : " + cheapestRate);
        return cheapest;
    }
}


