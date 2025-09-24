package hs.bssm.somonox.remedydrops.drops.detail.dto;

import java.time.OffsetDateTime;
import java.util.UUID;

public record DropDetailResponse(
        UUID dropId,
        UserSummaryDto user,
        MusicSummaryDto music,
        String content,
        double latitude,
        double longitude,
        OffsetDateTime expiresAt
)
{}
