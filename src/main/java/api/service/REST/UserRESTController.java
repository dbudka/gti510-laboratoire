package api.service.REST;

import api.dto.UserDTO;
import api.dto.VideoDTO;
import core.service.UserService;
import core.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping("api/users")
public class UserRESTController {

    @Autowired
    UserDTO userDTO;

    @Autowired
    private UserService userService;

    @RequestMapping(value="/reinitialisation", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity createVideo() {

        //userService.sendEmailForConfirmation(1);

        return new ResponseEntity("OK", new HttpHeaders(), HttpStatus.OK);
    }

    @ResponseBody
    @RequestMapping(value = "/", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResponseEntity createOrUpdateUser (UserDTO userDTO) {

        UserDTO userDTOCreated = userService.createOrUpdateUser(userDTO);

        if(userDTOCreated != null) {

            userDTO.setPassword(userDTOCreated.getPassword());
            userDTO.setEmail(userDTOCreated.getPassword());
            userDTO.setPassword(userDTOCreated.getEmail());
            userDTO.setPasswordChanging(userDTOCreated.getPasswordChanging());
            userDTO.setId(userDTOCreated.getId());
            return new ResponseEntity("OK", new HttpHeaders(), HttpStatus.OK);
        }

        return new ResponseEntity("BAD", new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
