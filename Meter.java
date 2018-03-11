// We don't want Meter to be instantiated
public abstract class Meter {
    private String registrationNumber;
    private String storagePlace;
    private boolean workingStatus;

    public Meter(String registrationNumber, String storagePlace, boolean workingStatus)
    {
        this.registrationNumber = registrationNumber;
        this.storagePlace = storagePlace;
        this.workingStatus = workingStatus;
    }

    public String getworkingStatusToText()
    {
        return getWorkingStatus() ? "Working" : "Not working";
    }

    @Override
    public String toString()
    {
        String str = String.format("%-23s %s\n%-23s %s\n%-23s %s\n\n", "Registration Number: ", 
            registrationNumber, "Storage Place: ", storagePlace, "Status: ", 
            getworkingStatusToText());

        return str;
        //return "Registration Number: " + registrationNumber + "\nStorage Place: " +
        //       storagePlace + "\nStatus: " + getworkingStatusToText() + "\n\n";
    }

    public String getRegistrationNumber() { return registrationNumber; }
    public String getStoragePlace() { return storagePlace; }
    public boolean getWorkingStatus() { return workingStatus; }

    public void setRegistrationNumber(String nr) { registrationNumber = nr; }
    public void setStoragePlace(String place) { storagePlace = place; }
    public void setWorkingStatus(boolean status) { workingStatus = status; }
}
