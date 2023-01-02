package by.mrk.pwstat.repository;

import by.mrk.pwstat.entity.Top;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TopRepository extends JpaRepository<Top, Integer> {
    @Query(value = "SELECT p.rolegender FROM Top p")
    List<Integer> getGenderList();

    @Query(value = "SELECT * FROM top p ORDER BY p.rolelevel, p.pk_count desc LIMIT 20", nativeQuery = true)
    List<Top> getTop20Users();
}
