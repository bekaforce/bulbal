package com.almaz.rassrochka.service.impl;

import com.almaz.rassrochka.domain.ProfileDb;
import com.almaz.rassrochka.domain.dto.CallActiveProfileDto;
import com.almaz.rassrochka.domain.dto.ProfileDto;
import com.almaz.rassrochka.domain.repository.CallProfileDto;
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
}
