package hs.bssm.somonox.remedydrops.drops.regional.dto;

import hs.bssm.somonox.remedydrops.drops.common.GeoPointDto;
import hs.bssm.somonox.remedydrops.drops.domain.entity.Drops;

import java.util.List;

public record DropRegionalResponse(
        List<DropSummaryDto> drops
)
{
    public static DropRegionalResponse fromEntities(List<Drops> drops) {
        List<DropSummaryDto> dropSummaries = drops.stream()
                .map(drop -> new DropSummaryDto(
                        drop.getDropId(),
                        drop.getUsers().getUserId(),
                        drop.getMusic().getMusicId(),
                        drop.getContent(),
                        new GeoPointDto(drop.getCoord().getY(), drop.getCoord().getX()),
                        drop.getExpiresAt()
                ))
                .toList();
        return new DropRegionalResponse(dropSummaries);
    }
}
