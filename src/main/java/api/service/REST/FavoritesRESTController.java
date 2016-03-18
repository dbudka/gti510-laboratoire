package api.service.REST;

import api.dto.UserDTO;
import api.dto.VideoDTO;
import core.service.FavoritesService;
import core.service.VideoService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import api.dto.FavoritesDTO;

@Controller
@RequestMapping("api/favorites")
public class FavoritesRESTController {

    @Autowired
    private FavoritesService favoritesService;

    @Autowired
    private VideoService videoService;

    private static final Logger logger = Logger.getLogger(FavoritesRESTController.class);

    @Autowired
    private UserDTO userDTO;

    @RequestMapping(value = "/{userId}", method = RequestMethod.GET, produces = "application/json", consumes = "application/json")
    public @ResponseBody
    List<FavoritesDTO> getCommentVideoPaginated(@PathVariable("userId")int userId) {
        List<FavoritesDTO> favorites = null;
        try{
            favorites = favoritesService.findByUserID(userId);
        }catch (Exception e){
            logger.error(String.format("Error while retrieving favorites for videoId [%s], page [%s], limit [%s] ",
                    userId) + e);
        }
        return favorites;
    }

    @RequestMapping(method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
    public ResponseEntity addToFavorites(@RequestParam Integer vId) {
        FavoritesDTO favoritesDTO = new FavoritesDTO();
        try{
                if (vId > -1) {
                    VideoDTO videoDTO = videoService.findById(vId);
                    favoritesDTO.setVideo(videoDTO);
                    favoritesDTO.setUser(userDTO);

                    boolean foundVid = false;
                    int indexVid = -1;
                    for (int i = 0; i < userDTO.getVideoFavorites().size() && !foundVid; i++) {
                        if(userDTO.getVideoFavorites().get(i).sameVideoId(vId)){
                            indexVid = i;
                            foundVid = true;
                        }
                    }
                    if(!foundVid) {
                        userDTO.getVideoFavorites().add(favoritesDTO);
                        favoritesService.createFavorites(favoritesDTO);

                    } else {
                        logger.error(String.format("user tried to add a video already in his favorites videos", favoritesDTO.getUser().getId()));

                        return new ResponseEntity<String>("Erreur", new HttpHeaders(), HttpStatus.CONFLICT);
                    }

                } else if (userDTO != null) {
                    logger.error(String.format("user try to add video to favorites for other people userId trying [%s] ",
                            userDTO.getId(), favoritesDTO.getUser().getId()));

                    return new ResponseEntity<String>("Erreur", new HttpHeaders(), HttpStatus.UNAUTHORIZED);
                } else {
                    logger.error(String.format("user unlogged to add video to favorites for other people", favoritesDTO.getUser().getId()));

                    return new ResponseEntity<String>("Erreur", new HttpHeaders(), HttpStatus.UNAUTHORIZED);
                }

        }catch (Exception e) {
            logger.error("Error while adding video to favorites " + e);
            return new ResponseEntity<String>("Erreur", new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<String>("OK", new HttpHeaders(), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{videoId}", method = RequestMethod.DELETE, produces = "application/json", consumes = "application/json")
    public ResponseEntity deleteFromFavorites(@PathVariable("videoId")int vId) {
        FavoritesDTO favoritesDTO = new FavoritesDTO();
        try{
            VideoDTO videoDTO = videoService.findById(vId);
            if(videoDTO != null) {
                favoritesDTO.setVideo(videoDTO);
                favoritesDTO.setUser(userDTO);
                int indexVid = -1;
                boolean foundVid = false;

                for (int i = 0; i < userDTO.getVideoFavorites().size() && !foundVid; i++) {
                    if(userDTO.getVideoFavorites().get(i).sameVideoId(vId)){
                        indexVid = i;
                        foundVid = true;
                    }
                }
                if(indexVid > -1){
                    userDTO.getVideoFavorites().remove(indexVid);
                }
                favoritesService.deleteFromFavorites(vId);
            }
            else if(userDTO != null) {
                logger.error(String.format("user try to delete other people favorites userId trying [%s] " +
                        "comment userId [%s]", userDTO.getId(), favoritesDTO.getUser().getId()));

                return new ResponseEntity<String>("Erreur", new HttpHeaders(), HttpStatus.UNAUTHORIZED);

            } else {
                logger.error(String.format("favorites not found for id [%s]", vId));
                return new ResponseEntity<String>("Erreur", new HttpHeaders(), HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            logger.error("Error while deleting video from favorites" + e);
            return new ResponseEntity<String>("Erreur", new HttpHeaders(), HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<String>("OK", new HttpHeaders(), HttpStatus.OK);
    }
}