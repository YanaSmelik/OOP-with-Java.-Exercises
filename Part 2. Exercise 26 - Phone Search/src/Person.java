public class Person implements Comparable<Person>{

    private String name;
    private String phoneNumber;
    private Address address;

    public Person(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public Person(String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        if (phoneNumber == null) {
            return "\n " + name + "\n" + "  address: " + this.address  + "  phone number not found";
        } else if(address == null) {
            return "\n " + name + "\n" + "  address unknown\n"+ "  phone numbers:\n" + "  " + phoneNumber;
        }else {
            return "\n " + name + "\n" + "  address: " + this.address + "  phone numbers:\n" + "  " + phoneNumber;
        }
    }

    @Override
    public int compareTo(Person prs) {
        int compare = this.getName().compareTo(prs.getName());
        return compare;
    }
}
