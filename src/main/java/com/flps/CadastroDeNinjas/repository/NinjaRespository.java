package com.flps.CadastroDeNinjas.repository;

import com.flps.CadastroDeNinjas.models.NinjaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NinjaRespository extends JpaRepository<NinjaModel, Long> {
}