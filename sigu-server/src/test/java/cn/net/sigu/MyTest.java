package cn.net.sigu;

import lombok.Data;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class MyTest {

    @Test
    public void test() {

        List<Student> list = buildStudentList();

        list.stream().collect(Collectors.toCollection(()-> new TreeSet<>(Comparator.comparing(Student::getName))));
    }

    private List<Student> buildStudentList() {
        return Arrays.asList(new Student(1, "张扬", 18, "A", "北京", 45, 83.2),
                new Student(2, "李丹", 22, "A", "天津", 15, 65.5),
                new Student(3, "张丹", 22, "B", "山东", 44, 78.4),
                new Student(4, "白天", 19, "B", "北京", 1, 63.7),
                new Student(5, "王武", 20, "C", "湖南", 34, 78.3)
        );
    }
}


@Data
class Student {
    /**
     * 编号
     */
    private Integer id;
    /**
     * 姓名
     */
    private String name;
    /**
     * 年龄
     */
    private Integer age;
    /**
     * 班级
     */
    private String className;
    /**
     * 所在省
     */
    private String province;
    /**
     * 学号
     */
    private Integer stuNo;
    /**
     * 入学成绩
     */
    private Double score;

    public Student(Integer id, String name, Integer age, String className, String province, Integer stuNo, Double score) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.className = className;
        this.province = province;
        this.stuNo = stuNo;
        this.score = score;
    }
}