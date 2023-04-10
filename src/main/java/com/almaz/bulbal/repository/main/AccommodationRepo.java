package com.almaz.bulbal.repository.main;

import com.almaz.bulbal.model.main.Accommodation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccommodationRepo extends JpaRepository<Accommodation, Long> {
    Accommodation findAccommodationById(Long id);

    @Query(value = "SELECT x.id, x.region, x.locality_name as localityName, x.title_of_accommodation as titleOfAccomondation, x.price, i.file_name as imageFullName, " +
            "x.create_date as createDate " +
            "FROM public.accommodation x, public.image i \n" +
            "where i.accommodation_id = x.id \n" +
            "and i.main is true \n" +
            "order by x.create_date desc",
            nativeQuery = true)
    Page<MainPageDto> getMainPage(PageRequest pageRequest);
}
