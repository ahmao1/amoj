package amoj.controller;

import amoj.entity.Problem;
import amoj.service.ProblemService;
import amoj.utils.PropertiesUtil;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

@RestController
public class ProblemController {

    @Autowired
    ProblemService problemService;
    private static Logger log = Logger.getLogger("ProblemController");
    private static int size = PropertiesUtil.PAGE_SIZE;

    @RequestMapping(value = "/problems",method = RequestMethod.GET)
    public ModelAndView allProblems(@RequestParam(value = "page", defaultValue = "1") int page
                                    ) {
        ModelAndView modelAndView = new ModelAndView();
        PageInfo<Problem> pageInfo = problemService.allProblems(page,size);
        modelAndView.addObject("pageInfo", pageInfo);
        modelAndView.setViewName("/problemList");
        return modelAndView;
    }

    @RequestMapping(value = "/adminproblems",method = RequestMethod.GET)
    public ModelAndView adminAllProblems(@RequestParam(value = "page", defaultValue = "1") int page
    ) {
        ModelAndView modelAndView = new ModelAndView();
        PageInfo<Problem> pageInfo = problemService.allProblems(page,size);
        modelAndView.addObject("pageInfo", pageInfo);
        modelAndView.setViewName("/admin_problemList");
        return modelAndView;
    }

    @RequestMapping(value = "/searchtitle", method = RequestMethod.GET)
    public ModelAndView searchtitle(@RequestParam(value = "titleword") String word,
                                    @RequestParam(value = "page", defaultValue = "1") int page
    ) {
        log.info("word "+word);
        ModelAndView modelAndView = new ModelAndView();
        PageInfo<Problem> pageInfo = problemService.findProblemsByTitle(page,size,word);
        modelAndView.addObject("pageInfo", pageInfo);
        modelAndView.setViewName("/problemList");
        return modelAndView;
    }


    @RequestMapping(value = "/addproblem", method = RequestMethod.POST)
    public ModelAndView addProblem(Problem problem) {
        ModelAndView modelAndView = new ModelAndView("/admin_adddatafile");
        problemService.addProblem(problem);
        modelAndView.addObject("problemId", problem.getProblemId());
        return modelAndView;
    }

    @RequestMapping(value = "/addproblemsdata", method = RequestMethod.POST)
    public ModelAndView addProblemData(@RequestParam("file") MultipartFile dataFile,
                                  @RequestParam(value = "problemId") Long id) {
        String path = PropertiesUtil.StringValue("local_judge_data") + "/" + dataFile.getOriginalFilename();
        File file = new File(path);
        if (dataFile.getSize()==0){
            return errorModel("不存在的文件");
        }
        try {
            dataFile.transferTo(file);
        } catch (IOException e) {
            return errorModel("文件传输错误");
        }
        problemService.addProblemData(dataFile.getOriginalFilename(), id);
        return adminAllProblems(1);
    }

    public ModelAndView errorModel(String msg){
        ModelAndView modelAndView = new ModelAndView("/amoj_error");
        modelAndView.addObject("msg",msg);
        return modelAndView;
    }

    @RequestMapping(value = "/problem/{id}", method = RequestMethod.GET)
    public ModelAndView findProblemById(@PathVariable("id") Long id){
        ModelAndView modelAndView = new ModelAndView("/problem");
        modelAndView.addObject("problem",problemService.findProblemById(id));
        return modelAndView;
    }

    @RequestMapping(value = "/updateproblems", method = RequestMethod.POST)
    public ModelAndView updateProblemById( Problem problem){
        int res = problemService.updateProblemById(problem);
        return findProblemById(problem.getProblemId());
    }

    @RequestMapping(value = "/deleteproblems", method = RequestMethod.GET)
    public ModelAndView deleteProblemById(@RequestParam(value = "id") Long problemId){
        problemService.deleteProblemById(problemId);
        return adminAllProblems(1);
    }
}
