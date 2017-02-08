Customer
    id
    name

Confirmation implements Comparable<Confirmation>
    id
    Customer
    Date
    Time
    totalOfPersons

Reservation (interface) throws NoAvailabilityFound
    Confirmation tryReservate(Customer, date, int totalOfPersons)
    cancel(Confirmation)

ReservationByDate implements Reservation
    public ReservationByDate(int totalOfChairs, int totalOfTables)
    Confirmation tryReservate(Customer, date, int totalOfPersons)
    cancel(Confirmation)

RestaurantReservation
    Confirmation tryReservate(Customer, date, time, int totalOfPersons)
    cancel(Confirmation)

Restaurant implements RestaurantReservation
    int totalOfChairs
    int totalOfTables

    Map<Date, ReservationByDate> reservationsByLunch;
    Map<Date, ReservationByDate> reservationsByDinner;

    Map<Customer, List<Confirmations>> confirmations

    List<Confirmations> getConfirmation(Customer)

    void cancel(Confirmation)

    Confirmation tryReservate(Customer, date, time, int totalOfPersons)

        if (isLunch(time)) {
            return lunchReservation(Customer, date, time, totalOfPersons);
        }

        // Dinner
        return DinnerReservation(Customer, date, time, totalOfPersons);
    }




