package api.service.Controller;

import core.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/details")
public class DetailsController {

    @Autowired
    private VideoService videoService;

    @RequestMapping(value = "/", method=RequestMethod.GET)
    public String viewDetails(Model model) {

        model.addAttribute("video", videoService.findById(1));

        return "index";
    }

}
