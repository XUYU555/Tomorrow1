package 集合;

import java.util.ArrayList;
import java.util.Collection;
import java.util.jar.Attributes;

public class collection {
    public static void main(String[] args) {
        Collection<String> coll = new ArrayList<>();  //Collection是接口类，不能直接创造对象，用实现类Arraylist
        coll.add("aaa");
        coll.add("bbb");
        coll.add("ccc");
        coll.add("ddd");
        System.out.println(coll);
        coll.remove("aaa");
        System.out.println(coll);
        System.out.println(coll.contains("bbb"));
        System.out.println(coll.contains("aaa"));
        System.out.println(coll.isEmpty());
        System.out.println(coll.size());
        coll.clear();
        System.out.println(coll.isEmpty());
        System.out.println(coll.size());
    }


}
