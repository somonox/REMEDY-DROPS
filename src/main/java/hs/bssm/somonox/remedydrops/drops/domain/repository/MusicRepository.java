package hs.bssm.somonox.remedydrops.drops.domain.repository;

import hs.bssm.somonox.remedydrops.drops.domain.entity.Music;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MusicRepository extends JpaRepository<Music, UUID> {
}
