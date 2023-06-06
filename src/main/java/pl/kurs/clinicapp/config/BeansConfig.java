package pl.kurs.clinicapp.config;

import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@PropertySource({"classpath:application-${spring.profiles.active}.properties"})

public class BeansConfig {

    @Bean
    public static PropertySourcesPlaceholderConfigurer getPspc() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}
