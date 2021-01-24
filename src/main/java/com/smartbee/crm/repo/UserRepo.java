package com.smartbee.crm.repo;

import com.smartbee.crm.entity.Company;
import com.smartbee.crm.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Leo
 * @Date :2021/1/24
 */
@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
    User findByUserName(String userName);
}
