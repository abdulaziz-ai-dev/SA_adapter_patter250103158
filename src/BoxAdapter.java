public class BoxAdapter implements IImperialBox {
    private MetricBox box;

    public BoxAdapter(MetricBox box) {
        this.box = box;
    }

    public double getWidthInches() {
        return box.getWidthCm() / 2.54;
    }

    public double getHeightInches() {
        return box.getHeightCm() / 2.54;
    }

    public double getAreaSquareInches() {
        return getWidthInches() * getHeightInches();
    }
}