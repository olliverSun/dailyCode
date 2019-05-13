package lambda表达式;

public class Student {
    String name;
    Integer Student_num;

    Integer gender; //性别 1男 0女

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", Student_num=" + Student_num +
                ", gender=" + gender +
                '}';
    }

    public Student(String name, Integer student_num, Integer gender) {
        this.name = name;
        Student_num = student_num;
        this.gender = gender;

    }
}
