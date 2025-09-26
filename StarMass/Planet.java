import java.util.Objects;

public class Planet extends CelestialObject {
    private Star centerStar;

    public Planet() {
        super("Soleil", 0.0, 0.0, 0.0, 0);
        this.centerStar = new Star();
    }

    public Planet(String name, double x, double y, double z, Star centerStar, int mass) {
        super(name, x, y, z, mass);
        this.centerStar = centerStar;
    }

    public Star getCenterStar() {
        return centerStar;
    }

    public void setCenterStar(Star centerStar) {
        this.centerStar = centerStar;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof Planet))
            return false;

        Planet other = (Planet) obj;

        return Objects.equals(this.getName(), other.getName()) &&
                Double.compare(this.getX(), other.getX()) == 0 &&
                Double.compare(this.getY(), other.getY()) == 0 &&
                Double.compare(this.getZ(), other.getZ()) == 0 &&
                Objects.equals(this.centerStar, other.centerStar);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getX(), getY(), getZ(), centerStar);
    }

    @Override
    public String toString() {
        double distance = CelestialObject.getDistanceBetween(this, centerStar);
        return String.format("%s circles around %s at the %.3f AU", getName(), centerStar.getName(), distance);
    }
}
