import com.opencsv.CSVReader;

import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Parser {

    private final Charset charset;

    public Parser(Charset charset) {
        this.charset = charset;
    }

    public Parser() {
        this(StandardCharsets.UTF_8);
    }

    public List<Stops> parseStops(Path path) throws IOException {
        final List<Stops> result = new ArrayList<>();

        try (CSVReader reader = new CSVReader(new FileReader(path.toFile(), charset))) {

            for (String[] data : reader) {

                int id = Integer.parseInt(data[0]);
                int code = Integer.parseInt(data[1]);
                String name = data[2];
                double lat = Double.parseDouble(data[3]);
                double lon = Double.parseDouble(data[4]);
                String type = data[7];

                result.add(new Stops(id, code, name, lat, lon, type));

            }
            return result;
        }
    }

    public List<Routes> parseRoutes(Path path) throws IOException {
        final List<Routes> result = new ArrayList<>();
        try (CSVReader reader = new CSVReader(new FileReader(path.toFile(), charset))) {
            for (String[] data : reader) {
                int route_id = Integer.parseInt(data[0]);
                String route_name = data[1];
                String route_type = data[4];
                result.add(new Routes(route_id, route_name, route_type));
            }
        }
        return result;
    }

}