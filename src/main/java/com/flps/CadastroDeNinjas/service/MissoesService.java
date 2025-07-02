package com.flps.CadastroDeNinjas.service;

import com.flps.CadastroDeNinjas.models.MissoesModel;
import com.flps.CadastroDeNinjas.repository.MissoesRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MissoesService {
    private MissoesRepository missoesRepository;

    public MissoesService(MissoesRepository missoesRepository) {
        this.missoesRepository = missoesRepository;
    }

    public List<MissoesModel> findAll(){
        return missoesRepository.findAll();
    }

    public Optional<MissoesModel> findById(Long id){
        return missoesRepository.findById(id);
    }

    public MissoesModel save(MissoesModel missoesModel){
        return missoesRepository.save(missoesModel);
    }

    public void delete(Long id){
        missoesRepository.deleteById(id);
    }
}
