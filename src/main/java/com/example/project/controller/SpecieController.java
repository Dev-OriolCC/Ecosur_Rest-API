package com.example.project.controller;

import com.example.project.dto.requestDto.SpecieRequestDto;
import com.example.project.dto.responseDto.SpecieResponseDto;
import com.example.project.service.SpecieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/specie")
public class SpecieController {

    private final SpecieService specieService;
    @Autowired
    public SpecieController(SpecieService specieService) {
        this.specieService = specieService;
    }

    @GetMapping("/getSpecies")
    public ResponseEntity<List<SpecieResponseDto>> getSpecies() {
        List<SpecieResponseDto> specieList = specieService.getSpecies();
        return new ResponseEntity<>(specieList, HttpStatus.OK);
    }

    @PostMapping("/addSpecie")
    public ResponseEntity<SpecieResponseDto> addSpecie(@RequestBody SpecieRequestDto specieRequestDto) {
        SpecieResponseDto specieResponseDto = specieService.addSpecie(specieRequestDto);
        return new ResponseEntity<>(specieResponseDto, HttpStatus.OK);
    }

    @PutMapping("/updateSpecie/{id}")
    public ResponseEntity<SpecieResponseDto> updateSpecie(@PathVariable final Integer id,@RequestBody SpecieRequestDto specieRequestDto) {
        SpecieResponseDto specieResponseDto = specieService.editSpecie(id, specieRequestDto);
        return new ResponseEntity<>(specieResponseDto, HttpStatus.OK);
    }

    @DeleteMapping("/deleteSpecie/{id}")
    public ResponseEntity<SpecieResponseDto> deleteSpecie(@PathVariable final Integer id) {
        SpecieResponseDto specieResponseDto = specieService.deleteSpecie(id);
        return new ResponseEntity<>(specieResponseDto, HttpStatus.OK);
    }

}
