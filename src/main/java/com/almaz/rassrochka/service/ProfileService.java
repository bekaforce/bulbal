package com.almaz.rassrochka.service;

import com.almaz.rassrochka.domain.ProfileDb;
import com.almaz.rassrochka.domain.dto.*;
import com.almaz.rassrochka.domain.repository.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface ProfileService {

    List<ProfileDb> findAll();

    Optional<ProfileDb> findById(Long id);
    void  deleteById(Long id);

    ProfileDb addProfiles(ProfileDto profileDto);
    Optional<ProfileDb> editProfiles(ProfileDto profileDto);

    List<CallProfileDto> findCallProfile();


    List<ProfileDb> findProfileByPeriod(LocalDateTime start, LocalDateTime end);
    List<MainDashRepoDto> findProfileForDash(LocalDateTime start, LocalDateTime end);

    List<MainDashRepoDto> findProfileByFullName(String fullName);

    List<MainDashRepoDto> findProfileByDeviceImei(String deviceImei);

    List<MainDashProfileDto> findProfileByPassportInn(String passportInn);

    List<DistinctCallProfileRepoDto> distinctCallProfile();

    Optional<ProfileDb> deleteProfileStatus(DeletedStatusDto deletedStatusDto);

    List<MainDashProfileDto> findProfileByFullNameByDeletedStatus(String fullName);

    List<MainDashProfileDto> findDeletedProfileByDate(LocalDateTime start, LocalDateTime end);

    List<ReportZeroPaymentDto> zeroPaymentProfile(ReportPaymentRequestDto reportPaymentRequestDto);
    List<ReportMonthPaymentDto> monthPaymentProfile(ReportPaymentRequestDto reportPaymentRequestDto);


}
