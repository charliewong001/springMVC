package web;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 
 * @author Charlie @ModelAttribute用在方法上则用来设置参数,它会在执行处理前将参数设置到Model中。
 *         规则为:如果@ModelAttribute设置了value则将其作为参数名,返回值作为参数值设置到Model中;如果方法含有Model,
 *         Map或者ModelMap,类型的参数,则可以直接将需要设置的参数设置上去,如果既没有设置value也没有Model类型的参数,
 *         则根据返回值类型解析出参数名,返回值作为参数值设置到Model中.
 * @ModelAttribute若用在参数上,则表示需要使用指定的ArgumentResolver来解析参数
 * 
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
        System.out.println("teacher : " + m.get("teacher"));
        return "index.jsp";
    }

    /**
     * 执行处理前给Model设置("teacher","孔老夫子")
     * 
     * @param model
     */
    @ModelAttribute
    public void testModelAttribute(Model model) {
        model.addAttribute("teacher", "孔老夫子");
    }

    @ModelAttribute
    public void testModelAttribute2(@RequestParam("name") String name,
            Model model) {
        model.addAttribute("name", name);
    }

    /**
     * 执行处理前给Model设置("className","web.ModelAttributeController")
     * 
     * @return
     */
    @ModelAttribute("className")
    public String testModelAttribute3() {
        return this.getClass().getName();
    }

    /**
     * 执行处理前给Model设置("string","default paramName is string")
     * 
     * @return
     */
    @ModelAttribute
    public String testModelAttribute4() {
        return "default paramName is string";
    }

}
