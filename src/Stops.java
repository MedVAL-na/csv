public class Stops {
    private final int stop_id;
    private final int stop_code;
    private final String stop_name;
    private final double stop_lat;
    private final double stop_lon;
    private final String transport_type;


    public Stops(int stop_id, int stop_code, String stop_name, double stop_lat, double stop_lon, String transport_type) {
        this.stop_id = stop_id;
        this.stop_code = stop_code;
        this.stop_name = stop_name;
        this.stop_lat = stop_lat;
        this.stop_lon = stop_lon;
        this.transport_type = transport_type;
    }

    public int getStop_id() {
        return stop_id;
    }

    public int getStop_code() {
        return stop_code;
    }

    public String getStop_name() {
        return stop_name;
    }

    public double getStop_lat() {
        return stop_lat;
    }

    public double getStop_lon() {
        return stop_lon;
    }

    public String getTransport_type() {
        return transport_type;
    }

    @Override
    public String toString() {
        return "Stops{" + System.lineSeparator() +
                "\tstop_id=" + stop_id + System.lineSeparator() +
                "\tstop_code='" + stop_code + '\'' + System.lineSeparator() +
                "\tstop_name='" + stop_name + '\'' + System.lineSeparator() +
                "\tstop_lat='" + stop_lat + '\'' + System.lineSeparator() +
                "\tstop_lon=" + stop_lon + System.lineSeparator() +
                "\ttransport_type='" + transport_type + '\'' + System.lineSeparator() +
                '}';
    }
}

