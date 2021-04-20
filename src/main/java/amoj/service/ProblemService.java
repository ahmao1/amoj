package amoj.service;

import amoj.dao.ProblemDao;
import amoj.dao.SubmitDao;
import amoj.entity.ExecMsg;
import amoj.entity.Problem;
import amoj.entity.User;
import amoj.utils.ExecUtil;
import amoj.utils.PropertiesUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.logging.Logger;

@Service
public class ProblemService {

    @Autowired
    ProblemDao problemDao;
    @Autowired
    SubmitDao submitDao;

    private static Logger log = Logger.getLogger("ProblemService");

    //入参: 当前页, 每页的记录数
    public PageInfo<Problem> allProblems(int page, int size){
        PageHelper.startPage(page, size);
        List<Problem> list = problemDao.allProblems();
        PageInfo<Problem> pageInfo = new PageInfo<>(list);
        return  pageInfo;  //获取分页对象
    }

    public PageInfo<Problem> findProblemsByTitle(int page, int size, String word){
        PageHelper.startPage(page, size);
        List<Problem> list = problemDao.findProblemsByTitle(word);
        PageInfo<Problem> pageInfo = new PageInfo<>(list);
        return  pageInfo;  //获取分页对象
    }
    public Long findLastId(){
        return problemDao.findLastId();
    }

    public int addSubmitNum(Long problemId){
        Problem problem = findProblemById(problemId);
        Long oldsubmit = problem.getSubmit();
        problem.setSubmit(oldsubmit+1);
        return updateProblemById(problem);
    }

    public int addSolveNum(Long problemId){
        Problem problem = findProblemById(problemId);
        Long oldsolve = problem.getSolve();
        problem.setSolve(oldsolve+1);
        return updateProblemById(problem);
    }

    public void unzipDataFile(String fileName)
    {
        Runtime runtime = Runtime.getRuntime();
        String cmd = PropertiesUtil.StringValue("7z")+ " x "+
                PropertiesUtil.StringValue("local_judge_data")+"/"+fileName
                +" -o"+PropertiesUtil.StringValue("local_judge_data");
        log.info(cmd);
        try {
            runtime.exec(PropertiesUtil.StringValue("7z")+ " x "+
                    PropertiesUtil.StringValue("local_judge_data")+"/"+fileName
                    +" -o"+PropertiesUtil.StringValue("local_judge_data"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addProblemData(String fileName, Long problemId){
        /* unzip */
        unzipDataFile(fileName);
        // send judge module
        String path = PropertiesUtil.StringValue("local_judge_data") + "/" + problemId;
        String address = PropertiesUtil.StringValue("linux_address") +
                ":" + PropertiesUtil.StringValue("linux_data");
        Runtime runtime = Runtime.getRuntime();/*
        try {
            runtime.exec("cmd /c scp -r " + path + " "+ address);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }*/
        log.info("trans data" );
    }

    public int addProblem(Problem problem){
        int res = problemDao.addProblem(problem);
        return res;
    }

    public Problem findProblemById(Long id){
        Problem problem = problemDao.findProblemById(id);
        return problem;
    }

    public int updateProblemById(Problem problem){
        int res = problemDao.updateProblemById(problem);
        return res;
    }

    public int deleteProblemById(Long id){
        int res = problemDao.deleteProblemById(id);
        return res;
    }
}
