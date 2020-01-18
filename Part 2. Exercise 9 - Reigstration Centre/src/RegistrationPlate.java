public class RegistrationPlate {

    private final String regCode;
    private final String country;

    public RegistrationPlate(String regCode, String country) {
        this.regCode = regCode;
        this.country = country;
    }

    public String toString() {
        return regCode + " " + country;
    }

    public String getRegCode() {
        return regCode;
    }

    public String getCountry() {
        return country;
    }

    //override Object method to make it able to compare values of objects.
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }

        //make two objects of the same type
        RegistrationPlate regPlate = (RegistrationPlate) obj;

        if (this.regCode != regPlate.getRegCode()) {
            return false;
        }

        if (this.country == null || !this.country.equals(regPlate.getCountry())) {
            return false;
        }
        return true;
    }

    //override Object method to make it able to compare values of objects.
    @Override
    public int hashCode() {
        if (this.regCode == null) {
            return -1;
        }
        return this.country.hashCode();
    }
}
