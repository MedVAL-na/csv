import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;


public class Main {


    public static void main(String[] args) throws IOException {

        final StopsParser parser = new StopsParser();
        final Path routesPath = Paths.get("C:\\Users\\Admin\\Desktop\\csv\\csv\\src\\stops1.txt");
        final List<Stops> stops = parser.parse(routesPath);
        final Map<Integer, Stops> stopsById = new HashMap<Integer, Stops>();
        for (Stops route : stops) {
            stopsById.put(route.getStop_id(), route);
        }

        System.out.println("Show 5 first stops");
        for (Stops stops1 : stops.subList(0, 5)) {
            System.out.println(stops1);
        }
        
        System.out.println();
    }
}
