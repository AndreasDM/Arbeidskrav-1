import java.util.Objects;

public class Weight extends Meter {
    private double lowestWeight;
    private double highestWeight;

    public Weight() 
    {
        this(0.0, 0.0, "not registered", "not registered", false);
    }

    public Weight(double lowestWeight, double highestWeight, String registrationNumber, 
                  String storagePlace, boolean isWorking)
    {
        super(registrationNumber, storagePlace, isWorking);
        this.lowestWeight = lowestWeight;
        this.highestWeight = highestWeight;
    }

    @Override
    public String toString()
    {
        String str = String.format("%s\n%-23s %s - %s\n%s", "Weight:", "Interval:",
                                   lowestWeight, highestWeight, super.toString());
        
        return str;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null) return false;
        if (getClass() != o.getClass()) return false;

        Weight weight = (Weight)o;

        return Objects.equals(lowestWeight, weight.lowestWeight) && 
               Objects.equals(highestWeight, weight.highestWeight);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(lowestWeight, highestWeight);
    }

    public double getLowestWeight() { return lowestWeight; }
    public double getHighestWeight() { return highestWeight; }

    public void setLowestWeight(double weight) { lowestWeight = weight; }
    public void setHighestWeight(double weight) { highestWeight = weight; }
}   