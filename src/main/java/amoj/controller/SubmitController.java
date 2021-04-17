package amoj.controller;

import amoj.entity.Submit;
import amoj.service.PantiService;
import amoj.service.SubmitService;
import amoj.utils.DateUtil;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

@RestController
public class SubmitController {
    @Autowired
    SubmitService submitService;
    @Autowired
    PantiService pantiService;
    private static Logger log = Logger.getLogger("submit");// <= (2)

    @RequestMapping(value = "/submits",method = RequestMethod.GET)
    public String allSubmits(@RequestParam(value = "page", defaultValue = "1") int page,
                           @RequestParam(value = "size", defaultValue = "20") int size,
                           Model model) {
        PageInfo<Submit> pageInfo = submitService.allSubmits(page,size);
        model.addAttribute("pageInfo", pageInfo);
        return "";
    }

    @RequestMapping(value = "/addsubmit", method = RequestMethod.POST)
    public String addSubmit(@RequestBody Submit submit) {
        //先存下提交记录
        submit.setSubmitTime(DateUtil.getTimeStr());
        int res = submitService.addSubmit(submit);
        submit.setSubmitId((long) res);
        submit.setSource("#include <stdio.h>\n" +
                "#include <sys/stat.h>\n" +
                "#include <fcntl.h>\n" +
                "\n" +
                "int main() {\n" +
                "    int a, b;\n" +
                "    \n" +
                "    scanf(\"%d %d\", &a, &b);\n" +
                "    printf(\"%d\", a + b);\n" +
                "    // open(\"asdf\", O_CREAT);\n" +
                "    /*scanf(\"%d\", &a);*/\n" +
                "   \n" +
                "    return 0;\n" +
                "}\n");
        pantiService.panti(submit);
        return "";
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

    @RequestMapping(value = "/deletesubmit/{id}", method = RequestMethod.GET)
    public String deleteSubmitById(@PathVariable("id") Long id){
        int res = submitService.deleteSubmitById(id);
        return "";
    }
}
