package com.celin.sitecelin.service;

import com.celin.sitecelin.entities.course.utils.Evaluation;
import com.celin.sitecelin.entities.course.utils.dto.EvaluationCreationDto;
import com.celin.sitecelin.entities.course.utils.dto.EvaluationUpdateDto;
import com.celin.sitecelin.model.Evaluations;
import com.celin.sitecelin.utils.InternalHelper;
import org.springframework.stereotype.Service;

@Service
public class EvaluationService {
  public Evaluation createEvaluation(EvaluationCreationDto dto) {
    Evaluation evaluation = Evaluations.addEvaluation(dto);
    evaluation.setCourseId(dto.sourceUserId());
    return evaluation;
  }

  public Evaluation[] getAllEvaluations() {
    return Evaluations.getAllEvaluations();
  }

  public Evaluation updateEvaluate(EvaluationUpdateDto dto) {
    Evaluation evaluation = Evaluations.getEvaluation(dto.id());
    return InternalHelper.EvaluationUpdate(evaluation, dto);
  }
}
