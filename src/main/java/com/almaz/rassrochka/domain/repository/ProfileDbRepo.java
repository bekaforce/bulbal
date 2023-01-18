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

// old CallProfile
    @Query(value = "select p.id as profileId, mc.id as monthId, d.id as deviceId, p.full_name as fullName, p.phone, d.device_model as deviceModel, \n" +
            "d.device_price as devicePrice, d.zero_payment as zeroPayment,  mc.count_month as countMonth, mc.pay_date as payDate,  \n" +
            "mc.debt_report as debtReport, mc.payment_type as paymentType, mc.status_type as statusType, mc.\"comment\", p.salesman_login as salesmanLogin  \n" +
            "from public.profile p, public.device d, public.month_credit mc\n" +
            "where p.id = d.profile_id\n" +
            "and d.id =mc.device_id\n" +
            "and mc.status_type ='EXPIRED'\n" +
            "order by mc.pay_date, mc.count_month asc limit 500", nativeQuery = true)
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

    @Query(value = "select p.id as profileId, d.id as deviceId,  p.full_name as fullName, p.phone, d.device_model as deviceModel, \n" +
            "d.device_price as devicePrice, d.zero_payment as zeroPayment, d.payment_type as paymentType, d.status_type as statusType, p.registration_date as registrationDate, p.salesman_login as salesmanLogin \n" +
            "from public.profile p, public.device d\n" +
            "where p.id = d.profile_id and p.deleted is not true\n" +
            "and p.registration_date between :start and :end " +
            "order by p.registration_date desc", nativeQuery = true)
    List<MainDashRepoDto> dashBoardProfile(@Param("start") LocalDateTime start,
                                           @Param("end") LocalDateTime end);

    @Query(value = "SELECT * from public.profile where registration_date between :start and :end " +
            "order by id desc", nativeQuery = true)
    List<ProfileDb> findAllByRegistrationDateBetween(@Param("start") LocalDateTime start,
                                                     @Param("end") LocalDateTime end);

    @Query(value = "select p.id as profileId, d.id as deviceId,  p.full_name as fullName, p.phone, d.device_model as deviceModel, \n" +
            "d.device_price as devicePrice, d.status_type as statusType, p.registration_date as registrationDate, p.salesman_login as salesmanLogin \n" +
            "from public.profile p, public.device d\n" +
            "where p.id = d.profile_id\n" +
            "and p.deleted is not true\n" +
            "and p.full_name ILIKE %:fullName%\n" +
            "order by p.registration_date desc", nativeQuery = true)
    List<MainDashRepoDto> findByFullName(@Param("fullName") String fullName);

    @Query(value = "select p.id as profileId, d.id as deviceId,  p.full_name as fullName, p.phone, d.device_model as deviceModel,\n" +
            "d.device_price as devicePrice, d.zero_payment as zeroPayment, d.payment_type as paymentType, d.status_type as statusType, \n" +
            "p.registration_date as registrationDate, p.salesman_login as salesmanLogin\n" +
            "from public.profile p, public.device d\n" +
            "where p.id = d.profile_id\n" +
            "and d.device_imei ilike %:fullName%", nativeQuery = true)
    List<MainDashRepoDto> findByDeviceImei(@Param("fullName") String fullName);

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


    @Query(value = "select d.id as deviceId, p.full_name as fullName, d.zero_payment as zeroPayment, d.payment_type as paymentType, \n" +
            "p.registration_date as registrationDate, p.salesman_login as salesmanLogin  \n" +
            "from public.profile p, public.device d  \n" +
            "where p.id = d.profile_id\n" +
            "and d.profile_id = p.id\n" +
            "and p.registration_date between :start and :end " +
            "and d.payment_type in (:paymentTypeList)\n" +
            "and p.salesman_login in (:salesmanLoginList)\n" +
            "order by p.registration_date desc " +
            "limit 500", nativeQuery = true)
    List<ReportZeroPaymentDto> zeroPaymentProfile(@Param("start") LocalDateTime start,
                                                  @Param("end") LocalDateTime end,
                                                  @Param("paymentTypeList") List<String> paymentTypeList,
                                                  @Param("salesmanLoginList") List<String> salesmanLoginList);

    @Query(value = "select d.id as deviceId, p.full_name as fullName, r.count_month as countMonth,  r.debt_report as debtReport, \n" +
            "r.payment_type as paymentType, r.registration_date as registrationDate, r.salesman_login as salesmanLogin  \n" +
            "from public.report r, public.profile p, public.device d  \n" +
            "where p.id = d.profile_id \n" +
            "and r.device_id = d.id\n" +
            "and r.registration_date between :start and :end " +
            "and r.payment_type in (:paymentTypeList)\n" +
            "and r.salesman_login in (:salesmanLoginList)\n" +
            "order by r.registration_date desc\n" +
            "limit 500", nativeQuery = true)
    List<ReportMonthPaymentDto> monthPaymentProfile(@Param("start") LocalDateTime start,
                                                  @Param("end") LocalDateTime end,
                                                  @Param("paymentTypeList") List<String> paymentTypeList,
                                                  @Param("salesmanLoginList") List<String> salesmanLoginList);




}
