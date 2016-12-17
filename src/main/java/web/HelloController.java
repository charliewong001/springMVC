package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

    @RequestMapping(value = "/user/{username}/age/{age}", method = RequestMethod.GET)
    @ResponseBody
    public String userInfo(@PathVariable("username") String username,
            @PathVariable("age") String age) {
        System.out
                .println("***********username = " + username + ";age = " + age);
        return "success";
    }

    @RequestMapping(value = "toPage")
    public String toPage(ModelMap map) {
        map.put("name", "charlie");
        map.put("age", 18);
        Map<String, Object> mm = new HashMap<String, Object>();
        mm.put("name", "查理");
        mm.put("age", "20");
        map.put("mm", mm);
        return "/test";
    }

    @RequestMapping("aa")
    public String aa(HttpServletResponse response) throws IOException {
        PrintWriter pw = response.getWriter();
        pw.write("write");
        pw.flush();
        pw.close();
        System.out.println("======executing");
        return null;
    }

    private Environment environment = null;

    @Override
    public void setEnvironment(Environment arg0) {
        this.environment = arg0;
    }

}
