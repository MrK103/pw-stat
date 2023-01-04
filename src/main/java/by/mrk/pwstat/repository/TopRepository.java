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

    @Query(value = "SELECT t from Top t where t.factionid =:id")
    List<Top> findAllByFactionId(@Param(value = "id") Integer id);
    @Query(value = "SELECT * from top t join klan k on t.factionid = k.id where k.name =:name", nativeQuery = true)
    List<Top> findAllByFactionName(@Param(value = "name") String name);

    @Query(value = "SELECT * from top t order by  t.pk_count desc LIMIT 20 ", nativeQuery = true)
    List<Top> findAllQ();

    @Query(value = "select * FROM top t where t.factionid =:factionid" , nativeQuery = true)
    List<Top> findAllById(@Param(value = "factionid") Integer id);
//    @Query(value = "SELECT * FROM top p ORDER BY p.rolelevel, p.pk_count desc LIMIT 20", nativeQuery = true)
//    List<Top> getTop20Users();
}
