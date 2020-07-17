package com.mrchoozy.demoboot.repositories;

import com.mrchoozy.demoboot.entity.Hobby;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HobbyRepository extends CrudRepository<Hobby, Long> {
}
