package com.travel.travel.Resource;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.travel.travel.Domain.User; 
import com.travel.travel.Service.UserService;

import java.util.List;

@RestController
@RequestMapping("api/users")
public class UserResource {
    @Autowired
    private UserService userService;

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllServices(@RequestParam(required = false) String serviceName) {
        List<User> services= new java.util.ArrayList<User>();

        if(serviceName==null){
            userService.getAllUsers().forEach(services::add);
        }
        else{
            userService.getServiceByServiceName(serviceName).forEach(services::add);
        }
        if(services.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(services, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable(value = "id") Long id) {
        User service=userService.getUserById(id);
        if(service==null){
            throw new ResourceNotFoundException("User not found");
        }
        else{
            return new ResponseEntity<>(service, HttpStatus.OK);
        }
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User user) {
        return userService.updateUser(id, user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }

    /**
     * @return UserService return the userService
     */
    public UserService getUserService() {
        return userService;
    }

    /**
     * @param userService the userService to set
     */
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
    

}
