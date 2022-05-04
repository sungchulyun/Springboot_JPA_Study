package SecurityConfig;


import lombok.extern.java.Log;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@Log
@EnableWebSecurity
public class SecurityConfig {

    @Override
    protected void configure(HttpSecurity http)throws Exception{

        log.info("security config.....................");
    }

    @Bean
}
