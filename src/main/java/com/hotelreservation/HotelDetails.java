package com.hotelreservation;

public class HotelDetails {
    public String name;
    public int weekendPrice;
    public int weekdayPrice;
    public int rating;
    public int totalRate;

    public HotelDetails(String name, int weekdayPrice, int weekendPrice, int rating){
        this.name = name;
        this.weekdayPrice = weekdayPrice;
        this.weekendPrice = weekendPrice;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public int getRating() {
        return rating;
    }


    public void setWeekendPrice(int weekendPrice) {
        this.weekendPrice = weekendPrice;
    }

    public int getWeekendPrice() {
        return weekendPrice;
    }

    public void setWeekdayPrice(int weekdayPrice) {
        this.weekdayPrice = weekdayPrice;
    }

    public int getWeekdayPrice() {
        return weekdayPrice;
    }

    public int totalRate(){
        this.totalRate = weekdayPrice + weekendPrice;
        return totalRate;
    }

    @Override
    public String toString() {
        return "HotelDetails{" +
                "name='" + name + '\'' +
                ", weekendPrice=" + weekendPrice +
                ", weekdayPrice=" + weekdayPrice +
                ", rating=" + rating +
                '}';
    }
}
