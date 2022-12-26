package com.almaz.rassrochka.domain.repository;

import com.almaz.rassrochka.domain.ProfileDb;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
@Repository
public interface ProfileDbRepo extends JpaRepository<ProfileDb, Long> {
    List<ProfileDb> findByFullNameIgnoreCaseContaining (String fullName);

    List<ProfileDb> findByPassportInnIgnoreCaseContaining (String passportInn);

// old CallProfile
    @Query(value = "SELECT p.id, p.full_name as fullName, p.phone as phone, d.device_model as deviceModel, d.device_price as devicePrice, " +
            "c.zero_payment as zeroPayment, mc.credit_id as creditId, mc.id as mcId, mc.count_month as countMonth, mc.debt as debt, mc.pay_date as payDate, " +
            "mc.status_type as StatusType, mc.\"comment\", c.salesman_login as salesmanLogin " +
            "FROM public.profile p, public.device d, public.credit c, public.month_credit mc " +
            "where p.id=d.profile_id " +
            "and c.device_id=d.id " +
            "and mc.credit_id=c.id " +
            "and mc.status_type ='EXPIRED' " +
            "order by mc.credit_id, mc.count_month asc", nativeQuery = true)
    List<CallProfileDto> findCallProfile();

    @Query(value = "SELECT p.id, mc.credit_id as creditId, p.full_name as fullName, p.phone as phone, d.device_model as deviceModel, d.device_price as devicePrice, \n" +
            "            c.zero_payment as zeroPayment\n" +
            "            FROM public.profile p, public.device d, public.credit c, public.month_credit mc\n" +
            "            where p.id=d.profile_id\n" +
            "            and c.device_id=d.id\n" +
            "            and mc.credit_id=c.id and p.deleted is not true " +
            "and mc.status_type ='EXPIRED'\n" +
            "            group by p.id, mc.credit_id, p.full_name, p.phone, d.device_model, d.device_price, c.zero_payment   \n" +
            "            order by mc.credit_id asc", nativeQuery = true)
    List<DistinctCallProfileRepoDto> distinctCallProfile();

    @Query(value = "select p.id, p.full_name as fullName, p.passport_inn as passportInn, d.device_imei as deviceImei, " +
            "c.status_type as statusType, c.registration_date as registrationDate, c.salesman_login as salesmanLogin  \n" +
            "from public.profile p, public.credit c, public.device d \n" +
            "where p.id=d.profile_id and p.deleted is not true and c.device_id=d.id\n" +
            "and c.registration_date between :start and :end " +
            "order by c.registration_date desc", nativeQuery = true)
    List<MainDashRepoDto> dashBoardProfile(@Param("start") LocalDateTime start,
                                           @Param("end") LocalDateTime end);

    @Query(value = "SELECT * from public.profile where registration_date between :start and :end " +
            "order by id desc", nativeQuery = true)
    List<ProfileDb> findAllByRegistrationDateBetween(@Param("start") LocalDateTime start,
                                                     @Param("end") LocalDateTime end);

    @Query(value = "select p.id, p.full_name as fullName, p.passport_inn as passportInn, d.device_imei as deviceImei, " +
            "c.status_type as statusType, c.registration_date as registrationDate, c.salesman_login as salesmanLogin  \n" +
            "from public.profile p, public.credit c, public.device d \n" +
            "where p.id=d.profile_id and p.deleted is not true " +
            "and c.device_id=d.id\n" +
            "and p.full_name ILIKE %:fullName% " +
            "order by c.registration_date desc", nativeQuery = true)
    List<MainDashRepoDto> findByFullName(@Param("fullName") String fullName);

    @Query(value = "select p.id, p.full_name as fullName, p.passport_inn as passportInn, d.device_imei as deviceImei, " +
            "c.status_type as statusType, c.registration_date as registrationDate, c.salesman_login as salesmanLogin  \n" +
            "from public.profile p, public.credit c, public.device d \n" +
            "where p.id=d.profile_id " +
            "and p.deleted is not true " +
            "and c.device_id=d.id\n" +
            "and d.device_imei ILIKE %:deviceImei% " +
            "order by c.registration_date desc", nativeQuery = true)
    List<MainDashRepoDto> findByDeviceImei(@Param("deviceImei") String deviceImei);

    @Query(value = "select p.id, p.full_name as fullName, p.passport_inn as passportInn, d.device_imei as deviceImei, " +
            "c.status_type as statusType, c.registration_date as registrationDate, c.salesman_login as salesmanLogin  \n" +
            "from public.profile p, public.credit c, public.device d \n" +
            "where p.id=d.profile_id and p.deleted is not true and c.device_id=d.id\n" +
            "and p.passport_inn ILIKE %:passportInn% " +
            "order by c.registration_date desc", nativeQuery = true)
    List<MainDashRepoDto> findByPassportInnDto(@Param("passportInn") String passportInn);

    @Query(value = "select p.id, p.full_name as fullName, p.passport_inn as passportInn, d.device_imei as deviceImei, " +
            "c.status_type as statusType, c.registration_date as registrationDate, c.salesman_login as salesmanLogin  \n" +
            "from public.profile p, public.credit c, public.device d \n" +
            "where p.id=d.profile_id and p.deleted is true " +
            "and c.device_id=d.id\n" +
            "and p.full_name ILIKE %:fullName% " +
            "order by c.registration_date desc", nativeQuery = true)
    List<MainDashRepoDto> findByFullNameByDeletedStatus(@Param("fullName") String fullName);

    @Query(value = "select p.id, p.full_name as fullName, p.passport_inn as passportInn, d.device_imei as deviceImei, " +
            "c.status_type as statusType, c.registration_date as registrationDate, c.salesman_login as salesmanLogin  \n" +
            "from public.profile p, public.credit c, public.device d \n" +
            "where p.id=d.profile_id and p.deleted is true " +
            "and c.device_id=d.id\n" +
            "and c.registration_date between :start and :end " +
            "order by c.registration_date desc", nativeQuery = true)
    List<MainDashRepoDto> dashBoardProfileDeleteByDate (@Param("start") LocalDateTime start,
                                                        @Param("end") LocalDateTime end);

}
