package api.service.Controller;

import api.dto.UserDTO;
import core.service.UserService;
import core.service.VideoService;
import org.hsqldb.rights.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/user")
public class UserController {


    @Autowired
    private UserService userService;

    @Autowired
    UserDTO userDTO;

    @RequestMapping(value = "/create", method=RequestMethod.GET)
    public String viewCreate(Model model) {

        model.addAttribute("user", userDTO);

        return "user-edit";
    }

    @RequestMapping(value = "/edit", method=RequestMethod.GET)
    public String viewUpdate(Model model) {
        model.addAttribute("user", userDTO);

        return "user-edit";
    }

    @RequestMapping(value = "/forgot/password", method=RequestMethod.GET)
    public String viewForgotPPassword(Model model) {
        model.addAttribute("user", userDTO);

        return "forgotten-password";
    }

    @RequestMapping(value = "/reset/password", method=RequestMethod.GET)
    public String viewForgotPPassword(Model model, @RequestParam("id") String userId) {
        model.addAttribute("user", userDTO);
        model.addAttribute("id", userId);

        UserDTO userDTO = userService.findById(Integer.parseInt(userId));

        if(userDTO != null && userDTO.getPasswordChanging())
            return "change-password";

        return "redirect:connect";
    }

    @RequestMapping(value = "/logout", method=RequestMethod.GET)
    public String viewLogout(Model model) {

        userDTO.setId(null);
        userDTO.setPassword(null);
        userDTO.setEmail(null);
        userDTO.setUsername(null);
        userDTO.setFavoritevideos(null);
        userDTO.setVideoHistory(null);

        model.addAttribute("user", userDTO);

        return "redirect:connect";
    }


    @RequestMapping(value = "/connect", method=RequestMethod.GET)
    public String viewConnect(Model model) {
        model.addAttribute("user", userDTO);

        return "connection";
    }

}
