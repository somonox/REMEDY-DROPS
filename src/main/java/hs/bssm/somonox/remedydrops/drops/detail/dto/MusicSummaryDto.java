package hs.bssm.somonox.remedydrops.drops.detail.dto;

import java.util.UUID;

public record MusicSummaryDto(
        UUID musicId,
        String title,
        String artist,
        String albumImg,
        int durationSeconds
) {}
