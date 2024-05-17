package com.ktech.a2zschool.repository;

import com.ktech.a2zschool.model.SchoolClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SchoolClassRepository extends JpaRepository<SchoolClass,Integer> {

}
