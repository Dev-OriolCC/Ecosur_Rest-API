package com.example.project.service;

import com.example.project.dto.requestDto.PlantRequestDto;
import com.example.project.dto.responseDto.PlantResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PlantService {
    public List<PlantResponseDto> getPlants();
    public PlantResponseDto addPlant(PlantRequestDto plantRequestDto);
    public PlantResponseDto getPlant(String plantId);
    public PlantResponseDto deletePlant(String plantId);
}
