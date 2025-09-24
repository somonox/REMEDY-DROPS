package hs.bssm.somonox.remedydrops.drops.domain.repository;

import hs.bssm.somonox.remedydrops.drops.domain.entity.Drops;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DropsRepository extends JpaRepository<Drops, UUID> {

}
