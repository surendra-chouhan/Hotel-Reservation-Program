package com.hotelreservation;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.util.*;

enum CustomerType{
    REGULAR_CUSTOMER,
    REWARD_CUSTOMER
}

public class HotelReservation {
    public static List<HotelDetails> hotelDetails = new ArrayList<>();
    CustomerType type;

    public HotelReservation(CustomerType type){
        this.type = type;
    }

    public int size(){
        return hotelDetails.size();
    }

    public int typeCustomer(boolean weekday, int idxi){
        if (type == CustomerType.REGULAR_CUSTOMER && weekday)
            return hotelDetails.get(idxi).getWeekdayPrice();
        else if (type == CustomerType.REGULAR_CUSTOMER)
            return hotelDetails.get(idxi).getWeekdayPrice();
        else if (type == CustomerType.REWARD_CUSTOMER && weekday)
            return hotelDetails.get(idxi).getWeekdayPrice();
        else
            return hotelDetails.get(idxi).getWeekdayPrice();
    }

    public void addHotel(HotelDetails hotelDetail) {
        hotelDetails.add(hotelDetail);
    }

    public HotelDetails findCheapestHotel(LocalDate startDate, LocalDate endDate) {
        DayOfWeek dayOfWeekForStartDate = DayOfWeek.of(startDate.get(ChronoField.DAY_OF_WEEK));
        DayOfWeek dayOfWeekForEndDate = DayOfWeek.of(endDate.get(ChronoField.DAY_OF_WEEK));
        int startDay = dayOfWeekForStartDate.getValue();
        int endDay = dayOfWeekForEndDate.getValue();

        int min = 10000;
        HotelDetails cheap = hotelDetails.get(0);

        for (int i = 1; i < hotelDetails.size(); i++){
            int totalPrice = 0;
            if(startDay > 1 && startDay < 6 && endDay > 1 && endDay <6 )
                totalPrice = totalPrice + hotelDetails.get(i).getWeekdayPrice();
            else
                totalPrice = totalPrice + hotelDetails.get(i).getWeekendPrice();

            hotelDetails.get(i).setTotalRate(totalPrice);
            if (totalPrice < min){
                if (cheap.getRating() < hotelDetails.get(i).getRating()){
                    cheap = hotelDetails.get(i);
                    min = totalPrice;
                }
            }
        }
        return cheap;
    }

    public HotelDetails find_BestRated_Hotel(LocalDate startDate, LocalDate lastDate) {
        long days = ChronoUnit.DAYS.between(startDate,lastDate);
        HotelDetails bestRated = Collections.max(hotelDetails, Comparator.comparing(hotelDetail -> hotelDetail.getRating()));
        System.out.println("Best Rated Hotel is : " + bestRated.getName());
        return bestRated;
    }
}


