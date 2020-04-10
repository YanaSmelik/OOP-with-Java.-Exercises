package personnel;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Employee {

    private List<Person> employees;



    public Employee() {
        employees = new ArrayList<Person>();
    }


    //adds the parameter person to the employee
    public void add(Person person) {
        employees.add(person);
    }


    //adds the parameter list of people to the employees
    public void add(List<Person> persons) {
        Iterator<Person> iterator = persons.iterator();

        while (iterator.hasNext()) {
            employees.add(iterator.next());
        }
    }


    //prints all employees
    public void print() {
        Iterator<Person> iterator = employees.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }


    //prints all the employees, who have the same education as the one specified as parameter
    public void print(Education education) {
        Iterator<Person> iterator = employees.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getEducation().equals(education)) {
                System.out.println(iterator.next());
            }
        }
    }


    //deletes all the employees whose education is the same as the method argument
    public void fire(Education education) {
        Iterator<Person> iterator = employees.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getEducation().equals(education)) {
                iterator.remove();
            }
        }
    }
}
