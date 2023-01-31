package com.example.admin_bulbal.service.house.impl;

import com.example.admin_bulbal.dto.project.GetNameDto;
import com.example.admin_bulbal.model.house.TypeOfRoom;
import com.example.admin_bulbal.repository.house.TypeOfRoomRepo;
import com.example.admin_bulbal.service.house.TypeOfRoomService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeOfRoomServiceImpl implements TypeOfRoomService {
    private final TypeOfRoomRepo typeOfRoomRepo;

    public TypeOfRoomServiceImpl(TypeOfRoomRepo typeOfRoomRepo) {
        this.typeOfRoomRepo = typeOfRoomRepo;
    }

    @Override
    public TypeOfRoom save(GetNameDto getNameDto) {
        TypeOfRoom typeOfRoom = new TypeOfRoom();
        typeOfRoom.setName(getNameDto.getName());
        return typeOfRoomRepo.save(typeOfRoom);
    }

    @Override
    public TypeOfRoom update(GetNameDto getNameDto, Long id) {
        TypeOfRoom typeOfRoom = findById(id);
        if (typeOfRoom != null){
            typeOfRoom.setName(getNameDto.getName());
            return typeOfRoomRepo.save(typeOfRoom);
        }
        return null;
    }

    @Override
    public TypeOfRoom findById(Long id) {
        return typeOfRoomRepo.findTypeOfRoomById(id);
    }

    @Override
    public boolean deleteById(Long id) {
        TypeOfRoom typeOfRoom = findById(id);
        if (typeOfRoom != null){
            typeOfRoomRepo.delete(typeOfRoom);
            return true;
        }
        return false;
    }

    @Override
    public List<TypeOfRoom> all() {
        return typeOfRoomRepo.findAll();
    }
}
