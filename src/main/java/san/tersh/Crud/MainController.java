package san.tersh.Crud;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/")
    public String test(Map<String, Object> model) {

        model.put("message", "HEJ");

        return "test";
    }

    @GetMapping("/users/")
    public String users(Map<String, Object> model) {

        model.put("message", "HEJ");

        return "users";
    }

    @GetMapping("users/add/")
    public String addUser(Map<String, Object> model) {
        return "addUser";
    }

    @PostMapping("users/add/")
    public String addUserAction(@ModelAttribute("email") String email, @ModelAttribute("name") String name, Map<String, Object> model) {
        System.out.println("User to be added: " + email);
        if (email != null) {
            User user = new User();
            user.setEmail(email);
            user.setName(name);

            userRepository.save(user);

            model.put("message", "User added");
        }
        return "addUser";
    }
}
