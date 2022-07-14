package com.example.project.service;

import com.example.project.dto.mapper;
import com.example.project.dto.requestDto.PlantRequestDto;
import com.example.project.dto.responseDto.PlantResponseDto;
import com.example.project.model.Plant;
import com.example.project.repository.PlantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PlantServiceImpl implements PlantService {

    private final PlantRepository plantRepository;
    @Autowired
    public PlantServiceImpl(PlantRepository plantRepository) {
        this.plantRepository = plantRepository;
    }

    @Override
    public List<PlantResponseDto> getPlants() {
        List<Plant> plants = plantRepository.findAll();
        return mapper.plantToPlantRequestDtos(plants);
    }

    @Override
    public PlantResponseDto addPlant(PlantRequestDto plantRequestDto) {
        Plant plant = new Plant();
        plant.setId(UUID.randomUUID().toString());
        plant.setName(plantRequestDto.getName());
        plant.setHeight(plantRequestDto.getHeight());
        plantRepository.save(plant);
        return mapper.plantToPlantRequestDto(plant);
    }

    @Override
    public PlantResponseDto getPlant(String plantId) {
        Plant plant = plantRepository.findById(plantId).get();
        return mapper.plantToPlantRequestDto(plant);
    }

    @Override
    public PlantResponseDto deletePlant(String plantId) {
        Plant plant = plantRepository.findById(plantId).get();
        plantRepository.delete(plant);
        return mapper.plantToPlantRequestDto(plant);
    }
}
