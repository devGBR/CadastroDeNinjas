package com.flps.CadastroDeNinjas.service;

import com.flps.CadastroDeNinjas.models.NinjaModel;
import com.flps.CadastroDeNinjas.repository.NinjaRespository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NinjaService {
    private NinjaRespository ninjaRespository;

    public NinjaService(NinjaRespository ninjaRespository) {
        this.ninjaRespository = ninjaRespository;
    }

    public List<NinjaModel> findAll() {
        return ninjaRespository.findAll();
    }

    public Optional<NinjaModel> findById(Long id) {
        return ninjaRespository.findById(id);
    }

    public NinjaModel save(NinjaModel ninja) {
        return ninjaRespository.save(ninja);
    }

    public void deleteById(Long id) {
        ninjaRespository.deleteById(id);
    }
}
