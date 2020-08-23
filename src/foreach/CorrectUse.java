package foreach;/**
 * @Auther: liXu
 * @Date: 2019/7/21 09:27
 * @Description:
 */

import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Date $ $
 * @Author liXu
 * @Param $
 * @return $
 **/
public class CorrectUse {
    public static void main(String[] args) {
        List<String> a = new ArrayList<String>();
        a.add("1");
        a.add("2");
        a.add("3");

        for (int i = 0; i < a.size(); i++) {

            String e = a.get(i);

            if("1".equals(e)){
                a.remove(i);
                i=i-1; //修正index
            }else{
                a.set(i,e+"1");
            }

        }
        System.out.println(a);
    }
}
