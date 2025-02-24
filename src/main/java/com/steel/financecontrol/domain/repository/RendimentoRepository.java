package com.steel.financecontrol.domain.repository;

import com.steel.financecontrol.model.Rendimento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RendimentoRepository extends JpaRepository<Rendimento, Long> {


    List<Rendimento> findByMesAndAno(Integer mes, Integer ano);



}
