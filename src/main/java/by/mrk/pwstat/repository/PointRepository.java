package by.mrk.pwstat.repository;

import by.mrk.pwstat.entity.Point;
import by.mrk.pwstat.entity.id.PointId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PointRepository extends JpaRepository<Point, PointId> {

    @Query(value = "SELECT count(p.zoneId) FROM Point p WHERE p.zoneId = :id")
    Integer online(@Param("id")Integer id);

    @Query(value = "SELECT p.zoneId FROM Point p WHERE p.pointId = :pointId")
    Integer onlineByUserId(@Param("pointId")PointId pointId);
}
