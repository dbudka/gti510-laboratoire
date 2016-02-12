package api.service.REST;

import api.dto.VideoDTO;
import core.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("api/videos")
public class VideoRESTController {

    @Autowired
    private VideoService videoService;

    @RequestMapping(value="/create/McDavid", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity createVideo() {

        VideoDTO videoDTO = new VideoDTO();
        videoDTO.setName("Connor Mcdavid Goal");
        videoDTO.setUrl("https://youtu.be/SHrMWKKii8M");

        videoService.createVideo(videoDTO);

        return new ResponseEntity("OK", new HttpHeaders(), HttpStatus.OK);
    }

}
