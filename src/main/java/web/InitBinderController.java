package web;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * initBinder 初始化Binder 此处初始化的Binder的作用是将传入的日期类型的参数格式化
 * 
 * @author Charlie
 *
 */
@Controller
public class InitBinderController {

    @RequestMapping("/initBinder")
    @ResponseBody
    public String test(@RequestParam("date") Date date) {
        System.out.println("date is :" + date);
        return "initBinder test done!";
    }

    /**
     * CustomDateBinder:日期类型的编辑器,这个编辑器会将类似"2016-11-01"的字符串转为日期类型的日期
     * 
     * @param binder
     */
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        System.out.println("initBindering...");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class,
                new CustomDateEditor(dateFormat, true));
    }
}
