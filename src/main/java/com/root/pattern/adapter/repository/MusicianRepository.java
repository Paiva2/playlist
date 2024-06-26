package com.root.pattern.adapter.repository;

import com.root.pattern.domain.entity.Musician;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MusicianRepository extends JpaRepository<Musician, Long> {

    @Query("SELECT m FROM Musician m WHERE m.email = :email OR m.name = :name")
    Optional<Musician> findByEmailOrName(@Param("email") String email, @Param("name") String name);

    @Query("SELECT m FROM Musician m WHERE m.email = :email")
    Optional<Musician> findByEmail(@Param("email") String email);

    @Query("SELECT ms FROM Musician ms " +
        "LEFT JOIN FETCH ms.albums alb " +
        "WHERE LOWER(ms.name) = LOWER(:name)")
    Optional<Musician> findByName(@Param("name") String name);
}
