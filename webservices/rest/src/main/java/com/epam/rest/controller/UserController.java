package com.epam.rest.controller;

import com.epam.rest.dao.UserDao;
import com.epam.rest.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserDao userDao;

    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    public User getUser(@PathVariable int userId) {
        return userDao.get(userId);
    }

    @RequestMapping(value = "/{userName}", method = RequestMethod.POST)
    public int addUser(@PathVariable String userName) {
        return userDao.add(new User(userName));
    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.DELETE)
    public User deleteUser(@PathVariable int userId) {
        return userDao.delete(userId);
    }

    @RequestMapping(value = "/{userId}/{userName}", method = RequestMethod.PUT)
    public User updateUser(@PathVariable int userId, @PathVariable String userName) {
        User user = new User(userName);
        user.setId(userId);
        return userDao.update(user);
    }

}
