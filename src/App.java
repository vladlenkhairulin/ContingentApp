import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import Controllers.AccountController;
import Domain.Employee;
import Domain.PersonComparator;
import Domain.Student;
import Domain.StudentGroup;
import Domain.Teacher;
import Services.StudentService;
import Services.TeacherService;

/*
* Название: Контингент школы.
* Описание: Приложение создает список студентов, учителей и рабочих.
* Автор: Хайрулин Владлен.
* Дата создания: 17.03.2024.
* Версия: 1.0.
* */
public class App {
    public static void main(String[] args) throws Exception {

        Student s1 = new Student("Иван", 25);
        Student s2 = new Student("Игорь", 23);
        Student s3 = new Student("Иван", 22);
        Student s4 = new Student("Игорь",  23);
        Student s5 = new Student("Даша",  23);
        Student s6 = new Student("Лена",  23);

        List<Student> listStud = new ArrayList<Student>();
        listStud.add(s1);
        listStud.add(s2);
        listStud.add(s3);
        listStud.add(s4);
        listStud.add(s5);
        listStud.add(s6);


        StudentGroup group4580 = new StudentGroup(listStud, 4580);

        StudentService studServ = new StudentService();

        for(Student<String> s : listStud)
        {
            studServ.create((String) s.getName(), s.getAge());
        }

        AccountController.print(studServ.getAll());

        studServ.sortByFIO();

        System.out.println("                             ");

        AccountController.print(studServ.getAll());


        Teacher<String> t1 = new Teacher<>("Галина", 55, "Docent");
        Teacher<String> t2 = new Teacher<>("Александр", 59, "Docent");
        Teacher<String> t3 = new Teacher<>("Дарья", 41, "Bachelor");

        List<Teacher<String>> listTeach = new ArrayList<Teacher<String>>();
        listTeach.add(t1);
        listTeach.add(t2);
        listTeach.add(t3);

        Employee<String> e1 = new Employee<>("Татьяна", 57, "Slesar");

        System.out.println(new PersonComparator<Student<String>>().compare(s1, s3));

        // AccountController controller = new AccountController();
        // controller.paySalary(t1, 50000);
        // controller.paySalary(s1, 50000);

        AccountController.paySalary(t1, 50000);
        //AccountController.paySalary(e1, 20000);

        System.out.println(AccountController.averageAge(listStud));

        TeacherService teachServ = new TeacherService();

        for(Teacher<String> s : listTeach)
        {
            teachServ.create2((String) s.getName(), s.getAge(), s.getAcadDegree());
        }
        teachServ.sortByName();
        System.out.println("                             ");

        System.out.println(teachServ);

    }
}