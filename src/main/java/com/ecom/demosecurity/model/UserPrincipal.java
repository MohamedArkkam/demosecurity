package com.ecom.demosecurity.model;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UserPrincipal implements UserDetails {

    private Users user;

    public UserPrincipal(Users user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities(){
        return Collections.singleton(new SimpleGrantedAuthority("USER")); // Assuming a single role for simplicity
        
        // throw new UnsupportedOperationException("Unimplemented method 'getAuthorities'");
    }

    @Override
    public String getUsername() {
        return user.getUsername();
        // throw new UnsupportedOperationException("Unimplemented method 'getUsername'");
    }
    
    @Override
    public String getPassword() throws UnsupportedOperationException {
        return user.getPassword();
        // throw new UnsupportedOperationException("Unimplemented method 'getPassword'");
    }

    

}
