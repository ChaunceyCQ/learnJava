package geektime.spring.hello.hellospring.controller;

import geektime.spring.hello.hellospring.model.User;
import geektime.spring.hello.hellospring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    //jdbc
    @RequestMapping(value = "saveUser", method = RequestMethod.GET)
    public void saveUser() {
        userService.saveUser();
    }

    //RequestParam的用法，http://localhost:8080/getUserByIdJdbc?getId=4
    @RequestMapping(value = "getUserByIdJdbc", method = RequestMethod.GET)
    public User getUserByIdJdbc(@RequestParam(value = "getId") int id) {
        return userService.findByIdRepository(id);
    }

    //mybatis xml
    @RequestMapping(value = "getUser", method = RequestMethod.GET)
    public List<User> getUsers() {
        return userService.getAll();
    }

    @RequestMapping(value = "mapperSaveUser", method = RequestMethod.GET)
    public int mapperSaveUser() {
        return userService.mapperSaveUser();
    }

    @RequestMapping(value = "updateUser", method = RequestMethod.GET)
    public void updateUser() {
        userService.updateUser();
    }

    //mybatis 注解
    @RequestMapping(value = "getUser2", method = RequestMethod.GET)
    public List<User> getUser2() {
        return userService.getAll2();
    }

    //PathVariable的用法，http://localhost:8080/deleteUser2/3
    @RequestMapping(value = "deleteUser2/{deleteId}", method = RequestMethod.GET)
    public void deleteUser2(@PathVariable("deleteId") int id) {
        userService.delete(id);
    }

    @RequestMapping(value = "saveUser2", method = RequestMethod.GET)
    public int saveUser2() {
        return userService.mapperSaveUser2();
    }

    @RequestMapping(value = "updateUser2", method = RequestMethod.GET)
    public void updateUser2() {
        userService.updateUser2();
    }

    @RequestMapping(value = "getCount", method = RequestMethod.GET)
    public int getCount() {
        return userService.getCount();
    }


}
