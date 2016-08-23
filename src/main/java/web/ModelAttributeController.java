package web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ModelAttributeController {

    @RequestMapping(value = "/modelAttribute")
    public String handle(@ModelAttribute("age") String age) {
        System.out.println("age : " + age);
        return "index.jsp";
    }

    @ModelAttribute
    public void testModelAttribute() {
        System.out.println("model attribute method executing...");
    }

    @ModelAttribute
    public void testModelAttribute2(@RequestParam("name") String name,
            Model model) {
        System.out.println("name : " + name);
        model.addAttribute("name", name);
    }
}
