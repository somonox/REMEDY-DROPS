package hs.bssm.somonox.remedydrops.drops.domain.repository;

import hs.bssm.somonox.remedydrops.drops.domain.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UsersRepository extends JpaRepository<Users, UUID> {
}
