package com.zeldev.names_manager.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zeldev.names_manager.request.NameRequest;
import com.zeldev.names_manager.response.NameResponse;
import com.zeldev.names_manager.service.NameService;

import lombok.RequiredArgsConstructor;

@RestController 
@RequestMapping("/api/v1")
@RequiredArgsConstructor 
public class NameController {
  private final NameService nameService;

  public ResponseEntity<NameResponse> postName(@RequestBody NameRequest request) {
    return ResponseEntity.status(HttpStatus.OK).body(nameService.postName(request));
  }
}
