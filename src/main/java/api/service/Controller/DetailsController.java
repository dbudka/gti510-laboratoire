package api.service.Controller;


import api.dto.HistoryDTO;
import api.dto.UserDTO;
import api.dto.VideoDTO;
import core.service.CommentService;
import core.service.HistoryService;
import core.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;

@Controller
@RequestMapping("/")
public class DetailsController extends AbstractController{

    @Autowired
    private VideoService videoService;

    @Autowired
    UserDTO userDTO;

    @Autowired
    private HistoryService historyService;

    @RequestMapping(value = "/", method=RequestMethod.GET)
    public String viewDetails(Model model) {

        model.addAttribute("user", userDTO);
        model.addAttribute("videos",videoService.getAllVideos());

        return "index";
    }
    @RequestMapping(value = "/{videoId}", method=RequestMethod.GET)
    public String viewDetails(Model model, @PathVariable("videoId")int videoId) {

        VideoDTO videoDTO = videoService.findById(videoId);
        model.addAttribute("user", userDTO);
        model.addAttribute("video",videoDTO);

        if(userDTO!= null && userDTO.getId()!= null && videoDTO != null){
            HistoryDTO historyDTO = new HistoryDTO();


            historyDTO.setUser(userDTO);
            historyDTO.setVideo(videoDTO);
            historyDTO.setDateViewed(new Date());
            historyService.createHistory(historyDTO);
            userDTO.getVideoHistory().add(historyDTO);
        }
        return "video";
    }
}
