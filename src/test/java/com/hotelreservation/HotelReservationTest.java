package com.hotelreservation;

import org.junit.Assert;
import org.junit.Test;
import java.text.ParseException;
import java.time.LocalDate;
import static com.hotelreservation.HotelReservation.hotelDetails;

public class HotelReservationTest {
    @Test
    public void add_Hotel_TrueTest() {
        HotelReservation hotelReservation = new HotelReservation(CustomerType.REGULAR_CUSTOMER);
        HotelDetails lakewood = new HotelDetails("Lakewood", 110, 90,0, 0, 0);
        HotelDetails bridgewood = new HotelDetails("Bridgewood", 150, 50,0, 0, 0);
        HotelDetails ridgewood = new HotelDetails("Ridgewood", 220, 150, 0, 0, 0);

        hotelReservation.addHotel(lakewood);
        hotelReservation.addHotel(bridgewood);
        hotelReservation.addHotel(ridgewood);

        Assert.assertTrue(hotelDetails.contains(lakewood));
    }

    @Test
    public void find_cheapest_hotel_TrueTest() {
        HotelReservation hotelReservation = new HotelReservation(CustomerType.REGULAR_CUSTOMER);
        HotelDetails lakewood = new HotelDetails("Lakewood", 110, 90,0, 0, 0);
        HotelDetails bridgewood = new HotelDetails("Bridgewood", 150, 50,0, 0, 0);
        HotelDetails ridgewood = new HotelDetails("Ridgewood", 220, 150, 0, 0, 0);

        hotelReservation.addHotel(lakewood);
        hotelReservation.addHotel(bridgewood);
        hotelReservation.addHotel(ridgewood);

        HotelDetails cheapestHotel = hotelReservation.findCheapestHotel(LocalDate.of(2020,10,10), LocalDate.of(2020,10,11));
        Assert.assertEquals("Lakewood", cheapestHotel.getName());
    }

    @Test
    public void add_WeekDay_and_Weekend_Rates_TrueTest() {
        HotelReservation hotelReservation = new HotelReservation(CustomerType.REGULAR_CUSTOMER);
        HotelDetails lakewood = new HotelDetails("Lakewood", 110, 90,0, 0, 0);
        HotelDetails bridgewood = new HotelDetails("Bridgewood", 150, 50,0, 0, 0);
        HotelDetails ridgewood = new HotelDetails("Ridgewood", 220, 150, 0, 0, 0);

        hotelReservation.addHotel(lakewood);
        hotelReservation.addHotel(bridgewood);
        hotelReservation.addHotel(ridgewood);
        
        Assert.assertEquals(90, lakewood.getWeekendPrice());
        Assert.assertEquals(50, bridgewood.getWeekendPrice());
        Assert.assertEquals(150, ridgewood.getWeekendPrice());

        Assert.assertEquals(110, lakewood.getWeekdayPrice());
        Assert.assertEquals(150, bridgewood.getWeekdayPrice());
        Assert.assertEquals(220, ridgewood.getWeekdayPrice());
    }

    @Test
    public void find_cheapest_hotel_based_on_date_TrueTest() {
        HotelReservation hotelReservation = new HotelReservation(CustomerType.REGULAR_CUSTOMER);
        HotelDetails lakewood = new HotelDetails("Lakewood", 110, 90,0, 0, 0);
        HotelDetails bridgewood = new HotelDetails("Bridgewood", 150, 50,0, 0, 0);
        HotelDetails ridgewood = new HotelDetails("Ridgewood", 220, 150, 0, 0, 0);

        hotelReservation.addHotel(lakewood);
        hotelReservation.addHotel(bridgewood);
        hotelReservation.addHotel(ridgewood);
        
        LocalDate startDate = LocalDate.of(2020,10,11);
        LocalDate endDate = LocalDate.of(2020,10,12);

        HotelDetails cheapestHotel = hotelReservation.findCheapestHotel(startDate,endDate);

        Assert.assertEquals("Lakewood", cheapestHotel.getName());
    }

    @Test
    public void find_ratings_of_Hotels_TrueTest() {
        HotelReservation hotelReservation = new HotelReservation(CustomerType.REGULAR_CUSTOMER);
        HotelDetails lakewood = new HotelDetails("Lakewood", 110, 90,3, 0, 0);
        HotelDetails bridgewood = new HotelDetails("Bridgewood", 150, 50,4, 0, 0);
        HotelDetails ridgewood = new HotelDetails("Ridgewood", 220, 150, 5, 0, 0);

        hotelReservation.addHotel(lakewood);
        hotelReservation.addHotel(bridgewood);
        hotelReservation.addHotel(ridgewood);
        
        Assert.assertEquals(3, lakewood.getRating());
        Assert.assertEquals(4, bridgewood.getRating());
        Assert.assertEquals(5, ridgewood.getRating());
    }

