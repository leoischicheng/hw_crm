package com.smartbee.crm.service;

import com.smartbee.crm.common.constants.WebErrorCode;
import com.smartbee.crm.entity.User;
import com.smartbee.crm.handler.BusinessException;
import com.smartbee.crm.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author Leo
 * @Date :2021/1/24
 */
@Service
public class UserS implements UserDetailsService {
    @Autowired
    private UserRepo userRepo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByUserName(username);
        if (user == null) {
            throw new BusinessException(WebErrorCode.DATA_NOT_FOUNT_ERROR, WebErrorCode.DATA_NOT_FOUNT_ERROR.getMessage() + " " + username );
        }

        return user;
    }
}
