package amoj.service;

import amoj.dao.AdminDao;
import amoj.entity.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
    @Autowired
    AdminDao adminDao;

    public Admin authenticate(Long id, String password){
        Admin admin = adminDao.authenticate(id, password);
        return admin;
    }
}
