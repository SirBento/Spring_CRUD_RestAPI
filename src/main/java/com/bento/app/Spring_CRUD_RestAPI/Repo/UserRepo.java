package com.bento.app.Spring_CRUD_RestAPI.Repo;

import com.bento.app.Spring_CRUD_RestAPI.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
}
