package com.polware.controlclients.configs;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.access.AccessDeniedHandler;

import java.io.IOException;

/**
 * Created by IntelliJ IDEA
 * User: Paul H. Vargas P.
 * Date: 7/06/2023
 * Time: 9:48 a. m.
 */
public class CustomAccessDeniedHandler implements AccessDeniedHandler {
    private static final Logger LOG = LoggerFactory.getLogger(CustomAccessDeniedHandler.class);

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response,
                       AccessDeniedException accessDeniedException) throws IOException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            LOG.info("User '" + authentication.getName() +
                    "' attempted to access the URL: " +
                    request.getRequestURI());
        }
        response.sendRedirect(request.getContextPath() + "/page403");
    }

}
