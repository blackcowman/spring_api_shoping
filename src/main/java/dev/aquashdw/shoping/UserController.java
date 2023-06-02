package dev.aquashdw.shoping;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("post")
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    private final UserService postService;

    public UserController(
        @Autowired UserService postService
    ){
        this.postService = postService;
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void createUser(@RequestBody UserDto dto){
        this.postService.createUser(dto);
    }

    @GetMapping("{id}")
    public UserDto readUser(@PathVariable("id") int id){
        return this.postService.readUser(id);
    }

    @GetMapping()
    public List<UserDto> readUserAll(){
        return this.postService.readUserAll();
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updateUser(
            @PathVariable("id") int id,
            @RequestBody UserDto dto
    ){
        this.postService.updateUser(id, dto);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteUser(@PathVariable("id") int id){
        this.postService.deleteUser(id);
    }
}
