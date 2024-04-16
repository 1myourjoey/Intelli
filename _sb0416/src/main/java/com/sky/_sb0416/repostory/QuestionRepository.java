package com.sky._sb0416.repostory;

import com.sky._sb0416.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Long> {
}
