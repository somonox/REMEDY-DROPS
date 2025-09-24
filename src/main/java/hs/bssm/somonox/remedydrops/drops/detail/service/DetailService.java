package hs.bssm.somonox.remedydrops.drops.detail.service;

import hs.bssm.somonox.remedydrops.drops.detail.dto.DropDetailResponse;
import hs.bssm.somonox.remedydrops.drops.detail.dto.DropDtoMapper;
import hs.bssm.somonox.remedydrops.drops.domain.entity.Drops;
import hs.bssm.somonox.remedydrops.drops.domain.repository.DropsRepository;
import hs.bssm.somonox.remedydrops.drops.exceptions.DropNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class DetailService {
    private final DropsRepository dropsRepository;

    // Repository constructor injecting
    public DetailService(DropsRepository dropsRepository) {
        this.dropsRepository = dropsRepository;
    }

    public DropDetailResponse getDetail(UUID dropId) throws DropNotFoundException {
        Drops drops = dropsRepository.getReferenceById(dropId);
        DropDetailResponse dropDetailResponse;
        try {
            dropDetailResponse = DropDtoMapper.toDropDetailResponse(drops);
        } catch (EntityNotFoundException e) {
            throw new DropNotFoundException(dropId);
        }

        return dropDetailResponse;
    }
}
