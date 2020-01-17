package by.gsu.pms.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {
    @Value("${locations.image.path}")
    private String locationsImagePath;
    @Value("${company.logos.image.path}")
    private String companyLogosPath;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/img/flags/**")
                .addResourceLocations("file://" + locationsImagePath + "/");
        registry.addResourceHandler("/img/company/**")
                .addResourceLocations("file://" + companyLogosPath + "/");
    }
}
