package com.example.demo.repositories.cd;

import com.example.demo.models.cd.Cd;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CdRp extends JpaRepository<Cd, Long> {
}
