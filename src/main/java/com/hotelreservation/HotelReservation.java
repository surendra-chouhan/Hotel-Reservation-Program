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
        HotelDetails cheapest_on_weekend = Collections.min(hotelDetails, Comparator.comparing(hotelDetail -> hotelDetail.weekendPrice));
        int cheapestRate = (int)(days* cheapest_on_weekend.totalRate());
        System.out.println("Cheapest Hotel is " + cheapest_on_weekend.getName() + "\nTotal Rate is : " + cheapestRate);
        return cheapest_on_weekend;
    }

    public String findBestRatedAndAlsoCheapestHotel() {
        HotelDetails cheapestOnWeekdays = Collections.min(hotelDetails,Comparator.comparing(hotelDetail -> hotelDetail.getWeekdayPrice()));
        HotelDetails cheapestOnWeekend = Collections.min(hotelDetails, Comparator.comparing(hotelDetail -> hotelDetail.getWeekendPrice()));

        if(cheapestOnWeekdays.totalRate() == cheapestOnWeekend.totalRate()){
            if (cheapestOnWeekdays.rating > cheapestOnWeekend.rating)
                return cheapestOnWeekdays.getName();
            else
                return cheapestOnWeekend.getName();
        }
        else if(cheapestOnWeekdays.totalRate() > cheapestOnWeekend.totalRate()){
            if (cheapestOnWeekdays.rating > cheapestOnWeekend.rating)
                return cheapestOnWeekdays.getName();
            else
                return cheapestOnWeekend.getName();
        }
        else if(cheapestOnWeekdays.totalRate() > cheapestOnWeekend.totalRate()){
            if(cheapestOnWeekdays.rating < cheapestOnWeekend.rating)
                return cheapestOnWeekdays.getName();
            else
                return cheapestOnWeekend.getName();
        }
        return null;
    }

    public HotelDetails find_BestRated_Hotel(LocalDate startDate, LocalDate lastDate) {
        long days = ChronoUnit.DAYS.between(startDate,lastDate);
        HotelDetails bestRated = Collections.max(hotelDetails, Comparator.comparing(hotelDetail -> hotelDetail.getRating()));
        System.out.println("Best Rated Hotel is : " + bestRated.getName() + " & Total Rate is : " + bestRated.totalRate());
        return bestRated;
    }
}


