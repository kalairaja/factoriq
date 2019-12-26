package com.incubate.repositary;

import com.incubate.repositary.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity, Long> {
        public UserEntity save(UserEntity userEntity);
}
