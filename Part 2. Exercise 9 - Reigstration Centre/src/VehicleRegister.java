import java.util.HashMap;
import java.util.HashSet;

public class VehicleRegister {

    private HashMap<RegistrationPlate, String> owners;

    public VehicleRegister() {
        this.owners = new HashMap<RegistrationPlate, String>();
    }

    public boolean add(RegistrationPlate plate, String owner) {
        if (this.owners.get(plate) == null) {
            this.owners.put(plate, owner);
            return true;
        }
        return false;
    }

    public String get(RegistrationPlate plate) {
        if (this.owners.get(plate) == null) {
            return null;
        }
        return this.owners.get(plate);
    }

    public boolean delete(RegistrationPlate plate) {
        if (this.owners.get(plate) == null) {
            return false;
        }
        this.owners.remove(plate);
        return true;
    }

    public void printRegistrationPlates() {
        for (RegistrationPlate plate : owners.keySet()) {
            System.out.println(plate);
        }
    }

    public void printOwners() {
        HashSet<String> temp = new HashSet<String>(); //used HashSet to print values without duplicates
        temp.addAll(owners.values());
        for (String owner : temp) {
            System.out.println(owner);
        }


    }

}
