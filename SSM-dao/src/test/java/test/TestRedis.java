package test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.dragon.bean.Member;
import com.dragon.dao.MemberDao;
import com.dragon.utils.RedisUtils;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:spring-*.xml","classpath*:mapper/*.xml"})
public class TestRedis {

    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private MemberDao memberDao;
    @Autowired
    private RedisUtils redisUtils;

    private Logger logger = Logger.getLogger(TestRedis.class);

    @Test
    public void testSpringRedis() throws Exception{

        redisTemplate.opsForValue().set("name", "lance");

        logger.error(redisTemplate.opsForValue().get("name"));

        redisTemplate.opsForList().leftPush("myList", "1");
        redisTemplate.opsForList().leftPush("myList", "2");
        redisTemplate.opsForList().leftPush("myList", "3");
        redisTemplate.opsForList().leftPush("myList", "4");

        List<String> listCache = redisTemplate.opsForList().range("myList", 0, -1);
        for (String s : listCache) {
            logger.error(s);
        }

        Member member = memberDao.findById(1);
        redisTemplate.opsForValue().set("member", JSON.toJSON(member));

        Member member2 = JSONObject.parseObject(redisTemplate.opsForValue().get("member").toString(), Member.class);

        logger.error(member2);
    }

    @Test
    public void TestSpringRedis2() throws Exception{
        /*String  str = "string";//1.字符串
        List<String> list = new ArrayList<String>();//list
        list.add("0");
        list.add("中国");
        list.add("2");
        Set<String> set = new HashSet<String>();//set
        set.add("0");
        set.add("中国");
        set.add("2");
        Map<String, Object> map = new HashMap();//map
        map.put("key1", "str1");
        map.put("key2", "中国");
        map.put("key3", "str3");

        //1.字符串操作
        redisUtils.set("str", str);
        redisUtils.expire("str", 120);//指定失效时间为2分钟
        String str1 = (String) redisUtils.get("str");
        System.out.println(str1);

        //2.list操作
        redisUtils.lSet("list", list);
        redisUtils.expire("list", 120);//指定失效时间为2分钟
        List<Object> list1 = redisUtils.lGet("list", 0, -1);
        System.out.println(list1);*/

        Member member = memberDao.findById(1);
        redisUtils.set("member", member);

        System.out.println((Member)redisUtils.get("member"));
    }

}
