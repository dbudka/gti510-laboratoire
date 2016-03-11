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

        VideoDTO videoDTO1 = new VideoDTO();
        videoDTO1.setName("Video 1");
        videoDTO1.setPic("http://s3-eu-west-1.amazonaws.com/realsport-wp-offload/wp-content/uploads/2016/02/02134015/abbi611.jpg");
        videoDTO1.setUrl("SHrMWKKii8M");
        videoService.createVideo(videoDTO1);

        VideoDTO videoDTO2 = new VideoDTO();
        videoDTO2.setName("Video 2");
        videoDTO2.setPic("http://s3-eu-west-1.amazonaws.com/realsport-wp-offload/wp-content/uploads/2016/02/02134015/abbi611.jpg");
        videoDTO2.setUrl("SHrMWKKii8M");
        videoService.createVideo(videoDTO2);

        VideoDTO videoDTO3 = new VideoDTO();
        videoDTO3.setName("Video 3");
        videoDTO3.setPic("http://s3-eu-west-1.amazonaws.com/realsport-wp-offload/wp-content/uploads/2016/02/02134015/abbi611.jpg");
        videoDTO3.setUrl("SHrMWKKii8M");
        videoService.createVideo(videoDTO3);

        VideoDTO videoDTO4 = new VideoDTO();
        videoDTO4.setName("Video 4");
        videoDTO4.setPic("http://s3-eu-west-1.amazonaws.com/realsport-wp-offload/wp-content/uploads/2016/02/02134015/abbi611.jpg");
        videoDTO4.setUrl("SHrMWKKii8M");
        videoService.createVideo(videoDTO4);

        return new ResponseEntity("OK", new HttpHeaders(), HttpStatus.OK);
    }
}
