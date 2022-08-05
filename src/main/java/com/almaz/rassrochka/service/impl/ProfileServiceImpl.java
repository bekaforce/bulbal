package com.almaz.rassrochka.service.impl;

import com.almaz.rassrochka.domain.ProfileDb;
import com.almaz.rassrochka.domain.dto.*;
import com.almaz.rassrochka.domain.repository.CallProfileDto;
import com.almaz.rassrochka.domain.repository.DistinctCallProfileRepoDto;
import com.almaz.rassrochka.domain.repository.MainDashRepoDto;
import com.almaz.rassrochka.domain.repository.ProfileDbRepo;
import com.almaz.rassrochka.service.ProfileService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProfileServiceImpl implements ProfileService {
    private final ProfileDbRepo profileDbRepo;

    public ProfileServiceImpl(ProfileDbRepo profileDbRepo) {
        this.profileDbRepo = profileDbRepo;
    }
    @Override
    public List<ProfileDb> findAll() {
        return profileDbRepo.findAll();
    }

    @Override
    public Optional<ProfileDb> findById(Long id) {
        return profileDbRepo.findById(id);
    }

    @Override
    public ProfileDb addProfiles(ProfileDto profileDto) {
        ProfileDb profileDb = new ProfileDb();
        profileDb.setFullName(profileDto.getFullName());
        profileDb.setPassportInn(profileDto.getPassportInn());
        profileDb.setPassportSeries(profileDto.getPassportSeries());
        profileDb.setPassportDate(profileDto.getPassportDate());
        profileDb.setPassportDepartment(profileDto.getPassportDepartment());
        profileDb.setPassportAddress(profileDto.getPassportAddress());
        profileDb.setWorkAddress(profileDto.getWorkAddress());
        profileDb.setFactAddress(profileDto.getFactAddress());
        profileDb.setPhone(profileDto.getPhone());
        profileDb.setSalesmanLogin(SecurityContextHolder.getContext().getAuthentication().getName());
        profileDb.setRegistrationDate(LocalDateTime.now());

        return profileDbRepo.save(profileDb);
    }
    @Override
    public List<ProfileDb> findByFullName(String fullName) {
        return profileDbRepo.findByFullNameIgnoreCaseContaining(fullName);
    }
    @Override
    public List<ProfileDb> findByPassportInn(String passportInn) {
        return profileDbRepo.findByPassportInnIgnoreCaseContaining(passportInn);
    }

    @Override
    public List<CallActiveProfileDto> findCallProfile() {
        List<CallProfileDto> callDto = profileDbRepo.findCallProfile();

        List<CallActiveProfileDto> result = new ArrayList<>();
        for(CallProfileDto d : callDto){
            result.add(CallActiveProfileDto.builder()
                            .id(d.getId())
                            .fullName(d.getFullName())
                            .phone(d.getPhone())
                            .deviceModel(d.getDeviceModel())
                            .devicePrice(d.getDevicePrice())
                            .zeroPayment(d.getZeroPayment())
                            .countMonth(d.getCountMonth())
                            .debt(d.getDebt())
                            .payDate(d.getPayDate())
                            .statusType(d.getStatusType())
                            .salesmanLogin(d.getSalesmanLogin())
                            .comment(d.getComment())
                            .creditId(d.getCreditId())
                            .mcId(d.getMcId())
                    .build());

        }

        return result;
    }

    @Override
    public Optional<ProfileDb> editUserProfile(ProfileDb profileDb) {
        return profileDbRepo.findById(profileDb.getId())
                .map(list -> {
                    list.setId(profileDb.getId());
                    list.setFullName(profileDb.getFullName());
                    list.setBirthday(profileDb.getBirthday());
                    list.setPassportInn(profileDb.getPassportInn());
                    list.setPassportSeries(profileDb.getPassportSeries());
                    list.setPassportDate(profileDb.getPassportDate());
                    list.setPassportDepartment(profileDb.getPassportDepartment());
                    list.setPassportAddress(profileDb.getPassportAddress());
                    list.setWorkAddress(profileDb.getWorkAddress());
                    list.setFactAddress(profileDb.getFactAddress());
                    list.setPhone(profileDb.getPhone());
                    list.setRegistrationDate(LocalDateTime.now());
                    list.setSalesmanLogin(SecurityContextHolder.getContext().getAuthentication().getName());
                    return profileDbRepo.save(list);
                });
    }

    @Override
    public List<ProfileDb> findProfileByPeriod(LocalDateTime start, LocalDateTime end) {
        return profileDbRepo.findAllByRegistrationDateBetween(start, end);
    }

    @Override
    public List<MainDashProfileDto> findProfileForDash(LocalDateTime start, LocalDateTime end) {
        List<MainDashRepoDto> mainDashRepoDtos = profileDbRepo.dashBoardProfile(start, end);
        return getMainDashProfileDtos(mainDashRepoDtos);
    }

    private List<MainDashProfileDto> getMainDashProfileDtos(List<MainDashRepoDto> mainDashRepoDtos) {
        List<MainDashProfileDto> result = new ArrayList<>();
        for(MainDashRepoDto d : mainDashRepoDtos){
            result.add(MainDashProfileDto.builder()
                            .id(d.getId())
                            .fullName(d.getFullName())
                            .passportInn(d.getPassportInn())
                            .deviceImei(d.getDeviceImei())
                            .statusType(d.getStatusType())
                            .registrationDate(d.getRegistrationDate())
                            .salesmanLogin(d.getSalesmanLogin())
                    .build());
        }
        return result;
    }

    @Override
    public List<MainDashProfileDto> findProfileByFullName(String fullName) {
        List<MainDashRepoDto> mainDashRepoDtos = profileDbRepo.findByFullName(fullName);
        return getMainDashProfileDtos(mainDashRepoDtos);
    }

    @Override
    public List<MainDashProfileDto> findProfileByDeviceImei(String deviceImei) {
        List<MainDashRepoDto> mainDashRepoDtos = profileDbRepo.findByDeviceImei(deviceImei);
        return getMainDashProfileDtos(mainDashRepoDtos);
    }

    @Override
    public List<MainDashProfileDto> findProfileByPassportInn(String passportInn) {
        List<MainDashRepoDto> mainDashRepoDtos = profileDbRepo.findByPassportInnDto(passportInn);
        return getMainDashProfileDtos(mainDashRepoDtos);
    }

    @Override
    public List<MainDashProfileDto> findProfileByFullNameByDeletedStatus(String fullName) {
        List<MainDashRepoDto> mainDashRepoDtos = profileDbRepo.findByFullNameByDeletedStatus(fullName);
        return getMainDashProfileDtos(mainDashRepoDtos);
    }

    @Override
    public List<MainDashProfileDto> findDeletedProfileByDate(LocalDateTime start, LocalDateTime end) {
        List<MainDashRepoDto> mainDashRepoDtos = profileDbRepo.dashBoardProfileDeleteByDate(start, end);
        return getMainDashProfileDtos(mainDashRepoDtos);
    }

    @Override
    public List<DistinctCallProfileDto> distinctCallProfile() {
        List<DistinctCallProfileRepoDto> callDto = profileDbRepo.distinctCallProfile();

        List<DistinctCallProfileDto> result = new ArrayList<>();
        for(DistinctCallProfileRepoDto d : callDto){
            result.add(DistinctCallProfileDto.builder()
                            .id(d.getId())
                            .creditId(d.getCreditId())
                            .fullName(d.getFullName())
                            .deviceModel(d.getDeviceModel())
                            .devicePrice(d.getDevicePrice())
                            .phone(d.getPhone())
                            .zeroPayment(d.getZeroPayment())
                    .build());
        }
        return result;
    }

    @Override
    public Optional<ProfileDb> deleteProfileStatus(DeletedStatusDto deletedStatusDto) {
        return profileDbRepo.findById(deletedStatusDto.getId())
                .map(d->{
                    d.setDeleted(deletedStatusDto.getDeleted());
                    return profileDbRepo.save(d);
                });

    }




}
