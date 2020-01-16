import java.util.ArrayList;
import java.util.Scanner;

public class Airport {

    private Scanner reader;
    private ArrayList<Plane> planes;
    private ArrayList<Flight> flights;

    public Airport() {

        this.reader = new Scanner(System.in);
        this.planes = new ArrayList<Plane>();
        this.flights = new ArrayList<Flight>();
    }


    // *** Airport Panel *****

    public void startAirportPanel() {
        System.out.println("Airport panel");
        System.out.println("--------------------");

        while (true) {
            printAirportPanelMenu();
            String input = reader.nextLine();
            if (input.equals("1")) {
                addAriplane();
            } else if (input.equals("2")) {
                addFlight();
            } else if (input.equals("x")) {
                System.out.println();
                startFlightService();
                break;
            }
        }
    }


    public void printAirportPanelMenu() {
        System.out.println("Choose operation:\n" +
                "[1] Add airplane\n" +
                "[2] Add flight\n" +
                "[x] Exit");
        System.out.print("> ");
    }


    public void addAriplane() {
        System.out.print("Give plane ID: ");
        String planeId = reader.nextLine();
        System.out.print("Give plane capacity: ");
        int capacity = Integer.parseInt(reader.nextLine());
        addToPlanes(new Plane(planeId, capacity));
    }


    public void addFlight() {
        System.out.print("Give plane ID: ");
        String planeId = reader.nextLine();
        System.out.print("Give departure airport code: ");
        String departureAirportCode = reader.nextLine();
        System.out.print("Give destination airport code: ");
        String destinationAirportCode = reader.nextLine();
        addToFlights(new Flight(getPlaneById(planeId), departureAirportCode, destinationAirportCode));
    }


    public void addToPlanes(Plane plane) {
        this.planes.add(plane);
    }

    public void addToFlights(Flight flight) {
        this.flights.add(flight);
    }

    public Plane getPlaneById(String id) {
        for (Plane plane : planes) {
            if (plane.getId().equals(id)) {
                return plane;
            }
        }
        return null;
    }


    //  **** Flight Service ****

    public void startFlightService() {
        System.out.println("Flight service");
        System.out.println("------------");
        while (true) {
            printFlightServiceMenu();
            String input = reader.nextLine();
            if (input.equals("1")) {
                printPlanes();
            } else if (input.equals("2")) {
                printFlights();
            } else if (input.equals("3")) {
                printPlaneInfo();
            } else if (input.equals("x")) {
                break;
            }
        }
    }

    public void printFlightServiceMenu() {
        System.out.println("Choose operation:\n"
                + "[1] Print planes\n"
                + "[2] Print flights\n"
                + "[3] Print plane info\n"
                + "[x] Quit");
        System.out.print("> ");
    }

    public void printPlanes() {
        for (Plane plane : planes) {
            System.out.println(plane);
        }
    }

    public void printFlights() {
        for (Flight flight : flights) {
            System.out.println(flight);
        }
    }

    public void printPlaneInfo() {
        System.out.print("Give plane ID: ");
        String id = reader.nextLine();
        for (Plane plane : planes) {
            if (plane.getId().equals(id)) {
                System.out.println(plane);
            }
        }
    }


}
