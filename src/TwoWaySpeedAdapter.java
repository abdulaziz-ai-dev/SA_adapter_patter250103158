public class TwoWaySpeedAdapter implements ISpeedInMph, ISpeedInKmh {
    private double speedInKmh;

    public TwoWaySpeedAdapter() {
        this.speedInKmh = 0.0;
    }

    public double getSpeedKmh() {
        return speedInKmh;
    }

    public void setSpeedKmh(double kmh) {
        this.speedInKmh = kmh;
    }

    public double getSpeedMph() {
        return speedInKmh * 0.621371;
    }

    public void setSpeedMph(double mph) {
        this.speedInKmh = mph * 1.60934;
    }
}