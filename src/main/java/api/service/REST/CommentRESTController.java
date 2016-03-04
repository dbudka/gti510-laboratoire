package api.service.REST;

import api.dto.CommentDTO;
import core.service.CommentService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("api/comment")
public class CommentRESTController {

    @Autowired
    private CommentService commentService;

    private static final Logger logger = Logger.getLogger(CommentRESTController.class);

    @RequestMapping(value = "/{videoId}", method = RequestMethod.GET, produces = "application/json", consumes = "application/json")
    public @ResponseBody List<CommentDTO> getCommentVideoPaginated(@PathVariable("videoId")int videoId,
                                                                   @RequestParam(defaultValue = "1") int page,
                                                                    @RequestParam(defaultValue = "5") int limit) {
        List<CommentDTO> comments = null;
        try{
            comments = commentService.findbyVideoIdPaginated(videoId, page, limit);
        }catch (Exception e){
            logger.error(String.format("Error while retriving comments for videoId [%s], page [%s], limit [%s] ",
                    videoId, page, limit) + e);
        }


        return comments;
    }

    @RequestMapping(method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
    public ResponseEntity createComment(@RequestBody CommentDTO comment) {

        try{
            commentService.createComment(comment);
        }catch (Exception e){
            logger.error("Error while creation comment" + e);
            return new ResponseEntity("Erreur", new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
        }


        return new ResponseEntity("OK", new HttpHeaders(), HttpStatus.CREATED);
    }

    @RequestMapping(value="/{id}", method = RequestMethod.DELETE, produces = "application/json", consumes = "application/json")
    public ResponseEntity deleteComment(@PathVariable("id")int commentID) {

        try{
            commentService.deleteComment(commentID);
        }catch (Exception e){
            logger.error("Error while deleting comment" + e);
            return new ResponseEntity("Erreur", new HttpHeaders(), HttpStatus.NOT_FOUND);
        }


        return new ResponseEntity("OK", new HttpHeaders(), HttpStatus.OK);
    }


}
