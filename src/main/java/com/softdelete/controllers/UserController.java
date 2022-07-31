package com.softdelete.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.softdelete.models.entities.User;
import com.softdelete.services.UserService;

@RestController
@RequestMapping(path = "/",method = RequestMethod.POST)
public class UserController {
   
   @Autowired
   private UserService userService;

   @GetMapping
   public Iterable<User> findAll(){
      return userService.findAll();
   }

   @PostMapping(path = "/insert")
   public User insertUser(@RequestBody User user){
      return userService.save(user);
   }

   @DeleteMapping(path = "/delete/{id}")
   public String delete(@PathVariable("id") long id){
      return userService.delete(id);
   }

}
