package com.zeldev.names_manager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zeldev.names_manager.entity.NameEntity;

public interface NameRepository extends JpaRepository<NameEntity, Long>{

}
