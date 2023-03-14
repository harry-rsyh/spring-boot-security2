package com.example.jpasecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.jpasecurity.model.Post;

public interface PostRepository extends JpaRepository<Post, Long>{
    
}
