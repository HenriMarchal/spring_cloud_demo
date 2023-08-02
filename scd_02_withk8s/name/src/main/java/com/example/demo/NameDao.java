package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NameDao extends JpaRepository<Name, Integer> {
    Name findById(int id);
}

