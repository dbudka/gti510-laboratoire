package api.service.REST;

import api.dto.UserDTO;
import api.dto.VideoDTO;
import core.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("api/user")
public class UserRESTController {

    @Autowired
    private UserService userService;

    private static final Logger logger = Logger.getLogger(CommentRESTController.class);

    @RequestMapping(value="/create/test", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity createUser() {

        UserDTO userDTO = new UserDTO();
        //password test
        userDTO.setPassword("9f86d081884c7d659a2feaa0c55ad015a3bf4f1b2b0b822cd15d6c15b0f00a08");
        userDTO.setEmail("test@test.com");
        userDTO.setUsername("test");

        userService.createUser(userDTO);

        return new ResponseEntity("OK", new HttpHeaders(), HttpStatus.CREATED);
    }
}
