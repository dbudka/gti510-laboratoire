package api.service.Controller;

import api.dto.UserDTO;
import core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/user")
public class UserController extends  AbstractController{


    @Autowired
    private UserService userService;

    @Autowired
    UserDTO userDTO;

    @RequestMapping(value = "/favorites", method=RequestMethod.GET)
    public String viewFavorites(Model model){
        model.addAttribute("user", userDTO);
        model.addAttribute("videofavorites", userDTO.getVideoFavorites());
        return "favorites";
    }

    @RequestMapping(value = "/history", method=RequestMethod.GET)
    public String viewHistory(Model model){
        model.addAttribute("user", userDTO);
        model.addAttribute("videohistory", userDTO.getVideoHistory());

        return "history";
    }

    @RequestMapping(value = "/create", method=RequestMethod.GET)
    public String viewCreate(Model model) {

        model.addAttribute("user", userDTO);

        return "user-edit";
    }

    @RequestMapping(value = "/edit", method=RequestMethod.GET)
    public String viewUpdate(Model model) {
        model.addAttribute("user", userDTO);


        return checkConnection("user-edit");
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

        UserDTO userDTO = userService.findById(Integer.parseInt(userId.trim()));

        if(userDTO != null && userDTO.getPasswordChanging())
            return "change-password";

        return "redirect:/connect";
    }

    @RequestMapping(value = "/logout", method=RequestMethod.GET)
    public String viewLogout(Model model) {

        userDTO.setId(null);
        userDTO.setPassword(null);
        userDTO.setEmail(null);
        userDTO.setUsername(null);
        userDTO.setVideoFavorites(null);
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
