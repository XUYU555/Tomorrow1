package 集合;

import java.util.Iterator;
import java.util.LinkedList;

public class list {
    public static void main(String[] args) {
        LinkedList<String> list=new LinkedList<>();
        list.add("aaa");
        list.add("bbb");
        list.add("ccc");
        list.add("ddd");
        System.out.println(list);
        list.addFirst("QQQ");   //头插
        System.out.println(list);
        list.addLast("EEE");   //尾插
        System.out.println(list);
        String last = list.getLast();  //获得尾部
        System.out.println(last);
        String removeelemt = list.removeLast(); //尾删（会返回删除的值
        System.out.println("删除"+removeelemt+"之后的list"+list);
        String removefrist = list.removeFirst();  //头删
        System.out.println("头删的返回值"+removefrist);
        System.out.println(list);
        list.forEach(s -> System.out.println(s)); //lambda表达式遍历
        System.out.println("--------------------------------------------------------");
        Iterator<String> it = list.iterator();
        while(it.hasNext()){
            String next = it.next();
            if("bbb".equals(next))
            {
                it.remove();
            }
            //list.add("abd");list.remove(); 迭代器中不能使用集合的方法
        }
        System.out.println(list);
    }
}
