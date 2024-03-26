package com.celin.sitecelin.entities.users.student.utils;

import com.celin.sitecelin.entities.course.utils.Evaluation;
import com.celin.sitecelin.model.Evaluations;

import java.util.LinkedHashMap;
import java.util.UUID;

public class ReportCard {
  private LinkedHashMap<Evaluation, Integer> grades = new LinkedHashMap<>();
  public void addGrade(Long evaluationId, Integer grade) throws RuntimeException {
    Evaluation evaluation = Evaluations.getEvaluation(evaluationId);
    grades.put(evaluation, grade);
  }
  public LinkedHashMap<Evaluation, Integer> getGrades (){
    return grades;
  }
}
