package api.service.REST;

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

@Controller
@RequestMapping("api/users")
public class UserRESTController {

    @Autowired
    private UserService userService;

    @RequestMapping(value="/reinitialisation", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity createVideo() {

        userService.sendEmail(1);

        return new ResponseEntity("OK", new HttpHeaders(), HttpStatus.OK);
    }

}
