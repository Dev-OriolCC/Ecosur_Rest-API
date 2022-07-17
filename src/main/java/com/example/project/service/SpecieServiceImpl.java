package com.example.project.service;

import com.example.project.dto.mapper;
import com.example.project.dto.requestDto.SpecieRequestDto;
import com.example.project.dto.responseDto.SpecieResponseDto;
import com.example.project.model.Specie;
import com.example.project.repository.SpecieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpecieServiceImpl implements SpecieService {

    private final SpecieRepository specieRepository;
    @Autowired
    public SpecieServiceImpl(SpecieRepository specieRepository) {
        this.specieRepository = specieRepository;
    }

    @Override
    public List<SpecieResponseDto> getSpecies() {
        List<Specie> species = specieRepository.findAll();
        return mapper.specieToSpecieResponseDtos(species);
    }

    @Override
    public SpecieResponseDto addSpecie(SpecieRequestDto specieRequestDto) {
        Specie specie = new Specie();
        specie.setName(specieRequestDto.getName());
        specie.setTotal(specieRequestDto.getTotal());
        specieRepository.save(specie);
        return mapper.specieToSpecieResponseDto(specie);
    }

    @Override
    public SpecieResponseDto editSpecie(Integer id, SpecieRequestDto specieRequestDto) {
        Specie specie = specieRepository.findById(id).get();
        specie.setName(specieRequestDto.getName());
        specie.setTotal(specieRequestDto.getTotal());
        specieRepository.save(specie);
        return mapper.specieToSpecieResponseDto(specie);
    }

    @Override
    public SpecieResponseDto deleteSpecie(Integer id) {
        Specie specie = specieRepository.findById(id).get();
        specieRepository.delete(specie);
        return mapper.specieToSpecieResponseDto(specie);
    }
}
