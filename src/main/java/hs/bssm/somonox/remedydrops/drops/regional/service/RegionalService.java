package hs.bssm.somonox.remedydrops.drops.regional.service;

import hs.bssm.somonox.remedydrops.drops.common.GeoPointDto;
import hs.bssm.somonox.remedydrops.drops.domain.entity.Drops;
import hs.bssm.somonox.remedydrops.drops.domain.repository.DropsRepository;
import hs.bssm.somonox.remedydrops.drops.regional.dto.DropRegionalResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegionalService {
    private final DropsRepository dropsRepository;

    public RegionalService(DropsRepository dropsRepository) {
        this.dropsRepository = dropsRepository;
    }

    public DropRegionalResponse getRegionalDrops(GeoPointDto point, int radius) {
        double lat = point.latitude();
        double lng = point.longitude();
        List<Drops> drops = dropsRepository.findAllWithinRadius(lat, lng, radius);

        return DropRegionalResponse.fromEntities(drops);
    }
}
