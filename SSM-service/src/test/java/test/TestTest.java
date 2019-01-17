package test;

import com.alibaba.fastjson.JSON;
import com.dragon.bean.Member;
import com.dragon.dao.MemberDao;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:spring-*.xml","classpath*:mapper/*.xml"})
public class TestTest {
    @Autowired
    private MemberDao memberDao;

    private Logger logger = Logger.getLogger(TestTest.class);

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void testFind() throws Exception{
        Member member = memberDao.findById(1);
        System.out.println(member);
//        logger.error(member);
    }


}
