import java.util.Objects;

public class Thermometer extends Meter {
    private double lowestTemp;
    private double highestTemp;

    public Thermometer()
    {
        this(0.0, 0.0, "not registered", "not registered", false);
    }

    public Thermometer(double lowestTemp, double highestTemp, String registrationNumber, 
                       String storagePlace, boolean isWorking)
    {
        super(registrationNumber, storagePlace, isWorking);
        this.lowestTemp = lowestTemp;
        this.highestTemp = highestTemp;
    }

    @Override
    public String toString()
    {
        String str = String.format("%s\n%-23s %s °C | %s °C\n%s", "Thermometer:", "Min-Max Temperature:",
                                   lowestTemp, highestTemp, super.toString());
        return str;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null) return false;
        if (getClass() != o.getClass()) return false;

        Thermometer th = (Thermometer)o;

        return Objects.equals(lowestTemp, th.lowestTemp) &&
               Objects.equals(highestTemp, th.highestTemp);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(lowestTemp, highestTemp);
    }

    public double getLowestTemperature() { return lowestTemp; }
    public double getHighestTemperature() { return highestTemp; }

    public void setLowestTemperature(double temp) { lowestTemp = temp; }
    public void setHighestTemperature(double temp) { highestTemp = temp; }
}