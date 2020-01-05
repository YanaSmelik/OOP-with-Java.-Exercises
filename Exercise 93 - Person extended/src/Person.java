import java.util.Calendar;

public class Person {

    private String name;
    private MyDate birthday;

    public Person(String name, int pp, int kk, int vv) {
        this.name = name;
        this.birthday = new MyDate(pp, kk, vv);
    }

    public Person(String name, MyDate birthday) {
        this.name = name;
        this.birthday = birthday;
    }

    public Person(String name) {
        this.name = name;
        this.birthday = currentDate();
    }

    public int age() {
        return this.birthday.differenceInYears(currentDate());
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return this.name + ", born " + this.birthday;
    }

    public boolean olderThan(Person compared) {
        return this.birthday.earlier(compared.birthday);
    }

    public MyDate currentDate() {
        int currentDay = Calendar.getInstance().get(Calendar.DATE);
        int currentMonth = (Calendar.getInstance().get(Calendar.MONTH)) + 1;
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        MyDate currentDate = new MyDate(currentDay, currentMonth, currentYear);
        return currentDate;
    }

}
