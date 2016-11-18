package web;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

/**
 * 配置了@ControllerAdvice的类中的@ModelAttribute和@InitBinder方法会按照规则统一执行
 * 
 * @author Charlie
 *
 */
@ControllerAdvice
public class ControllerAdviceController {
    @ModelAttribute
    public void setModelAttribute() {
        System.out.println("common model attribute set...");
    }
}
