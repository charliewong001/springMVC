package web;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 
 * @author Charlie
 * @ModelAttribute用在方法上则用来设置参数
 */
@Controller
public class ModelAttributeController {

    @RequestMapping(value = "/modelAttribute")
    public String handle(@ModelAttribute("age") String age, Model model) {
        Map<String, Object> m = model.asMap();
        System.out.println("age : " + age);
        System.out.println("className : " + m.get("className"));
        System.out.println("name : " + m.get("name"));
        System.out.println("string : " + m.get("string"));
        return "index.jsp";
    }

    @ModelAttribute
    public void testModelAttribute() {
        System.out.println("model attribute method executing...");
    }

    @ModelAttribute
    public void testModelAttribute2(@RequestParam("name") String name,
            Model model) {
        model.addAttribute("name", name);
    }

    @ModelAttribute("className")
    public String testModelAttribute3() {
        return this.getClass().getName();
    }

    @ModelAttribute()
    public String testModelAttribute4() {
        return "default paramName is string";
    }

}
