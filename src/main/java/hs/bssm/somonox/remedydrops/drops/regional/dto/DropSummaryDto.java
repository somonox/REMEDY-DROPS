package hs.bssm.somonox.remedydrops.drops.regional.dto;

import hs.bssm.somonox.remedydrops.drops.common.GeoPointDto;

import java.time.OffsetDateTime;
import java.util.UUID;

public record DropSummaryDto(
    UUID dropId,
    UUID userId,
    UUID musicId,
    String content,
    GeoPointDto coordinates,
    OffsetDateTime expiredAt
)
{}
