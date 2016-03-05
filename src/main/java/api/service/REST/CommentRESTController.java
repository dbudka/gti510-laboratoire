package api.service.REST;

import api.dto.CommentDTO;
import api.dto.UserDTO;
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

    @Autowired
    private UserDTO userDTO;

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

            if(userDTO != null && userDTO.getId().equals(comment.getUserId())) {
                commentService.createComment(comment);
            }
            else if(userDTO != null) {
                logger.error(String.format("user try to insert comment for other people userId trying [%s] " +
                        "comment userId [%s]", userDTO.getId(), comment.getUserId()));

                return new ResponseEntity<String>("Erreur", new HttpHeaders(), HttpStatus.UNAUTHORIZED);
            }
            else {
                logger.error(String.format("user unlogged to post comment for other people" +
                        "comment userId [%s]", comment.getUserId()));

                return new ResponseEntity<String>("Erreur", new HttpHeaders(), HttpStatus.UNAUTHORIZED);
            }
        }catch (Exception e){
            logger.error("Error while creation comment" + e);
            return new ResponseEntity<String>("Erreur", new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
        }


        return new ResponseEntity<String>("OK", new HttpHeaders(), HttpStatus.CREATED);
    }

    @RequestMapping(value="/{id}", method = RequestMethod.DELETE, produces = "application/json", consumes = "application/json")
    public ResponseEntity deleteComment(@PathVariable("id")int commentID) {

        try{
            CommentDTO commentDTO = commentService.findById(commentID);
            if(commentDTO != null){
                if(userDTO != null && userDTO.getId().equals(commentDTO.getUserId())) {
                    commentService.deleteComment(commentID);
                }
                else if(userDTO != null) {
                    logger.error(String.format("user try to delete other people comment  userId trying [%s] " +
                                                "comment userId [%s]", userDTO.getId(), commentDTO.getUserId()));

                    return new ResponseEntity<String>("Erreur", new HttpHeaders(), HttpStatus.UNAUTHORIZED);
                }
                else {
                    logger.error(String.format("user unlogged to delete other people comment" +
                            "comment userId [%s]", commentDTO.getUserId()));

                    return new ResponseEntity<String>("Erreur", new HttpHeaders(), HttpStatus.UNAUTHORIZED);
                }
            }
            else {
                logger.error(String.format("comment not found for id [%s]", commentID));
                return new ResponseEntity<String>("Erreur", new HttpHeaders(), HttpStatus.NOT_FOUND);
            }
        }catch (Exception e){
            logger.error("Error while deleting comment" + e);
            return new ResponseEntity<String>("Erreur", new HttpHeaders(), HttpStatus.NOT_FOUND);
        }


        return new ResponseEntity<String>("OK", new HttpHeaders(), HttpStatus.OK);
    }


}
