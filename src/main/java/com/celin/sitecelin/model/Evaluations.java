package com.celin.sitecelin.model;

import com.celin.sitecelin.entities.course.utils.Evaluation;
import com.celin.sitecelin.entities.course.utils.dto.EvaluationCreationDto;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class Evaluations {
  private static final List<Evaluation> evaluations = new ArrayList<>();

  static {
    evaluations.add(new Evaluation(1L));
    evaluations.add(new Evaluation(2L));
    evaluations.add(new Evaluation(3L));
  }

  public static Evaluation addEvaluation(EvaluationCreationDto dto) {
    if (evaluations.stream().noneMatch(evaluation1 -> evaluation1.getUrl().equals(dto.url()))) {
      Evaluation evaluation = new Evaluation(evaluations.stream().count());
      evaluation.setUrl(dto.url());
      evaluation.setSourceUserId(dto.sourceUserId());
      evaluations.add(evaluation);
      return evaluation;
    } else {
      throw new RuntimeException("this Evaluation exist");
    }
  }

  public static Evaluation getEvaluation(Long evaluationId) throws RuntimeException {
    Optional<Evaluation> evaluation = evaluations.stream().filter(evaluation1 -> evaluation1.getId() == evaluationId).findAny();
    if (evaluation.isPresent()) {
      return evaluation.get();
    }
    throw new RuntimeException("this evaluation does not exist");
  }

  public static Evaluation[] getEvaluationsByCourseId(UUID courseId) {
    return evaluations.stream()
          .filter(evaluation -> evaluation.getId().equals(courseId))
          .toList()
          .toArray(new Evaluation[0]);
  }

  public static Evaluation[] getAllEvaluations() {
    return evaluations.toArray(new Evaluation[0]);
  }
}
