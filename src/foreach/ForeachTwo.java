package foreach;/**
 * @Auther: liXu
 * @Date: 2019/7/20 10:07
 * @Description:
 */

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @Description
 * @Date $ $
 * @Author liXu
 * @Param $
 * @return $
 **/
public class ForeachTwo {
    public static void main(String[] args) {
        List<String> userNames = new ArrayList<String>() {{
            add("1");
            add("1");
            add("2");
        }};

        for (String userName : userNames) {
            if (userName.equals("2")) {
                userNames.remove(userName);
            }
        }
        System.out.println(userNames);
    }
}
