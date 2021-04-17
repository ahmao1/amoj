package amoj.service;

import amoj.dao.ProblemDao;
import amoj.entity.ExecMsg;
import amoj.entity.Problem;
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
    private static Logger log = Logger.getLogger("ProblemService");

    //入参: 当前页, 每页的记录数
    public PageInfo<Problem> allProblems(int page, int size){
        PageHelper.startPage(page, size);
        List list = problemDao.allProblems();
        PageInfo<Problem> pageInfo = new PageInfo<>(list);
        return  pageInfo;  //获取分页对象
    }

    public void addProblemData(Long problemId){
        /*@TODO 假设文件已经在E:/amoj_data/{problemId}    --path
            需要传到am@192.168.154.128:/home/amoj_data    --address
         */
        String path = PropertiesUtil.StringValue("local_judge_data") + "/" + problemId;
        String address = PropertiesUtil.StringValue("linux_address") +
                ":" +
                PropertiesUtil.StringValue("linux_data");
        //String[] cmd = {"cmd /c scp -r " + path + " "+ address};
        //String cmd = "cmd /c notepad";
        Runtime runtime = Runtime.getRuntime();
        Process exec = null;
        try {
            exec = runtime.exec("cmd /c scp -r " + path + " "+ address);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
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
