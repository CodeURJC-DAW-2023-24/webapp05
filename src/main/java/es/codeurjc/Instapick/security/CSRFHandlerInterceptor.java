package es.codeurjc.Instapick.security;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

class CSRFHandlerInterceptor implements HandlerInterceptor {
    @Override
    public void postHandle(final HttpServletRequest request,final HttpServletResponse response, final Object handler,
    final ModelAndView modelAndView) throws Exception {
        if (modelAndView != null) {
            CsrfToken token = (CsrfToken) request.getAttribute("_csrf");
            if (token != null) {
                modelAndView.addObject("token", token.getToken());
            }
        }
    }
}
