package amoj.service;

import amoj.dao.SubmitDao;
import amoj.entity.Submit;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubmitService {

    @Autowired
    SubmitDao submitDao;

    //入参: 当前页, 每页的记录数
    public PageInfo<Submit> allSubmits(int page, int size){
        PageHelper.startPage(page, size);
        List list = submitDao.allSubmits();
        PageInfo<Submit> pageInfo = new PageInfo<>(list);
        return pageInfo;  //获取分页对象
    }

    public int addSubmit(Submit submit){
        int res = submitDao.addSubmit(submit);
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
