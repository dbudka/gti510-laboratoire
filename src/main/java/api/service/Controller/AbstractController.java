package api.service.Controller;

import api.dto.UserDTO;
import core.service.CommentService;
import core.service.VideoService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public abstract class AbstractController {

    @Autowired
    UserDTO userDTO;

    public String checkConnection(String page) {

        if(userDTO == null || StringUtils.isEmpty(userDTO.getEmail()))
            return "redirect:/user/connect";

        return page;
    }

}
