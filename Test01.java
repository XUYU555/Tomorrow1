package Mystack;

public class Test01 {
    public static void main(String[] args) {
        MyStack<Student> mystack=new MyStack<>();
        mystack.push(new Student("张三",23));
        mystack.push(new Student("李四",24));
        mystack.push(new Student("王五",25));
        mystack.push(new Student("赵六",26));
        System.out.println(mystack);
        Student pop = mystack.pop();
        System.out.println(pop);
        System.out.println(mystack);
        System.out.println(mystack.top());
        int size = mystack.size();
        System.out.println(size);
    }
}
