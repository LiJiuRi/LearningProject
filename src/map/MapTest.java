package map;

import java.util.*;

/**
 * @Auther: liXu
 * @Date: 2019/9/16 22:38
 * @Description:
 */
public class MapTest {
    public static void main(String[] args) {
        // 定义一个Map的容器对象
        Map<String, Integer > map1 = new HashMap<String, Integer >();
        map1.put("jack", 20);
        map1.put("rose", 18);
        map1.put("lucy", 17);
        map1.put("java", 25);
        System.out.println(map1);
        // 添加重复的键值（值不同）,会返回集合中原有（重复键）的值，		 System.out.println(map1.put("jack", 30)); //20

        Map<String, Integer> map2 = new HashMap<String, Integer>();
        map2.put("张三丰", 100);
        map2.put("虚竹", 20);
        map2.clear();
// 从指定映射中将所有映射关系复制到此映射中。
        map1.putAll(map2);

        Set set = map1.keySet();
        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()) {
            String str = iterator.next();
            System.out.println(map1.get(str));
        }
        System.out.println("-------------");
        Collection<Integer> collection = map1.values();
        Iterator iterator1 = collection.iterator();
        while (iterator1.hasNext()) {
            System.out.println(iterator1.next());
        }
        System.out.println("-------------");
        Set<Map.Entry<String,Integer>> entrySet = map1.entrySet();
        Iterator<Map.Entry<String,Integer>> entryIterator = entrySet.iterator();
        Map.Entry<String,Integer> map;
        String key;
        Integer value;
        while (entryIterator.hasNext()) {
            map = entryIterator.next();
            key = map.getKey();
            value = map.getValue();
            System.out.println("key=" + key + "  value=" + value);
            System.out.println("key="+key.hashCode()+"  map="+map.hashCode()+"  value="+value.hashCode());
        }
    }
}