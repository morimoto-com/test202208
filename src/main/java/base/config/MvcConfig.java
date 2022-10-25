package base.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class MvcConfig implements WebMvcConfigurer {

    @Autowired
    private MessageSource messageSource;

    @Bean
    public LocalValidatorFactoryBean localValidatorFactoryBean(){
        LocalValidatorFactoryBean localValidatorFactoryBean = new LocalValidatorFactoryBean();

        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
//        messageSource.setBasename("classpath:/messages01");
//        messageSource.setDefaultEncoding("UTF-8");

        localValidatorFactoryBean.setValidationMessageSource(messageSource);

        return localValidatorFactoryBean;
    }

    @Override
    public Validator getValidator() {
        return localValidatorFactoryBean();
    }
}
