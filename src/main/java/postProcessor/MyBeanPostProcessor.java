package postProcessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Service;

/**
 * 在Bean创建后进行增强处理
 * 
 * @author Charlie
 *
 */
@Service("myBeanPostProcessor")
public class MyBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName)
            throws BeansException {
        System.out.println("*****" + beanName + "初始化之前进行增强处理");
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName)
            throws BeansException {
        System.out.println("*****" + beanName + "初始化之后进行增强处理");
        return bean;
    }

}
