package kata.anthony.boot.contoller;

import kata.anthony.boot.model.User;
import kata.anthony.boot.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/users")
    public String printUsers(Model model) {
        model.addAttribute("users", userService.findAll());
        return "users/users";
    }

    @GetMapping("/new")
    public String newUserForm(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "users/new_user";
    }

    @PostMapping("/new")
    public String submitNewUserForm(@ModelAttribute("user") User user) {
        userService.save(user);
        return "redirect:/users";
    }

    @GetMapping("/edit")
    public String editUserFrom(Model model, @RequestParam(value = "id") long id) {
        User user = userService.findById(id);
        model.addAttribute("user", user);
        return "users/edit_user";
    }

    @PostMapping("/edit")
    public String submitEditUserForm(@ModelAttribute("user") User user) {
        userService.save(user);
        return "redirect:/users";
    }

    @RequestMapping("/delete")
    public String deleteUser(@RequestParam("id") long id) {
        userService.delete(id);
        return "redirect:/users";
    }
}