    @Test
    public void find_cheapest_bestRated_Hotel_TrueTest() {
        HotelReservation hotelReservation = new HotelReservation(CustomerType.REGULAR_CUSTOMER);
        HotelDetails lakewood = new HotelDetails("Lakewood", 110, 90,3, 0, 0);
        HotelDetails bridgewood = new HotelDetails("Bridgewood", 150, 50,4, 0, 0);
        HotelDetails ridgewood = new HotelDetails("Ridgewood", 220, 150, 5, 0, 0);

        hotelReservation.addHotel(lakewood);
        hotelReservation.addHotel(bridgewood);
        hotelReservation.addHotel(ridgewood);
        
        HotelDetails cheapestHotel = hotelReservation.findCheapestHotel(LocalDate.of(2020,10,10), LocalDate.of(2020,10,11));
        Assert.assertEquals("Bridgewood", cheapestHotel.getName());
    }

    @Test
    public void find_BestRated_Hotel_TrueTest() {
        HotelReservation hotelReservation = new HotelReservation(CustomerType.REGULAR_CUSTOMER);
        HotelDetails lakewood = new HotelDetails("Lakewood", 110, 90,3, 0, 0);
        HotelDetails bridgewood = new HotelDetails("Bridgewood", 150, 50,4, 0, 0);
        HotelDetails ridgewood = new HotelDetails("Ridgewood", 220, 150, 5, 0, 0);

        hotelReservation.addHotel(lakewood);
        hotelReservation.addHotel(bridgewood);
        hotelReservation.addHotel(ridgewood);
        
        HotelDetails bestRatedHotel = hotelReservation.find_BestRated_Hotel(LocalDate.of(2020,10,10), LocalDate.of(2020,10,11));
        Assert.assertEquals("Ridgewood", bestRatedHotel.getName());
    }

    @Test
    public void add_Reward_Customer() throws ParseException {
        HotelReservation hotelReservation = new HotelReservation(CustomerType.REWARD_CUSTOMER);
        HotelDetails lakewood = new HotelDetails("Lakewood", 110, 90,3, 80, 80);
        HotelDetails bridgewood = new HotelDetails("Bridgewood", 150, 50,4, 110, 50);
        HotelDetails ridgewood = new HotelDetails("Ridgewood", 220, 150, 5, 100, 40);

        hotelReservation.addHotel(lakewood);
        hotelReservation.addHotel(bridgewood);
        hotelReservation.addHotel(ridgewood);

        Assert.assertEquals(80, lakewood.getWeekdayRewardPrice());
    }

    @Test
    public void find_cheapest_bestRated_Hotel_For_REWARD_CUSTOMER_TrueTest() throws ParseException {
        HotelReservation hotelReservation = new HotelReservation(CustomerType.REWARD_CUSTOMER);
        HotelDetails lakewood = new HotelDetails("Lakewood", 110, 90,3, 80, 80);
        HotelDetails bridgewood = new HotelDetails("Bridgewood", 150, 50,4, 110, 50);
        HotelDetails ridgewood = new HotelDetails("Ridgewood", 220, 150, 5, 100, 40);

        hotelReservation.addHotel(lakewood);
        hotelReservation.addHotel(bridgewood);
        hotelReservation.addHotel(ridgewood);

        HotelDetails cheapHotelForRewardCustomer = hotelReservation.find_BestRated_Hotel(LocalDate.of(2020,10,10), LocalDate.of(2020,10,11));
        Assert.assertEquals("Ridgewood", cheapHotelForRewardCustomer.getName());
    }

    @Test
    public void find_cheapest_hotel_best_rated_for_REGULAR_CUSTOMER_TrueTest() throws ParseException {
        HotelReservation hotelReservation = new HotelReservation(CustomerType.REGULAR_CUSTOMER);
        HotelDetails lakewood = new HotelDetails("Lakewood", 110, 90,3, 80, 80);
        HotelDetails bridgewood = new HotelDetails("Bridgewood", 150, 50,4, 110, 50);
        HotelDetails ridgewood = new HotelDetails("Ridgewood", 220, 150, 5, 100, 40);

        hotelReservation.addHotel(lakewood);
        hotelReservation.addHotel(bridgewood);
        hotelReservation.addHotel(ridgewood);

        HotelDetails cheapHotelForRegularCustomer = hotelReservation.findCheapestHotel(LocalDate.of(2020,10,11), LocalDate.of(2020,10,12));
        Assert.assertEquals("Bridgewood", cheapHotelForRegularCustomer.getName());

    }
}
