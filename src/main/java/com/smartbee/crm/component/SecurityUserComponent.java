package com.smartbee.crm.component;

import com.smartbee.crm.entity.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

/**
 * @author Leo
 * @Date :2021/1/24
 */
@Component
public class SecurityUserComponent {
    public User getAuthenticatedUser() {

        User user = null;
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if( auth != null) {
            Object principal = auth.getPrincipal();
            if( principal != null ) {
                user = (User)principal;
            }
        }

        return user;
    }
}
