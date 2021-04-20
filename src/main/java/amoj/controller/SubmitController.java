package amoj.controller;

import amoj.entity.Problem;
import amoj.entity.Submit;
import amoj.entity.SubmitView;
import amoj.service.PantiService;
import amoj.service.ProblemService;
import amoj.service.SubmitService;
import amoj.service.UserService;
import amoj.utils.DateUtil;
import amoj.utils.PropertiesUtil;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.io.Console;
import java.util.logging.Logger;

@RestController
public class SubmitController {
    @Autowired
    SubmitService submitService;
    @Autowired
    PantiService pantiService;
    @Autowired
    ProblemService problemService;
    @Autowired
    UserService userService;
    private static Logger log = Logger.getLogger("submit");
    private static int size = PropertiesUtil.PAGE_SIZE;

    @RequestMapping(value = "/submits",method = RequestMethod.GET)
    public ModelAndView allSubmits(@RequestParam(value = "page", defaultValue = "1") int page) {
        ModelAndView modelAndView = new ModelAndView();
        PageInfo<SubmitView> pageInfo = submitService.allSubmits(page,size);
        modelAndView.setViewName("/submitList");
        modelAndView.addObject("pageInfo", pageInfo);
        log.info(size+ " "+pageInfo);
        return modelAndView;
    }
    @RequestMapping(value = "/adminsubmits",method = RequestMethod.GET)
    public ModelAndView alladminSubmits(@RequestParam(value = "page", defaultValue = "1") int page) {
        ModelAndView modelAndView = new ModelAndView();
        PageInfo<SubmitView> pageInfo = submitService.allSubmits(page,size);
        modelAndView.setViewName("/admin_submitList");
        modelAndView.addObject("pageInfo", pageInfo);
        return modelAndView;
    }

    @RequestMapping(value = "/searchuserid", method = RequestMethod.GET)
    public ModelAndView searchtitle(@RequestParam(value = "userId") String userId,
                                    @RequestParam(value = "page", defaultValue = "1") int page
    ) {
        ModelAndView modelAndView = new ModelAndView();
        PageInfo<SubmitView> pageInfo = submitService.finSubmitsByUserId(page,size,userId);
        modelAndView.setViewName("/submitList");
        modelAndView.addObject("pageInfo", pageInfo);
        log.info(size+ " "+pageInfo);
        return modelAndView;
    }

    @RequestMapping(value = "/addsubmit", method = RequestMethod.POST)
    public ModelAndView addSubmit(@RequestParam(value = "problemId") Long problemId,
                            @RequestParam(value = "language") int language,
                            @RequestParam(value = "source") String source,
                            HttpSession httpSession) {
        Long userId = (Long) httpSession.getAttribute("currentUserId");
        Submit submit = new Submit();
        submit.setUserId(userId);
        submit.setSubmitTime(DateUtil.getTimeStr());
        submit.setLanguage(language);
        submit.setSource(source);
        Problem problem = problemService.findProblemById(problemId);
        submit.setProblemId(problemId);
        submit.setTime(problem.getTime());
        submit.setMem(problem.getMem());
        submitService.addSubmit(submit);
        pantiService.panti(submit);
        ModelAndView modelAndView = new ModelAndView("/submitList");
        PageInfo<SubmitView> pageInfo = submitService.allSubmits(1,size);
        modelAndView.addObject("pageInfo", pageInfo);
        return modelAndView;
    }

    @RequestMapping(value = "/submit/{id}", method = RequestMethod.GET)
    public String findUserById(@PathVariable("id") Long id,
                               Model model){
        Submit submit = submitService.findSubmitById(id);
        return "";
    }

    @RequestMapping(value = "/updatesubmit", method = RequestMethod.POST)
    public String updateSubmitById(@RequestBody Submit submit){
        int res = submitService.updateSubmitById(submit);
        return "";
    }

    @RequestMapping(value = "/deletesubmit", method = RequestMethod.GET)
    public ModelAndView deleteSubmitById(@RequestParam(value = "submidId") Long submitId){
        submitService.deleteSubmitById(submitId);
        return alladminSubmits(1);
    }
}
