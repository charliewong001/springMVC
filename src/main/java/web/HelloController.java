package web;

import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/hello")
public class HelloController implements EnvironmentAware {

    @RequestMapping("/world")
    public @ResponseBody String hello() {
        System.out.println("====hello");
        return "hello";
    }

    private Environment environment = null;

    @Override
    public void setEnvironment(Environment arg0) {
        this.environment = arg0;
    }

}
