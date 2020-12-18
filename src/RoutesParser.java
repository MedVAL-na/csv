import com.opencsv.CSVReader;

import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class RoutesParser {

    private final Charset charset;

    public RoutesParser(Charset charset) {
        this.charset = charset;
    }

    public RoutesParser() {
        this(StandardCharsets.UTF_8);
    }

    public List<Routes> parse(Path path) throws IOException {
        final List<Routes> result = new ArrayList<>();
        try (CSVReader reader = new CSVReader(new FileReader(path.toFile(), charset))) {
            for (String[] data : reader) {
                int route_id = Integer.parseInt(data[0]);
                String route_name = data[2];
                String route_type = data[5];
                result.add(new Routes(route_id, route_name, route_type));
            }
        }
        return result;
    }
}