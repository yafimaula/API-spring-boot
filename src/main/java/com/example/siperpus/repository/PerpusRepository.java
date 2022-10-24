package com.example.siperpus.repository;

import com.example.siperpus.model.PerpusModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface PerpusRepository extends JpaRepository<PerpusModel, Long> {
    @Modifying
    @Query(value = "update ref_buku set is_deleted = :flag where id = :id", nativeQuery = true)
    void deleteOne(@Param("flag") boolean flagDeleted, @Param("id") Long id);
}
