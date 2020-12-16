import com.opencsv.CSVReader;

import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class StopsParser {

    private final Charset charset;

    public StopsParser(Charset charset) {
        this.charset = charset;
    }

    public StopsParser() {
        this(StandardCharsets.UTF_8);
    }

    public List<Stops> parse(Path path) throws IOException {
        final List<Stops> result = new ArrayList<>();

        try (CSVReader reader = new CSVReader(new FileReader(path.toFile(), charset))) {

            for (String[] data : reader) {

                int stop_id = Integer.parseInt(data[0]);
                int stop_code = Integer.parseInt(data[1]);
                String stop_name = data[2];
                double stop_lat = Double.parseDouble(data[3]);
                double stop_lon = Double.parseDouble(data[4]);
                String transport_type = data[7];

                // Create Route with specified parameters and add it to result list
                result.add(new Stops(stop_id, stop_code, stop_name, stop_lat, stop_lon, transport_type));
            }
        }
        return result;
    }
}
