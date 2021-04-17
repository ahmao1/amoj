package amoj.controller;

import amoj.entity.User;
import amoj.service.UserService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
public class UserController {
    @Autowired
    UserService userService;
/*
    @RequestMapping(value ="/login", method = RequestMethod.POST)
    public String login(@RequestParam("user_id") String id,
                        @RequestParam("password") String password,
                        HttpServletRequest request){

    }
*/
    @RequestMapping(value = "/users",method = RequestMethod.GET)
    public PageInfo allUsers(@RequestParam(value = "page", defaultValue = "1") int page,
                              @RequestParam(value = "size", defaultValue = "20") int size,
                              Model model) {
        PageInfo<User> pageInfo = userService.allUsers(page,size);
        model.addAttribute("pageInfo", pageInfo);
        return pageInfo;
    }

    @RequestMapping(value = "/adduser", method = RequestMethod.POST)
    public User addUser(@RequestBody User user) {
        System.out.println("asdfasdf "+user);
        int res = userService.addUser(user);
        return user;
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public User findUserById(@PathVariable("id") Long id,
                               Model model){
        User user = userService.findUserById(id);
        return user;
    }

    @RequestMapping(value = "/updateuser", method = RequestMethod.POST)
    public User updateUserById(@RequestBody User user){
        int res = userService.updateUserById(user);
        return user;
    }

    @RequestMapping(value = "/deleteuser/{id}", method = RequestMethod.GET)
    public int deleteUserById(@PathVariable("id") Long id){
        int res = userService.deleteUserById(id);
        return res;
    }

}
