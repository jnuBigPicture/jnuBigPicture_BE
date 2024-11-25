package kr.ac.jnu.capstone.bigpicture.dongsim._common.config;

import java.util.List;
import kr.ac.jnu.capstone.bigpicture.dongsim._common.auth.AuthorizedEndpointResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@RequiredArgsConstructor
public class WebMvcConfig implements WebMvcConfigurer {

    private final AuthorizedEndpointResolver authorizedEndpointResolver;

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(authorizedEndpointResolver);
    }
}
