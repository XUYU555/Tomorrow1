package 集合;
import java.util.*;
import java.util.function.BiConsumer;

class maptest {
    public static void main(String[] args) {
        Map<Integer, String> mp = new HashMap<Integer, String>();
        mp.put(123, "zhangsan");
        mp.put(456, "lisi");
        mp.put(789, "wangwu");
        Set<Integer> st = mp.keySet();  //单列集合
        // 增强for
        for (Integer integer : st) {
            System.out.println(mp.get(integer));
        }
        // 迭代器
        Iterator<Integer> it = st.iterator();
        while(it.hasNext()) {
            System.out.println(mp.get(it.next()));
        }
        // lambe表达式
        st.forEach(s-> System.out.println(mp.get(s)));

        Set<Map.Entry<Integer, String>> entry = mp.entrySet();
        for (Map.Entry<Integer, String> integerStringEntry : entry) {
            System.out.println(integerStringEntry.getKey()+"   "+integerStringEntry.getValue());
        }

        Iterator<Map.Entry<Integer, String>> iterator = entry.iterator();
        while(iterator.hasNext())
        {
            Map.Entry<Integer, String> is=iterator.next();
            System.out.println(is.getKey()+"   " +is.getValue());
        }

        entry.forEach(is1 -> System.out.println(is1.getKey()+"   "+is1.getValue()));

        mp.forEach((Integer integer, String s) -> System.out.println(integer+"   "+s));
    }
}

