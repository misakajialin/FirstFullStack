package tech.misakait.firstfullstack.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.misakait.firstfullstack.dto.UserDTO;
import tech.misakait.firstfullstack.impl.UserServiceImpl;
import java.util.HashMap;
import java.util.Map;

@RestController
public class LoginController {
    @Autowired
    private ObjectMapper mapper;

    @Autowired
    @Qualifier("usi")
    UserServiceImpl usi;

    @RequestMapping("/login")
    public String login(@RequestBody String userJson) throws JsonMappingException, JsonProcessingException {
        UserDTO usr = mapper.readValue(userJson, UserDTO.class);
        boolean success = usi.login(usr);
        Map<String, Boolean> response = new HashMap<>();
        response.put("success", success);
        return mapper.writeValueAsString(response);
    }
}
