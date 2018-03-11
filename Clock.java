import java.util.Objects;

public class Clock extends Meter {
    private double lowestInterval;

    public Clock()
    {
        this(0.0, "undefined", "undefined", false);
    }

    public Clock(double lowestInterval, String registrationNumber, String storagePlace,
                 boolean isWorking)
    {
        super(registrationNumber, storagePlace, isWorking);
        this.lowestInterval = lowestInterval;
    }

    @Override
    public String toString()
    {
        String str = String.format("%s\n%-23s %s\n%s", "Clock:", "Lowest time-interval:",
                                   lowestInterval, super.toString());
        return str;
        //return "Clock:\n(Lowest time-interval: " + lowestInterval + "\n" + super.toString();
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null) return false;
        if (getClass() != o.getClass()) return false;

        Clock clock = (Clock)o;

        return Objects.equals(lowestInterval, clock.lowestInterval);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(lowestInterval);
    }

    public double getLowestInterval() { return lowestInterval; }
    public void setLowestInterval(double interval) { lowestInterval = interval; }
}