package com.example.KMA.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class WebConfig implements WebMvcConfigurer{

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new MultipartFileToStringConverter());
    }
    
    private class MultipartFileToStringConverter implements Converter<MultipartFile, String> {

        @Override
        public String convert(MultipartFile source) {
            return source.getOriginalFilename();
        }
    }
}
