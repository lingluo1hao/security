package com.luo.security.security.config;

import com.luo.security.security.entity.sRole;
import com.luo.security.security.entity.sUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

public class SecurityUser  extends sUser implements UserDetails {


    private static final long serialVersionUID = 1L;
    public SecurityUser(sUser suser) {
        if(suser != null)
        {
            this.setId(suser.getId());
            this.setName(suser.getName());
            this.setEmail(suser.getEmail());
            this.setPassword(suser.getPassword());
            this.setDob(suser.getDob());
            this.setSRoles(suser.getSRoles());
        }
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        Collection<GrantedAuthority> authorities = new ArrayList<>();
        Set<sRole> userRoles = this.getSRoles();

        if(userRoles != null)
        {
            for (sRole role : userRoles) {
                SimpleGrantedAuthority authority = new SimpleGrantedAuthority(role.getName());
                authorities.add(authority);
            }
        }
        return authorities;
    }

    @Override
    public String getPassword() {
        return super.getPassword();
    }

    @Override
    public String getUsername() {
        return super.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }


}
