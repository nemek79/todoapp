package es.vir2al.todoapp.app.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.vir2al.todoapp.fwk.domain.responses.BaseResponse;
import es.vir2al.todoapp.fwk.domain.security.UserVO;

@CrossOrigin(origins = { "http://localhost:4200", "*" })
@RestController
@RequestMapping("/api/test")
public class TestController {

    private static final Logger LOGGER = LoggerFactory.getLogger(TestController.class);

    @GetMapping("/hello")
	public ResponseEntity<BaseResponse> hello() {

        LOGGER.debug("INICIO test.hello()");

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        LOGGER.debug("Usuario: "+((UserVO)auth.getPrincipal()).getUsername());

        BaseResponse baseResponse = new BaseResponse();

        LOGGER.debug("FINAL test.hello()");

        return new ResponseEntity<>(baseResponse,HttpStatus.OK);

    }

}
