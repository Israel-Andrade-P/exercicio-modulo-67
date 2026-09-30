package com.zeldev.names_manager.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zeldev.names_manager.entity.NameEntity;
import com.zeldev.names_manager.exception.NameDoesntExistException;
import com.zeldev.names_manager.repository.NameRepository;
import com.zeldev.names_manager.request.NameRequest;
import com.zeldev.names_manager.response.NameResponse;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class NameService {
  private final NameRepository nameRepository;

  public NameResponse postName(NameRequest request) {
    return toResponse(nameRepository.save(toEntity(request)));
  }

  public List<NameResponse> getNames() {
    return nameRepository.findAll().stream().map(this::toResponse).toList();
  }

  public List<NameResponse> getName(String name) {
    return nameRepository.findName(name).stream().map(this::toResponse).toList();
  }

  @Transactional 
  public void updateName(String oldName, String newName) {
    if (!nameRepository.existsByName(oldName))
      throw new NameDoesntExistException(String.format("Name %s not found", oldName));

    nameRepository.updateName(oldName, newName);
  }

  @Transactional 
  public void deleteName(String name) {
    if (!nameRepository.existsByName(name))
      throw new NameDoesntExistException(String.format("Name %s not found", name));

    nameRepository.deleteName(name);
  }


  private NameEntity toEntity(NameRequest request) {
    return NameEntity.builder()
        .name(request.name())
        .build();
  }

  private NameResponse toResponse(NameEntity entity) {
    return NameResponse.builder()
        .name(entity.getName())
        .build();
  }
}
