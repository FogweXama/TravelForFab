package com.travel.travel.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.travel.travel.Domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
