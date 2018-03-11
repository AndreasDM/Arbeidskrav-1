public class Client {
    private MeterArchive archive;

    public static void main(String[] args)
    {
        Client client = new Client();
        client.mainMethod();
    }

    public void mainMethod()
    {
        archive = new MeterArchive();
        archive.add(new Weight(0.01, 10.0, "W1000", "R101H1", true));
        archive.add(new Weight(0.01, 100.0, "W1001", "R101H2", true));
        archive.add(new Weight(0.01, 1000.0, "W1002", "R101H3", true));
        archive.add(new Thermometer(0.01, 100.0, "T2000", "R101H4", true));
        archive.add(new Thermometer(1.0, 200.0, "T2001", "R101H5", true));
        archive.add(new Clock(0.0001, "C3000", "R101H6", true));
        archive.add(new Clock(0.01, "C3001", "R101H7", true));
        archive.add(new Clock(1.0, "C3002", "R101H8", false));

        printItems();

        // edit / delete / get
        edit("T2000", "R101H3");
        edit("T2001", false);
        delete("C3003");
        delete("C3002");

        Meter m = get("W1001");
        if (m != null) {
            System.out.printf("Item status: %s\n", m.getWorkingStatus());
            if (m instanceof Thermometer){
                Thermometer t = (Thermometer)m;
                System.out.printf("Lowest temp: %f\n", t.getLowestTemperature());
            }
            if (m instanceof Weight){
                Weight w = (Weight)m;
                System.out.printf("Lowest weight: %f\n", w.getLowestWeight());
            }
            if (m instanceof Clock){
                Clock c = (Clock)m;
                System.out.printf("Lowest interval: %f\n", c.getLowestInterval());
            }
        }

        printItems();
    }

    public void printItems()
    {
        System.out.printf("\nInformation about all meters:\n\n");
        for (Meter m : archive.getMeters())
            System.out.println(m.toString());
    }

    public void edit(String reg, String placement)
    {
        if (!archive.editPlacement(reg, placement))
            archive.printNotFound(reg);
    }

    public void edit(String reg, boolean status)
    {
        if (!archive.editStatus(reg, status))
            archive.printNotFound(reg);
    }

    public void delete(String reg)
    {
        if (!archive.delete(reg))
            archive.printNotFound(reg);
    }

    public Meter get(String reg)
    {
        Meter m = archive.get(reg);
        if (m != null)
            System.out.printf("Picked up item with reg number: %s\n", reg);
        else
            archive.printNotFound(reg);

        return m;
    }
}