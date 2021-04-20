package amoj.controller;

import amoj.dao.ProblemDao;
import amoj.dao.UserDao;
import amoj.entity.Problem;
import amoj.entity.User;
import amoj.service.ProblemService;
import amoj.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class FrameController {
    @Autowired
    ProblemService problemService;
    @Autowired
    UserService userService;
    @RequestMapping(value = "/left",method = RequestMethod.GET)
    public ModelAndView left() {
        ModelAndView modelAndView = new ModelAndView("/left");
        return modelAndView;
    }
    @RequestMapping(value = "/admin_left",method = RequestMethod.GET)
    public ModelAndView adminLeft() {
        ModelAndView modelAndView = new ModelAndView("/admin_left");
        return modelAndView;
    }
    @RequestMapping(value = "/firstleft",method = RequestMethod.GET)
    public ModelAndView firstleft() {
        ModelAndView modelAndView = new ModelAndView("/firstleft");
        return modelAndView;
    }
    @RequestMapping(value = "/mainview",method = RequestMethod.GET)
    public ModelAndView mainview() {
        ModelAndView modelAndView = new ModelAndView("/mainview");
        return modelAndView;
    }
    @RequestMapping(value = "/top",method = RequestMethod.GET)
    public ModelAndView top() {
        ModelAndView modelAndView = new ModelAndView("/top");
        return modelAndView;
    }
    @RequestMapping(value = "/admin_top",method = RequestMethod.GET)
    public ModelAndView admin_top() {
        ModelAndView modelAndView = new ModelAndView("/admin_top");
        return modelAndView;
    }
    @RequestMapping(value = "/regist",method = RequestMethod.GET)
    public ModelAndView regist() {
        ModelAndView modelAndView = new ModelAndView("/reg");
        return modelAndView;
    }
    @RequestMapping(value = "/updateproblem",method = RequestMethod.GET)
    public ModelAndView updateproblem(@RequestParam(value = "pid") Long problemId) {
        ModelAndView modelAndView = new ModelAndView("/admin_updateproblem");
        Problem problem = problemService.findProblemById(problemId);
        modelAndView.addObject("problem",problem);
        return modelAndView;
    }
    @RequestMapping(value = "/updateuser",method = RequestMethod.GET)
    public ModelAndView updateuser(@RequestParam(value = "uid") Long userId) {
        ModelAndView modelAndView = new ModelAndView("/admin_updateuser");
        User user = userService.findUserById(userId);
        modelAndView.addObject("user",user);
        return modelAndView;
    }
    @RequestMapping(value = "/addproblemframe",method = RequestMethod.GET)
    public ModelAndView addproblemframe() {
        ModelAndView modelAndView = new ModelAndView("/admin_addproblem");
        Long last_id = problemService.findLastId();
        modelAndView.addObject("lastId", last_id+1);
        return modelAndView;
    }
    @RequestMapping(value = "/adddatafileframe",method = RequestMethod.GET)
    public ModelAndView adddatafileframe(@RequestParam(value = "id") Long problemId) {
        ModelAndView modelAndView = new ModelAndView("/admin_adddatafile");
        modelAndView.addObject("problemId", problemId);
        return modelAndView;
    }
}
