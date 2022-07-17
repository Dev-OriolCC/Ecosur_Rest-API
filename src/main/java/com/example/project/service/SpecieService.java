package com.example.project.service;

import com.example.project.dto.requestDto.SpecieRequestDto;
import com.example.project.dto.responseDto.SpecieResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SpecieService {
    public List<SpecieResponseDto> getSpecies();
    public SpecieResponseDto addSpecie(SpecieRequestDto specieRequestDto);
    public SpecieResponseDto editSpecie(Integer id, SpecieRequestDto specieRequestDto);
    public SpecieResponseDto deleteSpecie(Integer id);
}
