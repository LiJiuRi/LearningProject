package foreach;
/**
 * @Auther: liXu
 * @Date: 2019/7/20 09:51
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
public class Foreach {
    public static void main(String[] args) {
        // 使用ImmutableList初始化一个List
        List<String> userNames = new ArrayList<String>() {{
            add("Hollis");
            add("2");
        }};
        Iterator iterator = userNames.iterator();
        do
        {
            if(!iterator.hasNext())
                break;
            String userName = (String)iterator.next();
            if(userName.equals("Hollis"))
                userNames.remove(userName);
        } while(true);
        System.out.println(userNames);
    }
}
