package com.smartbee.crm.repo;

import com.smartbee.crm.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Leo
 * @Date :2021/1/24
 */
@Repository
public interface ClientRepo extends JpaRepository<Client, Integer> {
}
