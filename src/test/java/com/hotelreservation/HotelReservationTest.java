package com.hotelreservation;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static com.hotelreservation.HotelReservation.hotelDetails;

public class HotelReservationTest {
    HotelReservation hotelReservation;
    HotelDetails lakewood = new HotelDetails("Lakewood", 110, 90,3);
    HotelDetails bridgewood = new HotelDetails("Bridgewood", 160, 50,4);
    HotelDetails ridgewood = new HotelDetails("Ridgewood", 220, 150, 5);

    @Before
    public void setup() {
        hotelReservation = new HotelReservation();
        hotelReservation.addHotel(lakewood);
        hotelReservation.addHotel(bridgewood);
        hotelReservation.addHotel(ridgewood);
    }


    @Test
    public void add_Hotel_TrueTest() {
        Assert.assertTrue(hotelDetails.contains(lakewood));
        Assert.assertTrue(hotelDetails.contains(bridgewood));
        Assert.assertTrue(hotelDetails.contains(ridgewood));
}

    @Test
    public void find_cheapest_hotel_TrueTest() {
        HotelDetails cheapestHotel = hotelReservation.findCheapestHotel(LocalDate.of(2020,10,10), LocalDate.of(2020,10,11));
        Assert.assertEquals("Lakewood", cheapestHotel.getName());
    }

    @Test
    public void add_WeekDay_and_Weekend_Rates_TrueTest() {
        Assert.assertEquals(90, lakewood.getWeekendPrice());
        Assert.assertEquals(50, bridgewood.getWeekendPrice());
        Assert.assertEquals(150, ridgewood.getWeekendPrice());

        Assert.assertEquals(110, lakewood.getWeekdayPrice());
        Assert.assertEquals(160, bridgewood.getWeekdayPrice());
        Assert.assertEquals(220, ridgewood.getWeekdayPrice());
    }
}
