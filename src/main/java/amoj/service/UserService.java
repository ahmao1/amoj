package amoj.service;

import amoj.dao.SubmitDao;
import amoj.dao.UserDao;
import amoj.entity.Submit;
import amoj.entity.User;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserDao userDao;
    @Autowired
    SubmitDao submitDao;


    public PageInfo<User> allUsers(int page, int size){
        PageHelper.startPage(page, size);
        List<User> list = userDao.allUsers();
        PageInfo<User> pageInfo = new PageInfo<>(list);
        return pageInfo;  //获取分页对象
    }

    public int addUser(User user){
        int res = userDao.addUser(user);
        return res;
    }

    public User findUserById(Long id){
        User user = userDao.findUserById(id);
        return user;
    }

    public User authenticate(Long id, String password){
        User user = userDao.authenticate(id, password);
        return user;
    }

    public int updateUserById(User user){
        int res = userDao.updateUserById(user);
        return res;
    }

    public int deleteUserById(Long id){
        int res = userDao.deleteUserById(id);
        return res;
    }

    public int addSubmitNum(Long userId){
        User user = findUserById(userId);
        Long oldsubmit = user.getSubmitNumber();
        user.setSubmitNumber(oldsubmit+1);
        return updateUserById(user);
    }

    public int addSolveNum(Long userId){
        User user = findUserById(userId);
        Long oldsolve = user.getSolveNumber();
        user.setSolveNumber(oldsolve+1);
        return updateUserById(user);
    }
}
