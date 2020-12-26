package geektime.spring.hello.hellospring.controller;

import geektime.spring.hello.hellospring.model.User;
import geektime.spring.hello.hellospring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class WebController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "get", method = RequestMethod.GET)
    public String getUser() {
        User user = new User();
        user.setName("Jack");
        return user.getName();
    }

    //获取所有user账户
    @RequestMapping(value = "getUser", method = RequestMethod.GET)
    public List<User> getUsers() {
        return userService.getAll();
    }

    @RequestMapping(value = "saveUser", method = RequestMethod.GET)
    public void saveUser() {
        userService.saveUser();
    }

    @RequestMapping(value = "mapperSaveUser", method = RequestMethod.GET)
    public int mapperSaveUser() {
        return userService.mapperSaveUser();
    }


}
