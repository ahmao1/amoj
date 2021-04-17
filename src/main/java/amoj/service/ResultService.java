package amoj.service;

import amoj.dao.ResultDao;
import amoj.dao.SubmitDao;
import amoj.entity.Result;
import amoj.entity.Submit;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class ResultService {
    private static Logger log = Logger.getLogger("ResultService");
    @Autowired
    ResultDao resultDao;
    @Autowired
    SubmitDao submitDao;

    //入参: 当前页, 每页的记录数
    public PageInfo<Result> allResults(int page, int size){
        PageHelper.startPage(page, size);
        List list = resultDao.allResults();
        PageInfo<Result> pageInfo = new PageInfo<>(list);
        return pageInfo;  //获取分页对象
    }

    public int addResult(Result result){
        log.info("add result " + result);
        int res = resultDao.addResult(result);
        Submit submit = submitDao.findSubmitById(result.getSubmitId());
        submit.setResultId((long) res);
        int res0 = submitDao.updateSubmitById(submit);
        log.info("result_id put submit " + res + " " +result.getSubmitId());
        return res;
    }

    public Result findResultById(Long id){
        Result result = resultDao.findResultById(id);
        return result;
    }

    public int updateResultById(Result result){
        int res = resultDao.updateResultById(result);
        return res;
    }

    public int deleteResultById(Long id){
        int res = resultDao.deleteResultById(id);
        return res;
    }

}
