package 集合;
import java.util.Map;
import java.util.HashMap;

public class maptest02 {
    public static void main(String[] args) {
        Student s1=new Student("zhangsan",23);
        Student s2=new Student("lisi",24);
        Student s3=new Student("wangwu",25);
        Map<Student,String> map=new HashMap<>();
        map.put(s1,"长沙");
        map.put(s2,"江苏");
        map.put(s3,"北京");
        map.forEach((student, s) -> System.out.println(student+" = "+s) );
    }
}
