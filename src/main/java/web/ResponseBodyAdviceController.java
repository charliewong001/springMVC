package web;

import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * 实现了ResponseBodyAdvice接口可以处理修改作为ResponseBody类型的处理器的返回值
 * 会将返回值作为ResponseBody的两种类型的处理器为:返回职位HttpEntity,返回值前注释了@ResponseBody
 * 主要用于修改json类型的返回值,可以在里边统一处理
 * 
 * @author Charlie
 *
 */
@ControllerAdvice
public class ResponseBodyAdviceController
        implements ResponseBodyAdvice<String> {

    @Override
    public boolean supports(MethodParameter returnType,
            Class<? extends HttpMessageConverter<?>> converterType) {
        return true;
    }

    @Override
    public String beforeBodyWrite(String body, MethodParameter returnType,
            MediaType selectedContentType,
            Class<? extends HttpMessageConverter<?>> selectedConverterType,
            ServerHttpRequest request, ServerHttpResponse response) {
        return body + "this is been modified";
    }

}
