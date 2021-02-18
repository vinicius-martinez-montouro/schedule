package com.ifsp.prss6.schedule.repository;

import com.ifsp.prss6.schedule.model.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author vinicius.montouro
 * Class repository of User
 */
public interface UserRepository extends MongoRepository<User, String> {

    /**
     * Search by cpf
     * @param cpf
     * @return
     */
    User findByCpf(String cpf);
}
