package amoj.service;

import amoj.dao.*;
import amoj.entity.*;
import amoj.utils.PropertiesUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Service
public class SubmitService {

    @Autowired
    SubmitDao submitDao;
    @Autowired
    ResultDao resultDao;
    @Autowired
    UserDao userDao;
    @Autowired
    ProblemDao problemDao;
    @Autowired
    ProblemUserService problemUserDao;

    private static Logger log = Logger.getLogger("submitservice");
    //入参: 当前页,
    public PageInfo<Submit> allSubmits0(int page, int size){
        PageHelper.startPage(page, size);
        List list = submitDao.allSubmits();
        PageInfo<Submit> pageInfo = new PageInfo<>(list);
        return pageInfo;  //获取分页对象
    }

    public PageInfo<SubmitView> allSubmits(int page, int size){
        PageHelper.startPage(page, size);
        List<SubmitView> list = new ArrayList<SubmitView>();
        List<Submit> listsubmit = submitDao.allSubmits();
        for(Submit s: listsubmit){
            SubmitView v = new SubmitView();
            v.setUserId(s.getUserId());
            User user = userDao.findUserById(s.getUserId());
            v.setUsername(user.getUsername());
            v.setSubmitId(s.getSubmitId());
            v.setProblemId(s.getProblemId());
            Problem problem = problemDao.findProblemById(s.getProblemId());
            v.setProblemTitle(problem.getTitle());
            v.setLanguage(s.getLanguage());
            v.setLanguageName(PropertiesUtil.LANGUAGE[s.getLanguage()]);
            Result r = resultDao.findResultById(s.getResultId());
            if(r!=null){
                v.setResult(r.getResult());
                v.setUsedMem(r.getUsedMem());
                v.setUsedTime(r.getUsedTime());
            }
            list.add(v);
        }
        PageInfo<SubmitView> pageInfo = new PageInfo<>(list);
        return pageInfo;  //获取分页对象
    }
    public PageInfo<SubmitView> finSubmitsByUserId(int page, int size, String userId){
        PageHelper.startPage(page, size);
        List<SubmitView> list = new ArrayList<SubmitView>();
        List<Submit> listsubmit = submitDao.finSubmitsByUserId(userId);
        for(Submit s: listsubmit){
            SubmitView v = new SubmitView();
            v.setUserId(s.getUserId());
            User user = userDao.findUserById(s.getUserId());
            v.setUsername(user.getUsername());
            v.setSubmitId(s.getSubmitId());
            v.setProblemId(s.getProblemId());
            v.setLanguage(s.getLanguage());
            Problem problem = problemDao.findProblemById(s.getProblemId());
            v.setProblemTitle(problem.getTitle());
            v.setLanguageName(PropertiesUtil.LANGUAGE[s.getLanguage()]);
            Result r = resultDao.findResultById(s.getResultId());
            if(r!=null){
                v.setResult(r.getResult());
                v.setUsedMem(r.getUsedMem());
                v.setUsedTime(r.getUsedTime());
            }
            list.add(v);
        }
        PageInfo<SubmitView> pageInfo = new PageInfo<>(list);
        return pageInfo;  //获取分页对象
    }

    public int addSubmit(Submit submit){
        int res = submitDao.addSubmit(submit);

        Problem problem = problemDao.findProblemById(submit.getProblemId());
        problem.setSubmit(problem.getSubmit()+1);
        problemDao.updateProblemById(problem);
        User user = userDao.findUserById(submit.getUserId());
        user.setSubmit(user.getSubmit()+1);
        userDao.updateUserById(user);

        ProblemUser problemUser = problemUserDao.findProblemUser(submit.getProblemId(),submit.getUserId());
        if(problemUser==null){
            ProblemUser problemUser0 = new ProblemUser();
            problemUser0.setProblemId(submit.getProblemId());
            problemUser0.setUserId(submit.getUserId());
            problemUser0.setSolve(0);
            problemUserDao.addProblemUser(problemUser0);
        }

        return res;
    }

    public Submit findSubmitById(Long id){
        Submit submit = submitDao.findSubmitById(id);
        return submit;
    }

    public int updateSubmitById(Submit submit){
        int res = submitDao.updateSubmitById(submit);
        return res;
    }

    public int deleteSubmitById(Long id){
        int res = submitDao.deleteSubmitById(id);
        return res;
    }

}
