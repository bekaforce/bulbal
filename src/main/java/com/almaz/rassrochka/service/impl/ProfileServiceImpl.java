package com.almaz.rassrochka.service.impl;

import com.almaz.rassrochka.domain.ProfileDb;
import com.almaz.rassrochka.domain.dto.*;
import com.almaz.rassrochka.domain.repository.*;
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
    public void deleteById(Long id) {
       profileDbRepo.deleteById(id);

    }

    @Override
    public ProfileDb addProfiles(ProfileDto profileDto) {
        ProfileDb profileDb = new ProfileDb();
        return getProfileDb(profileDto, profileDb);
    }

    @Override
    public Optional<ProfileDb> editProfiles(ProfileDto profileDto) {
       return profileDbRepo.findById(profileDto.getId())
                .map(profileDb -> getProfileDb(profileDto, profileDb));
    }

    private ProfileDb getProfileDb(ProfileDto profileDto, ProfileDb profileDb) {
        profileDb.setFullName(profileDto.getFullName());
        profileDb.setProfileNumber(profileDto.getProfileNumber());
        profileDb.setPhone(profileDto.getPhone());
        profileDb.setPhoneSecond(profileDto.getPhoneSecond());
        profileDb.setDeleted(profileDto.getDelete());
        profileDb.setSalesmanLogin(SecurityContextHolder.getContext().getAuthentication().getName());
        profileDb.setRegistrationDate(LocalDateTime.now());
        return profileDbRepo.save(profileDb);
    }



    @Override
    public List<CallProfileDto> findCallProfile() {
        return profileDbRepo.findCallProfile();

    }

    @Override
    public List<ProfileDb> findProfileByPeriod(LocalDateTime start, LocalDateTime end) {
        return profileDbRepo.findAllByRegistrationDateBetween(start, end);
    }

    @Override
    public List<MainDashRepoDto> findProfileForDash(LocalDateTime start, LocalDateTime end) {
        return profileDbRepo.dashBoardProfile(start, end);
    }

    private List<MainDashProfileDto> getMainDashProfileDtos(List<MainDashRepoDto> mainDashRepoDtos) {
        List<MainDashProfileDto> result = new ArrayList<>();
        for(MainDashRepoDto d : mainDashRepoDtos){
            result.add(MainDashProfileDto.builder()
                            .id(d.getDeviceId())
                            .fullName(d.getFullName())
                            .statusType(d.getStatusType())
                            .registrationDate(d.getRegistrationDate())
                            .salesmanLogin(d.getSalesmanLogin())
                    .build());
        }
        return result;
    }

    @Override
    public List<MainDashRepoDto> findProfileByFullName(String fullName) {

        if (fullName.matches("[0-9]+")){
            return profileDbRepo.findByProfileNumber(fullName);
        }
        else
            return profileDbRepo.findByFullName(fullName);
    }

    @Override
    public List<MainDashRepoDto> findProfileByDeviceImei(String deviceImei) {
        return profileDbRepo.findByProfileNumber(deviceImei);
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
    public List<ReportZeroPaymentDto> zeroPaymentProfile(ReportPaymentRequestDto reportPaymentRequestDto) {
        return profileDbRepo.zeroPaymentProfile(reportPaymentRequestDto.getStart(),
                reportPaymentRequestDto.getEnd(),
                reportPaymentRequestDto.getPaymentTypeList(),
                reportPaymentRequestDto.getSalesmanLoginList());
    }

    @Override
    public List<ReportMonthPaymentDto> monthPaymentProfile(ReportPaymentRequestDto reportPaymentRequestDto) {
        return profileDbRepo.monthPaymentProfile(reportPaymentRequestDto.getStart(),
                reportPaymentRequestDto.getEnd(),
                reportPaymentRequestDto.getPaymentTypeList(),
                reportPaymentRequestDto.getSalesmanLoginList());
    }

    @Override
    public List<DistinctCallProfileRepoDto> distinctCallProfile() {

        return profileDbRepo.distinctCallProfile();
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
