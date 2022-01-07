package xyz.chaobei.demo.application.facade;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import xyz.chaobei.demo.interfaces.service.UserService;

import javax.annotation.Resource;

@Controller
@RequestMapping("/api/user")
public class UserController {

    @Resource(name = "userService")
    private UserService userService;

    @GetMapping("/id/{id}")
    @ResponseBody
    public ResponseEntity getById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(userService.queryUserCardById(id));
    }

}
