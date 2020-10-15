package com.blogIn.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.blogIn.dao.Authority;

public interface AuthorityRepository extends JpaRepository<Authority, Long>{
}