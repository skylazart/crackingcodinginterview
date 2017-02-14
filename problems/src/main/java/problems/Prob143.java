package problems;

import org.joda.time.DateTime;
import java.util.*;

/**
 * Created by fsantos on 2/8/17.
 */
public class Prob143 {
    /*
    Call Center: Imagine you have a call center with three levels of employees: respondent, manager,
and director. An incoming telephone call must be first allocated to a respondent who is free. If the
respondent can't handle the call, he or she must escalate the call to a manager. If the manager is not
free or not able to handle it, then the call should be escalated to a director. Design the classes and
data structures for this problem. Implement a method dispatchCall() which assigns a call to
the first available employee.
     */

    /*
    Major entities
    EmployeeType (Respondent, Manager, Director)

    Employees implements Comparable<Employees>
        String name
        EmployeeType getType()
        int compareTo(Employees e)
            // Compare the name and position

    Customer
        String id
        String phoneNumber
        String name

    Call
        - StartingDateTime
        - Customer

    CallCenter (Interface)
        Employee dispatchCall(Call)

    CallCenterWithPriority implements CallCenter
        List<Employee> availableRespondent
        List<Employee> availableManager
        List<Employee> availableDirector
        List<Employee> busy

        addEmployee(Employee)

        Employee dispatchCall(Call)
            // Find free employee using the lists and remove from the availability list

        endCall(Employee)
            // Return to the availability list

    Statistics (Singleton)
        totalOfCalls
        totalAttendedByRespondent
        totalAttendendByManager
        totlaAttendedByDirector
    */

    public static class Statistics {
        private static Statistics instance = null;

        private int totalOfCalls = 0;
        private int totalAttendedByRespondent = 0;
        private int totalAttendendByManager = 0;
        private int totlaAttendedByDirector = 0;
        private int totalOfErros = 0;

        private Statistics() {

        }

        public static Statistics getInstance() {
            if (instance == null)
                instance = new Statistics();

            return instance;
        }

        public void addCallAttended(Call call, Employee employee) {
            totalOfCalls++;
            if (employee == null) {
                totalOfErros++;
                return;
            }

            switch(employee.getEmployeeType()) {
                case RESPONDENT:
                    totalAttendedByRespondent++;
                    break;
                case MANAGER:
                    totalAttendendByManager++;
                    break;
                case DIRECTOR:
                    totlaAttendedByDirector++;
                    break;
                default:
                    throw new IllegalStateException("Employee type unknown");
            }
        }

        @Override
        public String toString() {
            return "Statistics{" +
                    "totalOfCalls=" + totalOfCalls +
                    ", totalAttendedByRespondent=" + totalAttendedByRespondent +
                    ", totalAttendendByManager=" + totalAttendendByManager +
                    ", totlaAttendedByDirector=" + totlaAttendedByDirector +
                    ", totalOfErros=" + totalOfErros +
                    '}';
        }
    }

    public static enum EmployeeType {RESPONDENT, MANAGER, DIRECTOR};

    public static class Employee {
        private final EmployeeType employeeType;
        private final String name;

        public Employee(EmployeeType employeeType, String name) {
            this.employeeType = employeeType;
            this.name = name;
        }

        public EmployeeType getEmployeeType() {
            return employeeType;
        }

        public String getName() {
            return name;
        }
    }

    public static class Customer implements Comparable<Customer> {
        private final String name;
        private final String phoneNumber;


        public Customer(String name, String phoneNumber) {
            this.name = name;
            this.phoneNumber = phoneNumber;
        }

        public String getName() {
            return name;
        }

        public String getPhoneNumber() {
            return phoneNumber;
        }

        @Override
        public int compareTo(Customer o) {
            return phoneNumber.compareTo(o.getPhoneNumber());
        }
    }

    public static class Call {
        private final DateTime startDateTime;
        private final Customer customer;

        public Call(DateTime startDateTime, Customer customer) {
            this.startDateTime = startDateTime;
            this.customer = customer;
        }

        public DateTime getStartDateTime() {
            return startDateTime;
        }

        public Customer getCustomer() {
            return customer;
        }
    }

    public interface CallCenter {
        Employee dispatchCall(Call call);
    }

    public static class PriorityCallCenter implements CallCenter {
        private List<Employee> availableRespondent = new ArrayList<>();
        private List<Employee> availableManager = new ArrayList<>();
        private List<Employee> availableDirector = new ArrayList<>();
        private Set<Employee> busy = new HashSet<>();

        @Override
        public Employee dispatchCall(Call call) {
            Employee found = null;
            if (availableRespondent.size() > 0) {
                Employee employee = availableRespondent.remove(availableRespondent.size() - 1);
                busy.add(employee);
                found = employee;
            } else if (availableManager.size() > 0) {
                Employee employee = availableManager.remove(availableManager.size() - 1);
                busy.add(employee);
                found = employee;
            } else if (availableDirector.size() > 0) {
                Employee employee = availableDirector.remove(availableDirector.size() - 1);
                busy.add(employee);
                found = employee;
            }

            Statistics statistics = Statistics.getInstance();
            statistics.addCallAttended(call, found);

            if (found == null)
                throw new IllegalStateException("Employee not available to receive the call");

            return found;
        }

        public void endCall(Employee employee) {
            if (busy.contains(employee)) {
                busy.remove(employee);
                switch(employee.getEmployeeType()) {
                    case RESPONDENT:
                        availableRespondent.add(employee);
                        break;
                    case MANAGER:
                        availableManager.add(employee);
                        break;
                    case DIRECTOR:
                        availableDirector.add(employee);
                        break;
                    default:
                        throw new IllegalStateException("Unknown employee type");
                }
            } else {
                throw new IllegalArgumentException("Employee not identified as current attendant");
            }
        }
    }
}
