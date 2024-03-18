package Services;

import Domain.PersonComparator;
import Domain.Teacher;

import java.util.ArrayList;
import java.util.List;

/*
* Класс для добавления учителей в список учителей,
* для сортировки по имени и вывода списка на консоль.
* */
public class TeacherService implements iPersonService<Teacher>{
    private int count;
    private List<Teacher> teachers;

    public TeacherService() {
        this.teachers = new ArrayList<>();
    }

    @Override
    public List<Teacher> getAll() {
        return teachers;
    }

    /**
     * @param name имя
     * @param age возраст
     * Описание:
     * метод можно использовать, если у учителя не указана ученая степень.
     */
    @Override
    public void create(String name, int age) {
        create2(name, age, "None");
        //count++;
        //teachers.add(teach);
    }

    /**
     * @param name имя учителя
     * @param age возраст
     * @param degree ученая степень
     * Описание:
     * метод перезаписывает метод create из обобщенного интерфейса,
     *               чтобы у класса учителей была возможность добавлять ученую степень.
     */
    @Override
    public void create2(String name, int age, String degree) {
        Teacher teach = new Teacher(name, age, degree);
        count++;
        teachers.add(teach);
        // Ваш код для добавления преподавателя
    }

    /**
     * Сортировка по имени
     */
    public void sortByName()
    {
        PersonComparator<Teacher> comp = new PersonComparator<Teacher>();
        teachers.sort(comp);
    }
    @Override
    public String toString() {
        // Сортируем учителей по имени перед выполнением операции вывода
        sortByName();

        StringBuilder sb = new StringBuilder();
        sb.append("Teachers:\n");
        for (Teacher teacher : teachers) {
            sb.append(teacher).append("\n");
        }
        return sb.toString();
    }
}
