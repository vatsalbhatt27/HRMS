package com.magadhUniversity.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/files/**")
                .addResourceLocations("file:///F:/tripliller/HRMS-MU (2)/HRMS-MU/HRMS-MU/upload-dir/")
                .setCachePeriod(3600)  // optional cache duration
                .resourceChain(true);

        registry.addResourceHandler("/pdfs/**")
                .addResourceLocations("file:///F:/tripliller/HRMS-MU (2)/HRMS-MU/HRMS-MU/pdf-dir/")
                .setCachePeriod(3600)
                .resourceChain(true);

        registry.addResourceHandler("/images/**")
                .addResourceLocations("file:///F:/tripliller/HRMS-MU (2)/HRMS-MU (2)/HRMS-MU/HRMS-MU/upload-dir/")
                .setCachePeriod(3600)
                .resourceChain(true);
    }


}


