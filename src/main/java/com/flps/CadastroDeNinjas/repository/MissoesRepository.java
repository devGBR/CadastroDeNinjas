package com.flps.CadastroDeNinjas.repository;

import com.flps.CadastroDeNinjas.models.MissoesModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MissoesRepository extends JpaRepository<MissoesModel, Long> {
}
