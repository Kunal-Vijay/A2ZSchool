package com.ktech.a2zschool.repository;

import com.ktech.a2zschool.model.Courses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoursesRepository extends JpaRepository<Courses, Integer> {

}