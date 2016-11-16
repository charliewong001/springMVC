package web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

/**
 * 
 * @author Charlie
 * @SessionAttributes
 */
@Controller
@SessionAttributes(value = { "book", "description" }, types = { Double.class })
public class SessionAttributesController {

    @RequestMapping("/sessionAttributes")
    public String index(Model model) {
        model.addAttribute("book", "金刚经");
        model.addAttribute("description", "般若系列经典");
        model.addAttribute("price", new Double("5.6"));
        return "redirect:get";
    }

    @RequestMapping("/get")
    public String getBySessionAttributes(@ModelAttribute("book") String book,
            ModelMap model, SessionStatus sessionStatus) {
        System.out.println("===getBySessionAttributes===");
        System.out.println("get by modelAttributes : book = " + book);
        System.out.println("get by model : " + model.get("book") + ","
                + model.get("description") + "," + model.get("price"));
        sessionStatus.setComplete();
        return "redirect:complete";
    }

    @RequestMapping("/complete")
    @ResponseBody
    public String afterComplete(ModelMap model) {
        System.out.println("===afterCompelete===");
        System.out.println("get by model : " + model.get("book") + ","
                + model.get("description") + "," + model.get("price"));
        return "done!";
    }
}
