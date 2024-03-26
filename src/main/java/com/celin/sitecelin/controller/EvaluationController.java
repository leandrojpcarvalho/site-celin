package com.celin.sitecelin.controller;

import com.celin.sitecelin.entities.course.utils.Evaluation;
import com.celin.sitecelin.entities.course.utils.dto.EvaluationCreationDto;
import com.celin.sitecelin.entities.course.utils.dto.EvaluationUpdateDto;
import com.celin.sitecelin.service.EvaluationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/evaluation")
public class EvaluationController {
  private EvaluationService service;

  @Autowired
  public EvaluationController(EvaluationService service) {
    this.service = service;
  }
  @GetMapping
  public ResponseEntity<Evaluation[]> getAllEvaluation(){
    return ResponseEntity.ok(service.getAllEvaluations());
  }

  @PostMapping
  public ResponseEntity<Evaluation> postEvaluation(@RequestBody EvaluationCreationDto dto) {
    return ResponseEntity
          .status(HttpStatus.CREATED)
          .body(service.createEvaluation(dto));
  }

  @PutMapping
  public ResponseEntity<Evaluation> putEvaluation(@RequestBody EvaluationUpdateDto dto) {
    return ResponseEntity
          .status(HttpStatus.ACCEPTED)
          .body(service.updateEvaluate(dto));
  }
}
