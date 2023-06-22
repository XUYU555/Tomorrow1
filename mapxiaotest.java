package 集合;

import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.function.BiConsumer;

public class mapxiaotest {
    public static void main(String[] args) {
        String[] arr={"A","B","C","D"};
        Random r=new Random();
        ArrayList<String> arrayList=new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            int index = r.nextInt(arr.length);
            arrayList.add(arr[index]);
        }
        Map<String,Integer> map=new HashMap<>();
        for (String s : arrayList) {
            if(map.containsKey(s))
            {
                Integer count = map.get(s);
                count++;
                map.put(s,count);
            }
            else {
                map.put(s,1);
            }
        }
        int max=0;
        for (String s : arr) {
            Integer count = map.get(s);
            if(count > max) max=count;
            System.out.println(s+"  "+count);
        }
        System.out.println(max);
        int finalMax = max;
        map.forEach((s, integer) ->{
                if(integer== finalMax)
                {
                    System.out.println(s);
                }
            }
        );
    }
}
