package hs.bssm.somonox.remedydrops.drops.common;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public record MusicSummaryDto(
        @JsonProperty("music_id")
        UUID musicId,
        String title,
        String artist,
        @JsonProperty("album_img")
        String albumImg,
        @JsonProperty("duration_seconds")
        int durationSeconds
) {}
