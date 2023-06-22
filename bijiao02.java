package 集合;

import java.util.Comparator;
import java.util.TreeSet;

public class bijiao02 {
    public static void main(String[] args) {
        Student s1=new Student("ab",23);
        Student s2=new Student("a" ,24);
        Student s3=new Student("abn",25);
        Student s4=new Student("uiopa",26);
        // 方式二
        TreeSet<Student> ts=new TreeSet<>(( o1, o2) ->{
                int i=o1.getName().length()-o2.getName().length();
                i = i==0?o1.getName().compareTo(o2.getName()):i;
                return i;
        });
        ts.add(s1);
        ts.add(s2);
        ts.add(s3);
        ts.add(s4);
        for (Student t : ts) {
            System.out.println(t);
        }
    }


}
