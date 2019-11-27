package cn.weicelove.spring.external;

/**
 * @author QIU PANWEI Create in 2019/11/25 14:44
 */
public class Student {

    private String name;
    private Integer age;

    public Student(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
