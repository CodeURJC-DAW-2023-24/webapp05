package es.codeurjc.Instapick.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Configuration
public class CSRFHandlerConfiguration implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry){ // Adding a CSRF Handler Interceptor
        registry.addInterceptor(new CSRFHandlerInterceptor());
    }
}

class CSRFHandlerInterceptor implements HandlerInterceptor {
    @Override
    public void postHandle(final HttpServletRequest request,final HttpServletResponse response, final Object handler, final ModelAndView modelAndView) throws Exception{ // Post managing
        if (modelAndView != null) { // Check both model and view's existence
            CsrfToken token = (CsrfToken) request.getAttribute("_csrf");
            if (token != null) { // Check token's existence
                modelAndView.addObject("token", token.getToken());
            }
        }
    }
}
