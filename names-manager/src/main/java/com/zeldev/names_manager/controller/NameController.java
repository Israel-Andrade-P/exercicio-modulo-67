package com.zeldev.names_manager.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zeldev.names_manager.request.NameRequest;
import com.zeldev.names_manager.request.NameUpdateRequest;
import com.zeldev.names_manager.response.NameResponse;
import com.zeldev.names_manager.service.NameService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class NameController {
  private final NameService nameService;

  @PostMapping("/post")
  public ResponseEntity<NameResponse> postName(@RequestBody NameRequest request) {
    return ResponseEntity.status(HttpStatus.OK).body(nameService.postName(request));
  }

  @GetMapping("/all")
  public ResponseEntity<List<NameResponse>> getNames() {
    return ResponseEntity.status(HttpStatus.OK).body(nameService.getNames());
  }

  @GetMapping("/{name}")
  public ResponseEntity<List<NameResponse>> getName(@PathVariable("name") String name) {
    return ResponseEntity.status(HttpStatus.OK).body(nameService.getName(name));
  }

  @PutMapping
  public ResponseEntity<Void> updateName(@RequestBody NameUpdateRequest request) {
    nameService.updateName(request.oldName(), request.newName());
    return ResponseEntity.noContent().build();
  }

  @DeleteMapping("/{name}")
  public ResponseEntity<Void> deleteName(@PathVariable("name") String name) {
    nameService.deleteName(name);
    return ResponseEntity.noContent().build();
  }
}
