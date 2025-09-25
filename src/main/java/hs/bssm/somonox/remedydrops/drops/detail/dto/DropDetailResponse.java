package hs.bssm.somonox.remedydrops.drops.detail.dto;

import hs.bssm.somonox.remedydrops.drops.common.GeoPointDto;
import hs.bssm.somonox.remedydrops.drops.common.MusicSummaryDto;
import hs.bssm.somonox.remedydrops.drops.common.UserSummaryDto;

import java.time.OffsetDateTime;
import java.util.UUID;

public record DropDetailResponse(
        UUID dropId,
        UserSummaryDto user,
        MusicSummaryDto music,
        String content,
        GeoPointDto coordinates,
        OffsetDateTime expiresAt
)
{}
