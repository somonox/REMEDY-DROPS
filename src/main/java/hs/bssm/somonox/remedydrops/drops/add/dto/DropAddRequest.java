package hs.bssm.somonox.remedydrops.drops.add.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import hs.bssm.somonox.remedydrops.drops.common.GeoPointDto;
import hs.bssm.somonox.remedydrops.drops.common.MusicSummaryDto;

import java.util.UUID;

public record DropAddRequest(
        @JsonProperty("user_id")
        UUID userId,
        @JsonProperty("music_id")
        UUID musicId,
        String content,
        @JsonProperty("coordinates")
        GeoPointDto coordinates
) {
    @Override
    public String toString() {
        return "DropAddRequest{" +
                "userId=" + userId +
                ", musicId=" + musicId +
                ", content='" + content + '\'' +
                ", coordinates=" + coordinates +
                '}';
    }
}
