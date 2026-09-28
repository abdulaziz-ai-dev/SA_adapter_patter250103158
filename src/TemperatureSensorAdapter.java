public class TemperatureSensorAdapter implements ICelsiusSensor {
    private FahrenheitSensor sensor;

    public TemperatureSensorAdapter(FahrenheitSensor sensor) {
        this.sensor = sensor;
    }

    public double getTemperatureInCelsius() {
        String raw = sensor.readRawTemperature();

        String cleanStr = raw.replace(" F", "").trim();
        double fahrenheit = Double.parseDouble(cleanStr);

        double celsius = (fahrenheit - 32.0) * (5.0 / 9.0);

        return Math.round(celsius * 100.0) / 100.0;
    }
}