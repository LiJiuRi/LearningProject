package map;/**
 * @Auther: liXu
 * @Date: 2019/9/17 00:24
 * @Description:
 */

import foreach.Foreach;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @Description
 * @Date $ $
 * @Author liXu
 * @Param $
 * @return $
 **/
public class Map_List {
    public static void main(String[] args) {
        // 集合1
        List<SkillUpgrade> lists = new ArrayList<>();
        SkillUpgrade s = new SkillUpgrade();
        s.setLv(1);
        s.setAppearNum(100);
        lists.add(s);
        SkillUpgrade s2 = new SkillUpgrade();
        s2.setLv(2);
        s2.setAppearNum(200);
        lists.add(s2);
        SkillUpgrade s3 = new SkillUpgrade();
        s3.setLv(2);
        s3.setAppearNum(200);
        lists.add(s3);
        Map<Integer,List<SkillUpgrade>> map = lists.stream().collect(Collectors.groupingBy(SkillUpgrade::getLv));
        System.out.println(map);
        /*// 集合1
        Map<Integer,Integer> map = lists.stream().collect(
                Collectors.toMap(SkillUpgrade::getLv,SkillUpgrade::getAppearNum)
        );
        System.out.println("map="+map.get(1));
        List<Integer> list = lists.stream().map(x-> x.getLv()).collect(Collectors.toList());
        list.forEach(System.out::println);
        System.out.println(map);*/
    }

    /**
     * output:map:={1=SkillUpgrade [skillId=null, skillName=null, lv=1, persNum=null, selectNum=1100, appearNum=null], 2=SkillUpgrade [skillId=null, skillName=null, lv=2, persNum=null, selectNum=1200, appearNum=null]}
     *        lists:=[SkillUpgrade [skillId=null, skillName=null, lv=1, persNum=null, selectNum=1100, appearNum=100], SkillUpgrade [skillId=null, skillName=null, lv=2, persNum=null, selectNum=1200, appearNum=200]]
     */
}
