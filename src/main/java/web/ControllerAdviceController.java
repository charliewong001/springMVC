package web;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice
public class ControllerAdviceController {
    @ModelAttribute
    public void setModelAttribute() {
        System.out.println("common model attribute set...");
    }
}
