package com.elior.autoCompletedApp.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.elior.autoCompletedApp.entities.Name;

public interface NameRepository extends JpaRepository<Name, Integer> {

}
