package com.viettel.intern.config.properties;

import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

@Configuration
@ConfigurationProperties(
        prefix = "app"
)
@Getter
@Setter
public class AppConfigurationProperties {
    private List<String> localeResolverLanguages = Arrays.asList("en", "vi");
    private String defaultLanguage = "vi";
    private int asyncExecutorCorePoolSize = 2;
    private int asyncExecutorMaxPoolSize = 4;
    private String asyncExecutorThreadNamePrefix = "Async-";

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
