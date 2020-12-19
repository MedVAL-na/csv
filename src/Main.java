import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Main {


    public static void main(String[] args) throws IOException {

        final Parser parser = new Parser();

        final Path stopsPath = Paths.get("stops1.txt");
        final List<Stops> stops = parser.parseStops(stopsPath);
        final Map<Integer, Stops> stopsById = new HashMap<Integer, Stops>();
        for (Stops stops1 : stops) {
            stopsById.put(stops1.getStop_id(), stops1);
        }

        final Path routesPath = Paths.get("routes1.txt");
        final List<Routes> routes = parser.parseRoutes(routesPath);
        final Map<Integer, Routes> routesById = new HashMap<Integer, Routes>();
        for (Routes routes1 : routes) {
            routesById.put(routes1.getRoute_id(), routes1);
        }
        final Path tripsPath = Paths.get("trips1.txt");
        final List<Trips> trips = parser.parseTrips(tripsPath);
        final Map<Integer, Trips> tripsById = new HashMap<Integer, Trips>();
        for (Trips trips1 : trips) {
            tripsById.put(trips1.getTrip_id(), trips1);
        }



        System.out.println("Show 5 first trips");
        for (Trips trips1 : trips.subList(0, 5)) {
            System.out.println(trips1);
        }

        System.out.println();
    }
}