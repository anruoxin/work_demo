package cn.weicelove.spring.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 5 以下使用WebMvcConfigurerAdapter
 * @author QIU PANWEI Create in 2019/11/26 14:57
 */
@Configuration
public class MvcConfigure implements WebMvcConfigurer {

    @Value("${file.path}")
    private String fileRootPath;

    /**
     * 文件映射路径
     * @param
     * @return void
     * @author QIU PANWEI
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/fileData/**")
                .addResourceLocations("file:" + fileRootPath);
//                .addResourceLocations("classpath:/static/")
//                .addResourceLocations("classpath:/public/")
//                .addResourceLocations("classpath:/resources/");
    }
}