package Domain;

public class Employee<T> extends Person<T>{
    private String special;

    public Employee(T firstName, int age, String special) {
        super(firstName, age);
        this.special = special;
    }
}