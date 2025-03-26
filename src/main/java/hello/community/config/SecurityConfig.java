package hello.community.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable()  // 개발 환경에서는 CSRF 비활성화, 운영 환경에서는 주의!
                .authorizeHttpRequests(authorize -> authorize
                        // /auth/** 경로는 인증 없이 접근 가능하도록 설정
                        .antMatchers("/auth/**").permitAll()
                        // 나머지 경로는 인증 필요
                        .anyRequest().authenticated()
                );
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
