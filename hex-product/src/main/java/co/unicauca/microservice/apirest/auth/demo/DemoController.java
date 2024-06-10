package co.unicauca.microservice.apirest.auth.demo;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Configuration
@EnableMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class DemoController {

    @Secured("USER")
    @PostMapping(value = "demo")
    public String welcome ()
    {
        return "Return from secure endpoint";
    }

}
