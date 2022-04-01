package service;

import entities.Branch;

public class BookingFactory {
    public static BookingStrategy findBookingStrategy(BookingStrategyType bookingStrategyType) {

        //Todo for now assuming only one strategy and taking LowPriceStrategy As DefaultStrategy
        if (bookingStrategyType == BookingStrategyType.LowPriceStrategy || bookingStrategyType == null) {
            return new LowPriceStrategy();
        }
        return null;
    }
}
