package com.sky._sb0402_2.repository;

import com.sky._sb0402_2.entity.MyData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MyDataRepository extends JpaRepository<MyData, Long> {
}