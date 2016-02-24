package api.service.Controller;

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
public class DetailsController {

    @Autowired
    private VideoService videoService;

    @Autowired
    private CommentService commentService;

    @RequestMapping(value = "/", method=RequestMethod.GET)
    public String viewDetails(Model model,
                              @RequestParam(defaultValue = "1") int page,
                              @RequestParam(defaultValue = "5") int limit) {

        model.addAttribute("video", videoService.findById(1));
        model.addAttribute("comments", commentService.findbyVideoIdPaginated( 1, page, limit));
        return "index";
    }

}
