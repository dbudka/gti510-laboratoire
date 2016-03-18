package api.service.Controller;

import api.dto.UserDTO;
import core.service.CommentService;
import core.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class SearchController extends AbstractController {

    @Autowired
    private VideoService videoService;

    @Autowired
    UserDTO userDTO;

    @RequestMapping(value = "/search", method= RequestMethod.GET)
    public String viewVideosQueried(Model model, @RequestParam String searchVideos) {

        model.addAttribute("user", userDTO);
        model.addAttribute("videos",videoService.getVideosByQuery(searchVideos));

        return  "index";
    }

}
