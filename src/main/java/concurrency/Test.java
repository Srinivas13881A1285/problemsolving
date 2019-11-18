package concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {
        //Creating Optional object from a String
        Optional<String> GOT = Optional.of("Game of Thrones");
        //Optional.empty() creates an empty Optional object
        Optional<String> nothing = Optional.empty();

        //orElse() method
        System.out.println(GOT.orElse("Default Value"));
        System.out.println(nothing.orElse("Default Value"));


        //orElseGet() method
        System.out.println(GOT.orElseGet(() -> "Default Value"));
        System.out.println(nothing.orElseGet(() -> "Default Value"));

        List<Student> studentlist = new ArrayList<Student>();
        //Adding Students
        studentlist.add(new Student(11,"Jon",22));
        studentlist.add(new Student(22,"Steve",18));
        studentlist.add(new Student(33,"Lucy",22));
        studentlist.add(new Student(44,"Sansa",23));
        studentlist.add(new Student(55,"Maggie",18));

        Double collect = studentlist.stream().collect(Collectors.averagingInt(student -> student.age));
        System.out.println("collect = " + collect);
    }
}
class Student{
    int id;
    String name;
    int age;
    public Student(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
}
