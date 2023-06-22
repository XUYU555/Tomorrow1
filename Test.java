package 集合;

import java.util.TreeSet;

public class Test {
    public static void main(String[] args) {
        Student s1=new Student("zhangsan",23);
        Student s2=new Student("lisi" ,24);
        Student s3=new Student("wangwu",25);
        Student s4=new Student("zhaoliu",26);
        TreeSet<Student> ts=new TreeSet<>();
        ts.add(s1);
        ts.add(s2);
        ts.add(s3);
        ts.add(s4);
        for (Student t : ts) {
            System.out.println(t);
        }
    }

}
