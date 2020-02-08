import java.util.*;

public class PhoneBook {

    private Scanner reader;

    private Map<String, Set<String>> personsPhoneNumbers;
    private Map<Person, Address> personAddress;
    private List<Person> personList;
    private List<Address> addressList;

    public PhoneBook() {
        this.personsPhoneNumbers = new HashMap<String, Set<String>>();
        this.personAddress = new HashMap<Person, Address>();
        this.reader = new Scanner(System.in);
        this.personList = new ArrayList<Person>();
        this.addressList = new ArrayList<Address>();

    }

    public void startApp() {
        printMenu();
        while (true) {
            System.out.print("command: ");
            String command = reader.nextLine();

            if (command.equals("1")) {
                addPersonPhoneNumber();
            } else if (command.equals("2")) {
                searchForNumberByName();
            } else if (command.equals("3")) {
                searchForPersonByPhoneNumber();
            } else if (command.equals("4")) {
                addAnAddress();
            } else if (command.equals("5")) {
                searchForPersonalInformation();
            } else if (command.equals("6")) {
                deletePersonInformation();
            } else if (command.equals("7")) {
                filterListing();
            } else if (command.equals("x")) {
                break;
            }
            System.out.println();
        }

    }

    private void printMenu() {
        System.out.println("phone search\n" +
                "available operations:\n" +
                " 1 add a number\n" +
                " 2 search for a person\n" +
                " 3 search for a person by phone number\n" +
                " 4 add an address\n" +
                " 5 search for a personal information\n" +
                " 6 delete personal information\n" +
                " 7 filtered listing\n" +
                " x quit\n");
    }


    // adding a phone number to the relative person
    public void addPersonPhoneNumber() {
        System.out.print("whose number: ");
        String name = reader.nextLine();
        System.out.print("number: ");
        String phoneNumber = reader.nextLine();
        if (!isPersonInTheList(name)) {
            personList.add(new Person(name, phoneNumber));
        }
        if (!personsPhoneNumbers.containsKey(name)) {
            personsPhoneNumbers.put(name, new HashSet<String>());
        }
        personsPhoneNumbers.get(name).add(phoneNumber);
    }


    public boolean isPersonInTheList(String name) {
        for (Person prs : personList) {
            if (prs.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    // phone number search by person
    public void searchForNumberByName() {
        System.out.print("whose number: ");
        String name = reader.nextLine();
        if (findNumberInPersonList(name) != null) {
            printPhoneNumberList(findNumberInPersonList(name));
        } else {
            System.out.println("  not found");
        }
    }

    private Set<String> findNumberInPersonList(String name) {
        for (String personName : personsPhoneNumbers.keySet()) {
            if (personName.equals(name)) {
                return personsPhoneNumbers.get(name);
            }
        }
        return null;
    }

    private void printPhoneNumberList(Set<String> phNumbers) {
        for (String phoneNumber : phNumbers) {
            System.out.println("   " + phoneNumber);
        }
    }


    //name search by phone number
    public void searchForPersonByPhoneNumber() {
        boolean present = false;
        System.out.print("number: ");
        String phNumber = reader.nextLine();
        for (String prs : personsPhoneNumbers.keySet()) {
            if (getPhoneLisOfOnePerson(prs).contains(phNumber)) {
                System.out.println(" " + prs);
                present = true;
                break;
            }
        }
        if (present == false) {
            System.out.println(" not found");
        }
    }

    private List<String> getPhoneLisOfOnePerson(String personName) {
        for (String prs : personsPhoneNumbers.keySet()) {
            if (prs.equals(personName)) {
                List<String> phoneNumbersOfThisPerson = phoneNumberToString(personsPhoneNumbers.get(prs));
                return phoneNumbersOfThisPerson;
            }
        }
        return null;
    }

    private List<String> phoneNumberToString(Set<String> numbers) {
        List<String> numbersToString = new ArrayList<String>();
        for (String phNumber : numbers) {
            numbersToString.add(phNumber);
        }
        return numbersToString;
    }

    //add address to the relative person
    public void addAnAddress() {
        System.out.print("whose address: ");
        String name = reader.nextLine();
        if (isPersonInTheList(name) == false) {
            personList.add(new Person(name));
        }
        System.out.print("street: ");
        String street = reader.nextLine();
        System.out.print("city: ");
        String city = reader.nextLine();
        Address address = new Address(street, city);
        addAddressToPerson(name, address);
        getPerson(name).setAddress(address);
        addressList.add(address);

    }


    private void addAddressToPerson(String personName, Address address) {
        for (Person prs : personList) {
            if (prs.getName().equals(personName)) {
                personAddress.put(prs, address);
            }
        }
    }


    //search for personal information
    public void searchForPersonalInformation() {
        System.out.print("whose information: ");
        String name = reader.nextLine();
        if (isPersonInTheList(name) == false) {
            System.out.println("   not found");
        } else {
            for (Person prs : personList) {
                if (prs.getName().equals(name)) {
                    System.out.print("  address");
                    if (personAddress.get(prs) == null) {
                        System.out.print(" unknown\n");
                    } else {
                        System.out.print(": " + personAddress.get(prs));
                    }
                    if (personsPhoneNumbers.get(prs.getName()) == null) {
                        System.out.println("  phone number not found");
                    } else {
                        System.out.println("  phone numbers:");
                        printPhoneNumberList(personsPhoneNumbers.get(prs.getName()));
                    }
                }
            }
        }
    }


    //delete person's information
    public void deletePersonInformation() {
        System.out.print("whose information: ");
        String name = reader.nextLine();
        if (getPerson(name) != null) {
            personsPhoneNumbers.remove(getPerson(name));
            personAddress.remove(getPerson(name));
            personList.remove(getPerson(name));
        }
    }


    private Person getPerson(String name) {
        for (Person prs : personList) {
            if (prs.getName().equals(name)) {
                return prs;
            }
        }
        return null;
    }


    //filter listings
    public void filterListing() {
        System.out.print("keyword (if empty, all listed): ");
        String keyword = reader.nextLine();
        if (filterByPerson(keyword).size() != 0) {
            printList(filterByPerson(keyword));
        } else if (filterByPhoneNumber(keyword) != null) {
            System.out.println(filterByPhoneNumber(keyword));
        } else if (filterByAddress(keyword) != null) {
            System.out.println(filterByAddress(keyword));
        } else {
            printAllPersons();
        }
    }

    private List<Person> filterByPerson(String keyword) {
        List<Person> persons = new ArrayList<Person>();
        for (Person prs : personList) {
            if (prs.getName().contains(keyword)) {
                persons.add(prs);
            }
        }
        return persons;
    }

    private void printList(List<Person> persons) {
        Collections.sort(persons);
        for (Person prs : persons) {
            System.out.println(prs);
        }
    }

    public Person filterByPhoneNumber(String keyword) {
        for (Person prs : personList) {
            if (prs.getPhoneNumber() != null && prs.getPhoneNumber().contains(keyword)) {
                return prs;
            }
        }
        return null;
    }

    public Person filterByAddress(String keyword) {
        for (Address adrs : addressList) {
            if (adrs.getStreet().contains(keyword) || adrs.getCity().contains(keyword)) {
                return getPersonByAddress(adrs);
            }
        }
        return null;
    }

    public void printAllPersons() {
        Collections.sort(personList);
        for (Person prs : personList) {
            System.out.println(prs);
        }
    }


    private Person getPersonByAddress(Address adrs) {
        for (Person prs : personAddress.keySet()) {
            if (personAddress.get(prs).equals(adrs)) {
                return prs;
            }
        }
        return null;
    }
}
