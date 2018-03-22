package uk.co.datadisk.demo.services.security;

import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoginAspect {

    private LoginFailureEventPublisher publisher;

    @Autowired
    public LoginAspect(LoginFailureEventPublisher publisher) {
        this.publisher = publisher;
    }

    @Pointcut("execution(* org.springframework.security.authentication.AuthenticationProvider.authenticate(..))")
    public void doAuthenticate(){

    }

    @Before("uk.co.datadisk.demo.services.security.LoginAspect.doAuthenticate() && args(authentication)")
    public void logBefore(Authentication authentication){
        System.out.println("This is before the Authenticate Method: authentication: " + authentication.isAuthenticated());
    }

    @AfterReturning(value = "uk.co.datadisk.demo.services.security.LoginAspect.doAuthenticate()", returning = "authentication")
    public void logAfterAuthenticate( Authentication authentication){
        System.out.println("This is after the Authenticate Method authentication: " + authentication.isAuthenticated());
    }

    @AfterThrowing("uk.co.datadisk.demo.services.security.LoginAspect.doAuthenticate() && args(authentication)")
    public void logAuthenicationException(Authentication authentication){
        String userDetails = (String) authentication.getPrincipal();
        System.out.println("Login failed for user: " + userDetails);

        publisher.publish(new LoginFailureEvent(authentication));
    }
}
