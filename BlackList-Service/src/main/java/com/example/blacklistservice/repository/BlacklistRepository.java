package com.example.blacklistservice.repository;

import com.example.blacklistservice.ModelMigration.Blacklist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlacklistRepository extends JpaRepository<Blacklist, Long> {

}