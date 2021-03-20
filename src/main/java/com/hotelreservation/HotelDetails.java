package com.hotelreservation;

public class HotelDetails {
    public String name;
    public int weekendPrice;
    public int weekdayPrice;
    public int rating;
    private int totalRate = 0;
    private int weekendRewardPrice;
    private int weekdayRewardPrice;

    public HotelDetails(String name, int weekdayPrice, int weekendPrice, int rating, int weekdayRewardPrice, int weekendRewardPrice){
        this.name = name;
        this.weekdayPrice = weekdayPrice;
        this.weekendPrice = weekendPrice;
        this.rating = rating;
        this.weekdayRewardPrice = weekdayRewardPrice;
        this.weekendRewardPrice = weekendRewardPrice;
    }

    public String getName() {
        return name;
    }

    public int getRating() {
        return rating;
    }

    public int getWeekendPrice() {
        return weekendPrice;
    }

    public int getWeekdayPrice() {
        return weekdayPrice;
    }

    public int getTotalRate() {
        return totalRate;
    }

    public void setTotalRate(int totalRate) {
        this.totalRate = totalRate;
    }

    public int getWeekendRewardPrice() {
        return weekendRewardPrice;
    }

    public void setWeekendRewardPrice(int weekendRewardPrice) {
        this.weekendRewardPrice = weekendRewardPrice;
    }

    public int getWeekdayRewardPrice() {
        return weekdayRewardPrice;
    }

    public void setWeekdayRewardPrice(int weekdayRewardPrice) {
        this.weekdayRewardPrice = weekdayRewardPrice;
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
