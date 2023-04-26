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
            "FROM public.accommodation x, public.image i " +
            "where i.accommodation_id = x.id " +
            "and i.main is true " +
            "and x.status =:type and x.create_date between :start and :end " +
            "order by x.create_date desc",
            nativeQuery = true)
    List<MainPageDto> getAdminMainPage(@Param("start") LocalDateTime start,
                                       @Param("end") LocalDateTime end,
                                       @Param("type") String type);

    @Query(value = "SELECT x.id, x.region, x.locality_name as localityName, x.title_of_accommodation as titleOfAccommodation, x.price, i.file_name as imageFullName, " +
            "x.create_date as createDate " +
            "FROM public.accommodation x, public.image i \n" +
            "where i.accommodation_id = x.id \n" +
            "and i.main is true " +
            "and x.id =:accommodationId " +
            "order by x.create_date desc",
            nativeQuery = true)
    MainPageDto getPreview(@Param(value = "accommodationId") Long accommodationId);


    @Query(value = "SELECT x.id, x.region, x.locality_name as localityName, x.title_of_accommodation as titleOfAccommodation, x.price as price, i.file_name as imageFullName, " +
            "x.create_date as createDate " +
            "FROM public.accommodation x, public.image i " +
            "where i.accommodation_id = x.id " +
            "and i.main is true " +
            "and x.id not in (SELECT b.accommodation_id " +
            "FROM booking b " +
            "WHERE b.check_in < :checkOutDateTime AND b.check_out > :checkInDateTime) " +
            "and x.id not in (select b2.accommodation_id " +
            "from bed b2 " +
            "where b2.accommodation_id = x.id  " +
            "group by b2.accommodation_id " +
            "having sum(b2.size) < :capacity) " +
            "and x.locality_name  = :locality " +
            "and x.status = 'Опубликовано' " +
            "order by x.create_date desc", nativeQuery = true)
    Page<MainPageDto> searchAccommodations(PageRequest pageRequest, @Param(value = "checkInDateTime") LocalDateTime checkInDateTime, @Param(value = "checkOutDateTime") LocalDateTime checkOutDateTime, @Param(value = "locality") String locality, @Param(value = "capacity") Long capacity);

    @Query(value = "SELECT r.id AS id, r.region, r.locality_name as localityName, r.title_of_accommodation as titleOfAccommodation, r.price_per_bed as price, i.file_name as imageFullName, r.create_date as createDate " +
            "FROM bed b " +
            "JOIN public.accommodation r ON r.id = b.accommodation_id " +
            "join public.image i on i.accommodation_id = r.id " +
            "WHERE NOT EXISTS (" +
            "  SELECT 1 " +
            "  FROM booking bk " +
            "  WHERE bk.bed_id = b.id " +
            "    AND bk.check_in < :checkOutDateTime AND bk.check_out  > :checkInDateTime " +
            "    having b.size > :capacity) " +
            "AND NOT EXISTS (" +
            "  SELECT 1 " +
            "  FROM booking bk " +
            "  WHERE bk.accommodation_id  = r.id " +
            "  AND bk.check_in  < :checkOutDateTime AND bk.check_out  > :checkInDateTime) " +
            "and r.locality_name = :locality " +
            "and r.status = 'Опубликовано' " +
            "order by r.create_date desc", nativeQuery = true)
    Page<MainPageDto> searchBeds(PageRequest pageRequest, @Param(value = "checkInDateTime") LocalDateTime checkInDateTime, @Param(value = "checkOutDateTime") LocalDateTime checkOutDateTime, @Param(value = "locality") String locality, @Param(value = "capacity") Long capacity);
}
