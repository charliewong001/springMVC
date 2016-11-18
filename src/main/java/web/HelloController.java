package web;

import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/hello")
public class HelloController implements EnvironmentAware {

    public HelloController() {
        System.out.println("helloController creating...");
    }

    @RequestMapping("/world")
    public @ResponseBody String hello() {
        System.out.println("====hello");
        return "hello";
    }

    @RequestMapping("aa")
    @ResponseBody
    public String aa() {
        return "hello";
    }

    private Environment environment = null;

    @Override
    public void setEnvironment(Environment arg0) {
        this.environment = arg0;
    }

}
