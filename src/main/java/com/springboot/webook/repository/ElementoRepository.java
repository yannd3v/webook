package com.springboot.webook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.webook.model.Elemento;

public interface ElementoRepository extends JpaRepository<Elemento, Long> {
	
	
	@Transactional
    @Modifying
    @Query("UPDATE Elemento e SET e.confirmado = true WHERE e.id = :id")
    void confirmar(@Param("id") Long id);

}



