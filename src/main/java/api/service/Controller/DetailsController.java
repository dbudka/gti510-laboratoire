package api.service.Controller;

import api.dto.UserDTO;
import core.service.CommentService;
import core.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class DetailsController {

    @Autowired
    private VideoService videoService;

    @Autowired
    UserDTO userDTO;

    @Autowired
    private CommentService commentService;

    @RequestMapping(value = "/", method=RequestMethod.GET)
    public String viewDetails(Model model) {

        model.addAttribute("user", userDTO);
        model.addAttribute("videos",videoService.getAllVideos());

        return "index";
    }
    @RequestMapping(value = "/{videoId}", method=RequestMethod.GET)
    public String viewDetails(Model model, @PathVariable("videoId")int videoId) {

        model.addAttribute("user", userDTO);
        model.addAttribute("video",videoService.findById(videoId));

        return "video";
    }
}
