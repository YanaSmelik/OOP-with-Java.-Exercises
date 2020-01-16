public class Flight {

    private Plane plane;
    private String departureAirportCode;
    private String destinationAirportCode;


    public Flight(Plane plane, String departureAirportCode, String destinationAirportCode){
        this.plane = plane;
        this.departureAirportCode = departureAirportCode;
        this.destinationAirportCode = destinationAirportCode;
    }

    @Override
    public String toString() {
        return this.plane + " (" + this.departureAirportCode + "-" + this.destinationAirportCode + ")";
    }
}
