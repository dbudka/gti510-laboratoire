package api.service.REST;

import api.dto.UserDTO;
import core.service.FavoritesService;
import core.service.HistoryService;
import core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.servlet.http.HttpServletRequest;

@Controller
@EnableWebMvc
@RequestMapping("api/users")
public class UserRESTController {

    @Autowired
    UserDTO userDTO;

    @Autowired
    private UserService userService;

    @Autowired
    private HistoryService historyService;

    @Autowired
    private FavoritesService favoritesService;

    @RequestMapping(value="/reinitialisation", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<String> createVideo() {

        //userService.sendEmailForConfirmation(1);

        return new ResponseEntity<String>("OK", new HttpHeaders(), HttpStatus.OK);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<String> createOrUpdateUser (UserDTO userDTO) {


        UserDTO userDTOCreated = userService.createOrUpdateUser(userDTO);

        if(userDTOCreated != null) {

            setUserSession(userDTOCreated);

            return new ResponseEntity<String>("OK", new HttpHeaders(), HttpStatus.OK);
        }

        System.out.println("IM OUT -");

        return new ResponseEntity<String>("BAD", new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }


    @RequestMapping(value = "/connect", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<String> connectUser (UserDTO userDTO) {

        System.out.println("ok");
        UserDTO user = userService.connectAndGetUser(userDTO.getEmail(), userDTO.getPassword());

        if(user != null) {
            System.out.println("ok");

            setUserSession(user);

            return new ResponseEntity<String>("OK", new HttpHeaders(), HttpStatus.OK);
        }
        System.out.println("bad");

        return new ResponseEntity<String>("BAD", new HttpHeaders(), HttpStatus.UNAUTHORIZED);
    }


    @RequestMapping(value =  "/password/request", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<String> passwordResetRequest (HttpServletRequest request, UserDTO userDTO) {

        String host = request.getRequestURL().toString().replace(request.getRequestURI(), request.getContextPath());
        Boolean change = userService.resetPassword(userDTO.getEmail(), host);

        if(change) {

            return new ResponseEntity<String>("OK", new HttpHeaders(), HttpStatus.OK);
        }
        System.out.println("bad");

        return new ResponseEntity<String>("BAD", new HttpHeaders(), HttpStatus.UNAUTHORIZED);
    }

    @RequestMapping(value =  "/password/confirm", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<String> passwordConfirm (UserDTO userDTO) {

        UserDTO userDTOCreated = userService.updateUserPassword(userDTO);

        if(userDTOCreated != null) {

            return new ResponseEntity<String>("OK", new HttpHeaders(), HttpStatus.OK);
        }

        System.out.println("IM OUT -");

        return new ResponseEntity<String>("BAD", new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);

    }

    private void setUserSession(UserDTO user) {
        this.userDTO.setUsername(user.getUsername());
        this.userDTO.setPassword(user.getPassword());
        this.userDTO.setEmail(user.getPassword());
        this.userDTO.setPassword(user.getEmail());
        this.userDTO.setPasswordChanging(user.getPasswordChanging());
        this.userDTO.setId(user.getId());
        this.userDTO.setVideoHistory(this.historyService.findByUserID(user.getId()));
        this.userDTO.setVideoFavorites(this.favoritesService.findByUserID(user.getId()));
    }


}
