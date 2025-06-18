class Employee {
    String employeeId;
    String name;
    String position;
    double salary;

    public Employee(String employeeId, String name, String position, double salary) {
        this.employeeId = employeeId;
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    public String toString() {
        return "[" + employeeId + ", " + name + ", " + position + ", $" + salary + "]";
    }
}

public class EmployeeManagement {
    static final int MAX = 100;
    Employee[] employees = new Employee[MAX];
    int count = 0;

    public void addEmployee(Employee e) {
        if (count < MAX) employees[count++] = e;
        else System.out.println("Employee limit reached.");
    }

    public Employee searchEmployee(String id) {
        for (int i = 0; i < count; i++) {
            if (employees[i].employeeId.equals(id))
                return employees[i];
        }
        return null;
    }

    public void deleteEmployee(String id) {
        for (int i = 0; i < count; i++) {
            if (employees[i].employeeId.equals(id)) {
                for (int j = i; j < count - 1; j++)
                    employees[j] = employees[j + 1];
                employees[--count] = null;
                return;
            }
        }
        System.out.println("Employee not found.");
    }

    public void traverse() {
        for (int i = 0; i < count; i++) {
            System.out.println(employees[i]);
        }
    }

    public static void main(String[] args) {
        EmployeeManagement em = new EmployeeManagement();
        em.addEmployee(new Employee("E001", "John", "Manager", 5000));
        em.addEmployee(new Employee("E002", "Jane", "Developer", 4000));

        em.traverse();

        System.out.println("\nSearching:");
        System.out.println(em.searchEmployee("E002"));

        System.out.println("\nDeleting E001:");
        em.deleteEmployee("E001");
        em.traverse();
    }
}
