package by.mrk.pwstat.repository;

import by.mrk.pwstat.entity.Donate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DonateRepository extends JpaRepository<Donate, Integer> {
    @Query(value = "SELECT d FROM Donate d join fetch d.userId u ORDER BY d.money desc ")
    List<Donate> getAllDonat();
}
