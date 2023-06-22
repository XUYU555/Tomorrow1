package Mystack;

public class NodeStackTest {
    public static void main(String[] args) {
        NodeStack<Student> ns=new NodeStack<>();
        ns.push(new Student("张三",23));
        ns.push(new Student("李四",24));
        ns.push(new Student("王五",25));
        ns.push(new Student("赵六",26));
        System.out.println(ns.top());
        ns.pop();
        System.out.println(ns.top());
        ns.pop();
        System.out.println(ns.top());
    }
}
