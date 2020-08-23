package map;/**
 * @Auther: liXu
 * @Date: 2019/9/18 00:01
 * @Description:
 */

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Description
 * @Date $ $
 * @Author liXu
 * @Param $
 * @return $
 **/
public class Test {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3);

        // [10, 20, 30]
        List<Integer> collect = list.stream().map(i -> i * 10).collect(Collectors.toList());
        collect.forEach(x-> System.out.print(x+"  "));
        System.out.println();
        // [20, 10, 30]
        Set<Integer> collect1 = list.stream().map(i -> i * 10).collect(Collectors.toSet());
        collect1.forEach(x-> System.out.print(x+"  "));
        System.out.println();
        // {key1=value:10, key2=value:20, key3=value:30}
        Map<String, String> collect2 = list.stream().map(i -> i * 10).collect(Collectors.toMap(a -> "key" + a/10, value -> "value:" + value));
        Set<Map.Entry<String,String>> list1 = collect2.entrySet();
        Iterator<Map.Entry<String,String>> iterator = list1.iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String> map = iterator.next();
            String key = map.getKey();
            String value = map.getValue();
            System.out.println("key="+key+" value="+value);
        }
        System.out.println();
        // [1, 3, 4]
        TreeSet<Integer> collect3= Stream.of(1, 3, 4).collect(Collectors.toCollection(TreeSet::new));
    }
}
