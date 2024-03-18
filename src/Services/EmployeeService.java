package Services;

import java.util.ArrayList;
import java.util.List;

import Domain.Employee;
import Domain.PersonComparator;
import Domain.Student;

public class EmployeeService implements iPersonService<Employee> {

    private int count;
    private List<Employee> employees;

    public EmployeeService() {
        this.employees = new ArrayList<>();
    }

    @Override
    public List<Employee> getAll() {
        return employees;
    }

    @Override
    public void create(String name, int age) {
        Employee epls = new Employee(name, age, "basic");
        count++;
        employees.add(epls);
    }

    /**
     * @param name   имя
     * @param age    возраст
     * @param degree степень
     *               Описание:
     *               отдельный метод создания учителя, учитывающий степень.
     *  ПРИМЕЧАНИЕ: метод не используется для сотрудников.
     */
    @Override @Deprecated
    public void create2(String name, int age, String degree) {
    }

    /**
     * ортировка по имени
     */
    public void sortByFIO()
    {
        PersonComparator<Employee> persComp = new PersonComparator<Employee>();
        employees.sort(persComp);
    }

    // @Override
    // public void print(List<Employee> group) {
    //     for(Employee s : group)
    //     {
    //         System.out.println(s);
    //     }
    // }
}
