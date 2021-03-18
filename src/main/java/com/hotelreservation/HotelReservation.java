package com.hotelreservation;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class HotelReservation {
    public static List<HotelDetails> hotelDetails = new ArrayList<>();

    public void addHotel(HotelDetails hotelDetail) {
        hotelDetails.add(hotelDetail);
    }

    public HotelDetails findCheapestHotel_based_on_WeekDay(LocalDate startDate, LocalDate endDate) {
        long days = ChronoUnit.DAYS.between(startDate, endDate);
        HotelDetails cheapest = Collections.min(hotelDetails, Comparator.comparing(hotelDetail -> hotelDetail.weekdayPrice));
        int cheapestRate = (int)(days* cheapest.totalRate());
        System.out.println("Cheapest Hotel based on week day is " + cheapest.getName() + "\nTotal Rate is : " + cheapestRate);
        return cheapest;
    }

    public HotelDetails findCheapestHotel_based_on_WeekEnd(LocalDate startDate, LocalDate endDate) {
        long days = ChronoUnit.DAYS.between(startDate, endDate);
        HotelDetails cheapest1 = Collections.min(hotelDetails, Comparator.comparing(hotelDetail -> hotelDetail.weekendPrice));
        int cheapestRate = (int)(days* cheapest1.totalRate());
        System.out.println("Cheapest Hotel is " + cheapest1.getName() + "\nTotal Rate is : " + cheapestRate);
        return cheapest1;
    }


}


