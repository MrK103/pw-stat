package by.mrk.pwstat.repository;

import by.mrk.pwstat.entity.Clan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ClanRepository extends JpaRepository<Clan, Integer> {
    @Query(value = "SELECT count (u.id) FROM Clan u")
    Integer getAllCount();

    @Query(value = "SELECT * FROM klan k  ORDER BY k.level desc LIMIT 10", nativeQuery = true)
    List<Clan> getTopTenClans();

    @Query(value = "SELECT u.name FROM Clan u WHERE u.id = :id")
    String getClanNameById(@Param("id") Integer id);
}
