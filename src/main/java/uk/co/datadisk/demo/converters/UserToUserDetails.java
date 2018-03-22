package uk.co.datadisk.demo.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import uk.co.datadisk.demo.domain.User;
import uk.co.datadisk.demo.services.security.UserDetailsImpl;

import java.util.ArrayList;
import java.util.Collection;


@Component
public class UserToUserDetails implements Converter<User, UserDetails> {
    @Override
    public UserDetails convert(User user) {
        UserDetailsImpl userDetails = new UserDetailsImpl();
        userDetails.setUsername(user.getUsername());
        userDetails.setPassword(user.getEncryptedPassword());
        userDetails.setEnabled(user.getEnabled());

        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();

        user.getRoles().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority(role.getRole()));
        });

        userDetails.setAuthorities(authorities);

        return userDetails;
    }
}
