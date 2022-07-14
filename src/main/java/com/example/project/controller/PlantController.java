package com.example.project.controller;

import com.example.project.dto.requestDto.PlantRequestDto;
import com.example.project.dto.responseDto.PlantResponseDto;
import com.example.project.service.PlantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// ENABLE CORS -->
@CrossOrigin
@RestController
@RequestMapping("/api/plant")
public class PlantController {

    private final PlantService plantService;
    @Autowired
    public PlantController(PlantService plantService) {
        this.plantService = plantService;
    }

    @GetMapping("/getPlants")
    public ResponseEntity<List<PlantResponseDto>> getPlants() {
        List<PlantResponseDto> plantList = plantService.getPlants();
        return new ResponseEntity<>(plantList, HttpStatus.OK);
    }

    @PostMapping("/addPlant")
    public ResponseEntity<PlantResponseDto> addPlant(@RequestBody final PlantRequestDto plantRequestDto) {
        PlantResponseDto plantResponseDto = plantService.addPlant(plantRequestDto);
        return new ResponseEntity<>(plantResponseDto, HttpStatus.OK);
    }

    @GetMapping("/getPlant/{plantId}")
    public ResponseEntity<PlantResponseDto> getPlant(@PathVariable final String plantId){
        PlantResponseDto plantResponseDto = plantService.getPlant(plantId);
        return new ResponseEntity<>(plantResponseDto, HttpStatus.OK);
    }

    @DeleteMapping("/deletePlant/{plantId}")
    public ResponseEntity<PlantResponseDto> deletePlant(@PathVariable final String plantId) {
        PlantResponseDto plantResponseDto = plantService.deletePlant(plantId);
        return new ResponseEntity<>(plantResponseDto, HttpStatus.OK);
    }

}
