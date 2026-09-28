package com.zeldev.names_manager.service;

import org.springframework.stereotype.Service;

import com.zeldev.names_manager.entity.NameEntity;
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
