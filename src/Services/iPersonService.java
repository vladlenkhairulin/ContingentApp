package Services;

import java.util.List;

public interface iPersonService<T> {
    List<T> getAll();
    void create(String name, int age);

    /**
     * @param name имя
     * @param age возраст
     * @param degree степень
     * Описание:
     * отдельный метод создания учителя, учитывающий степень.
     */
    void create2(String name, int age, String degree);
}
