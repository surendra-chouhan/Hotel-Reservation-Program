package com.hotelreservation;

public class HotelDetails {
    public String name;
    public int price;
    public int rating;

    public HotelDetails(String name, int price, int rating){
        this.name = name;
        this.price = price;
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "HotelDetails{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", rating=" + rating +
                '}';
    }
}
