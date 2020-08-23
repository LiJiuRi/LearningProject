package list_add;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: liXu
 * @Date: 2019/9/11 23:08
 * @Description:
 */
public class Test {
    public static void main(String[] args) {
        List<User> list = new ArrayList<>();
        User user = new User();
        user.setName("lixu");
        list.add(user);
        for (User user1 : list){
            System.out.println("name=" + user1.getName());
            System.out.println(user1);
        }
        user.setName("update");
        for (User user2 : list){
            System.out.println("name=" + user2.getName());
            user2.setName("temp");
            System.out.println(user2);
        }
        for (User user3 : list){
            System.out.println("name=" + user3.getName());
            System.out.println(user3);
        }
    }
}
