public class Client {
    public static void main(String[] args)
    {
        Client client = new Client();
        client.mainMethod();
    }

    public void mainMethod()
    {
        MeterArchive archive = new MeterArchive();
        archive.add(new Clock(0.1, "C0000", "R0510", true));
        archive.add(new Thermometer(-30.0, 100.0, "T0000", "R0520", true));
        archive.add(new Weight(0.0, 200.0, "W0000", "R0530", true));

        for (Meter m : archive.getMeters())
            System.out.println(m.toString());
    }
}