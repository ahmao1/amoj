package amoj.service;

import amoj.entity.Submit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class PantiService {
    public static final String REDIS_KEY = "amoj_judge:queue";
    private static Logger log = Logger.getLogger("panti");

    @Autowired
    private RedisTemplate redisTemplate;

    /*@TODO 传送数据到linux上的判题模块
   数据：submitId，语言，题目id，源代码，时限，内存限制，
   返回得到：
*/
    @Async("asyncServiceExecutor")
    public void panti(Submit submit){
        log.info("new submit " + submit);
        redisTemplate.opsForList().leftPush(REDIS_KEY, submit);
    }
}
