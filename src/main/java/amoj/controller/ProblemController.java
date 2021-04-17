package amoj.controller;

import amoj.entity.Problem;
import amoj.service.ProblemService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class ProblemController {

    @Autowired
    ProblemService problemService;

    @RequestMapping(value = "/problems",method = RequestMethod.GET)
    public PageInfo allProblems(@RequestParam(value = "page", defaultValue = "1") int page,
                             @RequestParam(value = "size", defaultValue = "20") int size,
                             Model model) {
        PageInfo<Problem> pageInfo = problemService.allProblems(page,size);
        model.addAttribute("pageInfo", pageInfo);
        return pageInfo;
    }

    @RequestMapping(value = "/addproblems", method = RequestMethod.POST)
    public Problem addProblem(@RequestBody Problem problem) {
        int res = problemService.addProblem(problem);
        return problem;
    }

    /*@TODO 上传数据文件
        存在本地，传到服务器上，删除本地数据
     */
    @RequestMapping(value = "/addproblemsdata/{id}", method = RequestMethod.POST)
    public void addProblemData(//@RequestParam MultipartFile dataFile,
                                  @PathVariable("id") Long id) {
        problemService.addProblemData(id);
    }

    @RequestMapping(value = "/problems/{id}", method = RequestMethod.GET)
    public Problem findProblemById(@PathVariable("id") Long id,
                                  Model model){
        Problem problem = problemService.findProblemById(id);
        return problem;
    }

    @RequestMapping(value = "/updateproblems", method = RequestMethod.POST)
    public Problem updateProblemById(@RequestBody Problem problem){
        int res = problemService.updateProblemById(problem);
        return problem;
    }

    @RequestMapping(value = "/deleteproblems/{id}", method = RequestMethod.GET)
    public String deleteProblemById(@PathVariable("id") Long id){
        int res = problemService.deleteProblemById(id);
        return "1";
    }
}
