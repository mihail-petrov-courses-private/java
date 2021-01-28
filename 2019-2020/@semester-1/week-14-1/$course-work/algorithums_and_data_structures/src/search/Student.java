package search;

public class Student implements IStudent {

    public String name;
    public int age;

    public Student(String name, int age) {

        this.name = name;
        this.age = age;
    }

    @Override
    public int grade() {
        return 6;
    }

    public String toString() {
        return this.name + " " + this.age;
    }
}
