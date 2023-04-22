package com.almaz.bulbal.repository.main;

import com.almaz.bulbal.model.main.Accommodation;
import com.almaz.bulbal.security.dto.GetUserDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface AccommodationRepo extends JpaRepository<Accommodation, Long> {
    Accommodation findAccommodationById(Long id);

    @Query(value = "SELECT x.id, x.region, x.locality_name as localityName, x.title_of_accommodation as titleOfAccommodation, x.price, i.file_name as imageFullName, " +
            "x.create_date as createDate " +
            "FROM public.accommodation x, public.image i " +
            "where i.accommodation_id = x.id " +
            "and i.main is true " +
            "and x.status = 'Опубликовано' " +
            "order by x.create_date desc",
            nativeQuery = true)
    Page<MainPageDto> getMainPage(PageRequest pageRequest);

    @Query(value = "SELECT x.id, x.region, x.locality_name as localityName, x.title_of_accommodation as titleOfAccommodation, x.price, i.file_name as imageFullName, " +
            "x.create_date as createDate " +
            "FROM public.accommodation x, public.image i \n" +
            "where i.accommodation_id = x.id \n" +
            "and i.main is true " +
            "and x.id =:accommodationId " +
            "order by x.create_date desc",
            nativeQuery = true)
    MainPageDto getPreview(@Param(value = "accommodationId") Long accommodationId);


    @Query(value = "SELECT x.id, x.region, x.locality_name as localityName, x.title_of_accommodation as titleOfAccomondation, x.price, i.file_name as imageFullName, " +
            "x.create_date as createDate " +
            "FROM public.accommodation x, public.image i " +
            "where i.accommodation_id = x.id " +
            "and i.main is true " +
            "and x.id not in (SELECT b.accommodation_id " +
            "FROM booking b " +
            "WHERE b.check_in < :checkOutDateTime AND b.check_out > :checkInDateTime) " +
            "and x.region = :region " +
            "and x.status = 'Опубликовано' " +
            "order by x.create_date desc", nativeQuery = true)
    Page<MainPageDto> searchAccommodations(PageRequest pageRequest, @Param(value = "checkInDateTime") LocalDateTime checkInDateTime, @Param(value = "checkOutDateTime") LocalDateTime checkOutDateTime, @Param(value = "region") String region);
}
