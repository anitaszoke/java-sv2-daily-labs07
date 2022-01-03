package day04;

import java.util.ArrayList;
import java.util.List;

public class Courier {
    private List<Ride> rides = new ArrayList<>();

    public List<Ride> addRide(Ride ride) {
        checkingRides(ride);

        rides.add(ride);

        return rides;
    }

    private void checkingRides(Ride ride) {
        for (Ride r : rides) {
            if (r.getDay() > ride.getDay()) {
                throw new IllegalArgumentException("Wrong day!");

            }
        }
    }
}
