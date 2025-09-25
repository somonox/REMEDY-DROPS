package hs.bssm.somonox.remedydrops.drops.common;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public record UserSummaryDto(
        @JsonProperty("user_id")
        UUID userId,
        String username
) {}
