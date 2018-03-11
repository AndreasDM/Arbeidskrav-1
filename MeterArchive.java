import java.util.List;
import java.util.ArrayList;

public class MeterArchive {
    private List<Meter> meters;

    public MeterArchive()
    {
        meters = new ArrayList<>();
    }

    public void add(Meter m) { meters.add(m); }
    
    public Meter get(String regNr)
    {
        return isMatch(regNr);
    }

    public boolean delete(String regNr)
    {
        Meter m = isMatch(regNr);
        if (m != null) {
            meters.remove(m);
            print("Successfully removed item with registration number: " + regNr);
            return true;
        }

        print("No item found with registration number: " + regNr);
        return false;
    }

    public boolean editPlacement(String regNr, String newPlacement)
    {
        Meter m = isMatch(regNr);
        if (m != null) {
            m.setStoragePlace(newPlacement);
            print("Successfully changed placement of item with registration number: " + regNr);
            return true;
        }
        return false;
    }

    public boolean editStatus(String regNr, boolean newStatus)
    {
        Meter m = isMatch(regNr);
        if (m != null) {
            m.setWorkingStatus(newStatus);
            print("Successfully changed status of item with registration number: " + regNr);
            return true;
        }
        return false;
    }

    public List<Meter> getMeters()
    {
        return meters;
    }

    private Meter isMatch(String regNr)
    {
        for (Meter m : meters) {
            if (m.getRegistrationNumber().equals(regNr))
                return m;
        }
        return null;
    }

    private void print(String msg)
    {
        System.out.printf("%s\n", msg);
    }
}