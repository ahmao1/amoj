package amoj.controller;

import amoj.entity.Admin;
import amoj.entity.Problem;
import amoj.entity.User;
import amoj.service.AdminService;
import amoj.service.ProblemUserService;
import amoj.service.UserService;
import amoj.utils.PropertiesUtil;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    AdminService adminService;
    @Autowired
    ProblemUserService problemUserService;

    private static int size = PropertiesUtil.PAGE_SIZE;
/*
    @RequestMapping(value ="/login", method = RequestMethod.POST)
    public String login(@RequestParam("user_id") String id,
                        @RequestParam("password") String password,
                        HttpServletRequest request){

    }
*/
    @RequestMapping(value = "/amoj", method = RequestMethod.GET)
    public ModelAndView login(){
        ModelAndView modelAndView = new ModelAndView("/login"); //设置对应JSP的模板文件
        return modelAndView;
    }
    //修改密码
    @RequestMapping(value = "/updatepasswd", method = RequestMethod.GET)
    public ModelAndView updatepasswd(HttpSession httpSession){
        ModelAndView modelAndView = new ModelAndView("/updatepasswd"); //设置对应JSP的模板文件
        modelAndView.addObject("user", userService.findUserById((Long) httpSession.getAttribute("currentUserId")));
        return modelAndView;
    }
    @RequestMapping(value = "/updateuserpassword", method = RequestMethod.POST)
    public ModelAndView updateUserById(@RequestParam(value = "password") String password, HttpSession httpSession){
        User user = userService.findUserById((Long) httpSession.getAttribute("currentUserId"));
        user.setPassword(password);
        userService.updateUserById(user);
        ModelAndView modelAndView = new ModelAndView("/personal");
        modelAndView.addObject("user",userService.findUserById((Long) httpSession.getAttribute("currentUserId")));
        return modelAndView;
    }
    //修改用户名
    @RequestMapping(value = "/updateusername", method = RequestMethod.GET)
    public ModelAndView updateusername(HttpSession httpSession){
        ModelAndView modelAndView = new ModelAndView("/updateusername"); //设置对应JSP的模板文件
        modelAndView.addObject("user", userService.findUserById((Long) httpSession.getAttribute("currentUserId")));
        return modelAndView;
    }
    @RequestMapping(value = "/updateuserusername", method = RequestMethod.POST)
    public ModelAndView updateUserNameById(@RequestParam(value = "username") String username, HttpSession httpSession){
        User user = userService.findUserById((Long) httpSession.getAttribute("currentUserId"));
        user.setUsername(username);
        userService.updateUserById(user);
        ModelAndView modelAndView = new ModelAndView("/personal");
        modelAndView.addObject("user",userService.findUserById((Long) httpSession.getAttribute("currentUserId")));
        return modelAndView;
    }
    @RequestMapping(value = "/amoj-index", method = RequestMethod.POST)
    public ModelAndView logincheck(@RequestParam(value = "userId") String userId,
                                   @RequestParam(value = "password") String password,
                                   HttpSession httpSession){
        ModelAndView modelAndView = new ModelAndView();
        Long id = Long.valueOf(userId);
        User user = userService.authenticate(id,password);
        if( user!=null ){
            modelAndView.setViewName("/index"); //设置对应JSP的模板文件
            modelAndView.addObject("userId",id);
            httpSession.setAttribute("currentUserId",id);
        }
        else {
            return errorModel("错误的学号和密码");
        }
        return modelAndView;
    }
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ModelAndView register(@RequestParam(value = "userId") String userId,
                                 @RequestParam(value = "username") String username,
                                 @RequestParam(value = "password") String password,
                                 HttpSession httpSession){
        ModelAndView modelAndView = new ModelAndView();
        Long id=Long.valueOf(userId);
        User user = userService.authenticate(id,password);
        if(user!=null) {
            return errorModel("学号已存在");
        }else{
            User u = new User();
            u.setUserId(id);
            u.setSubmit(0L);
            u.setSubmitNumber(0L);
            u.setSolveNumber(0L);
            u.setPassword(password);
            u.setUsername(username);
            userService.addUser(u);
            modelAndView.setViewName("/login");
        }
        return modelAndView;
    }


    @RequestMapping(value = "/admin-index",method = RequestMethod.POST)
    public ModelAndView adminlogincheck(@RequestParam(value = "adminId") Long adminId,
                                        @RequestParam(value = "password") String password) {
        ModelAndView modelAndView = new ModelAndView();
        Admin admin = adminService.authenticate(adminId,password);
        if( admin!=null){
            modelAndView.setViewName("/admin_index");
        } else{
            return errorModel("错误的管理员账号和密码");
        }
        return modelAndView;
    }
    @RequestMapping(value = "/adminamoj",method = RequestMethod.GET)
    public ModelAndView admin_login() {
        ModelAndView modelAndView = new ModelAndView("/admin_login");
        return modelAndView;
    }

    @RequestMapping(value = "/adminusers",method = RequestMethod.GET)
    public ModelAndView allUsers(@RequestParam(value = "page", defaultValue = "1") int page) {
        ModelAndView modelAndView = new ModelAndView("/admin_userList");
        PageInfo<User> pageInfo = userService.allUsers(page,size);
        modelAndView.addObject("pageInfo", pageInfo);
        return modelAndView;
    }

    @RequestMapping(value = "/searchuserbyuserid", method = RequestMethod.GET)
    public ModelAndView searchuserid(@RequestParam(value = "userId") Long userId) {
        return findUserById(userId);
    }

    @RequestMapping(value = "/adduser", method = RequestMethod.POST)
    public User addUser(@RequestBody User user) {
        System.out.println("asdfasdf "+user);
        int res = userService.addUser(user);
        return user;
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public ModelAndView findUserById(@PathVariable("id") Long id){
        ModelAndView modelAndView = new ModelAndView();
        User user = userService.findUserById(id);
        modelAndView.setViewName("/personal");
        modelAndView.addObject("user",user);
        List<Long> solve = problemUserService.findSolveProblemIdByUserId(id);
        modelAndView.addObject("solve",solve);
        List<Long> unsolve = problemUserService.findUnSolveProblemIdByUserId(id);
        modelAndView.addObject("unsolve",unsolve);
        return modelAndView;
    }

    @RequestMapping(value = "/updateuser", method = RequestMethod.POST)
    public ModelAndView updateUserById(User user){
        userService.updateUserById(user);
        return allUsers(1);
    }

    @RequestMapping(value = "/deleteuser", method = RequestMethod.GET)
    public ModelAndView deleteUserById(@RequestParam(value = "id")  Long id){
        userService.deleteUserById(id);
        return allUsers(1);
    }
    @RequestMapping(value = "/remakepasswd", method = RequestMethod.GET)
    public ModelAndView remakepasswd(@RequestParam(value = "id")  Long id){
        User user = userService.findUserById(id);
        user.setPassword("123456");
        userService.updateUserById(user);
        return allUsers(1);
    }
    public ModelAndView errorModel(String msg){
        ModelAndView modelAndView = new ModelAndView("/amoj_error");
        modelAndView.addObject("msg",msg);
        return modelAndView;
    }
}
