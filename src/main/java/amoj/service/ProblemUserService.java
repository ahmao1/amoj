package amoj.service;

import amoj.dao.ProblemUserDao;
import amoj.entity.ProblemUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProblemUserService {
    @Autowired
    ProblemUserDao problemUserDao;

    public List<Long> findSubmitProblemIdByUserId(Long userId){
        return problemUserDao.findSubmitProblemIdByUserId(userId);
    }
    public List<Long> findSolveProblemIdByUserId(Long userId){
        return problemUserDao.findSolveProblemIdByUserId(userId);
    }
    public List<Long> findUnSolveProblemIdByUserId(Long userId){
        return problemUserDao.findUnSolveProblemIdByUserId(userId);
    }
    public int addProblemUser(ProblemUser problemUser){
        return problemUserDao.addProblemUser(problemUser);
    }
    public ProblemUser findProblemUser(Long problemId, Long userId){
        return problemUserDao.findProblemUser(problemId,userId);
    }
    public int updateProblemUser(Long problemId, Long userId){
        return problemUserDao.updateProblemUser(problemId,userId);
    }
    public int deleteByUserId(Long userId){
        return problemUserDao.deleteByUserId(userId);
    }
    public int deleteByProblemId(Long problemId){
        return problemUserDao.deleteByProblemId(problemId);
    }
}
