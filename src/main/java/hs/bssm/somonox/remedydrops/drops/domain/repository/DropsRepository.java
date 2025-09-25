package hs.bssm.somonox.remedydrops.drops.domain.repository;

import hs.bssm.somonox.remedydrops.drops.domain.entity.Drops;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface DropsRepository extends JpaRepository<Drops, UUID> {

    @Query(value = """
        select d.*
        from drops d
        where ST_DWithin(
          d.coord::geography,
          ST_SetSRID(ST_MakePoint(:lng, :lat), 4326)::geography,
          :radiusMeters
        )
        order by ST_DistanceSphere(
          d.coord,
          ST_SetSRID(ST_MakePoint(:lng, :lat), 4326)
        )
        """, nativeQuery = true)
    List<Drops> findAllWithinRadius(
            @Param("lat") double lat,
            @Param("lng") double lng,
            @Param("radiusMeters") int radiusMeters
    );
}