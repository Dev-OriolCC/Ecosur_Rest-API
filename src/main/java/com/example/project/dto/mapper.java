package com.example.project.dto;

import com.example.project.dto.requestDto.PlantRequestDto;
import com.example.project.dto.responseDto.PlantResponseDto;
import com.example.project.dto.responseDto.UserResponseDto;
import com.example.project.model.Plant;
import com.example.project.model.User;

import java.util.ArrayList;
import java.util.List;

public class mapper {

    public static PlantResponseDto plantToPlantRequestDto(Plant plant) {
        PlantResponseDto plantRequestDto = new PlantResponseDto();
        plantRequestDto.setName(plant.getName());
        plantRequestDto.setHeight(plant.getHeight());
        return plantRequestDto;
    }

    public static List<PlantResponseDto> plantToPlantRequestDtos(List<Plant> plants) {
        List<PlantResponseDto> plantRequestDtos = new ArrayList<>();
        for (Plant plant : plants) {
            plantRequestDtos.add(plantToPlantRequestDto(plant));
        }
        return plantRequestDtos;
    }

    public static UserResponseDto userToUserResponseDto(User user) {
        UserResponseDto userResponseDto = new UserResponseDto();
        userResponseDto.setEmail(user.getEmail());
        return userResponseDto;
    }

}
