package com.zeldev.names_manager.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.zeldev.names_manager.entity.NameEntity;

public interface NameRepository extends JpaRepository<NameEntity, Long>{

  @Query("SELECT ne FROM NameEntity ne WHERE ne.name = :name")
  List<NameEntity> findName(String name);

  @Modifying 
  @Query("UPDATE NameEntity ne SET ne.name = :newName WHERE ne.name = :oldName")
  void updateName(String oldName, String newName);

  @Modifying 
  @Query ("DELETE FROM NameEntity ne WHERE ne.name = :name")
  void deleteName(String name);

  boolean existsByName(String name);
}
