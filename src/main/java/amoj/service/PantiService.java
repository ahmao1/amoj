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

    @Async("asyncServiceExecutor")
    public void panti(Submit submit){
        log.info("new submit " + submit);
        redisTemplate.opsForList().leftPush(REDIS_KEY, submit);
    }
}
