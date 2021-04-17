package amoj;

import amoj.entity.Result;
import amoj.service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
public class ResultRunner implements ApplicationRunner {
    public static final String REDIS_KEY = "amoj_result:queue";
    private static Logger log = Logger.getLogger("judgerunner");

    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private ResultService resultService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        while(true){
            while(redisTemplate.opsForList().size(REDIS_KEY)>0){
                Result result = (Result) redisTemplate.opsForList().rightPop(REDIS_KEY);
                log.info(Thread.currentThread().getName() + "get result " + result);
                resultService.addResult(result);
            }
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}