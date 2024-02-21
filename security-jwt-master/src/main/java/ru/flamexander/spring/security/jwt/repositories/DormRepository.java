package ru.flamexander.spring.security.jwt.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import ru.flamexander.spring.security.jwt.entities.Dorm;

import java.util.List;

public interface DormRepository extends JpaRepository<Dorm, Long> {


    @Query("SELECT d FROM Dorm d WHERE " +
            "d.name LIKE CONCAT('%',:query, '%')" +
            "Or d.description LIKE CONCAT('%', :query, '%')")
    List<Dorm> searchDorms(String query);

    @Modifying
    @Query("UPDATE Dorm SET  name = :name where id = :id")
    void changeLastName(Integer id, String name);


}

