package hs.bssm.somonox.remedydrops.drops.detail.dto;

import hs.bssm.somonox.remedydrops.drops.common.GeoPointDto;
import hs.bssm.somonox.remedydrops.drops.common.MusicSummaryDto;
import hs.bssm.somonox.remedydrops.drops.common.UserSummaryDto;
import hs.bssm.somonox.remedydrops.drops.domain.entity.Drops;
import hs.bssm.somonox.remedydrops.drops.domain.entity.Music;
import hs.bssm.somonox.remedydrops.drops.domain.entity.Users;
import org.locationtech.jts.geom.Point;

public class DropDtoMapper {
    public static DropDetailResponse toDropDetailResponse(Drops drops) {
        return new DropDetailResponse(
            drops.getDropId(),
            toUserSummaryDto(drops.getUsers()),
            toMusicSummaryDto(drops.getMusic()),
            drops.getContent(),
            toGeoPointDto(drops.getCoord()),
            drops.getExpiresAt()
        );
    }

    public static MusicSummaryDto toMusicSummaryDto(Music music) {
        return new MusicSummaryDto(
            music.getMusicId(),
            music.getTitle(),
            music.getArtist(),
            music.getAlbumImg(),
            music.getDurationSeconds()
        );
    }

    public static UserSummaryDto toUserSummaryDto(Users user) {
        return new UserSummaryDto(
            user.getUserId(),
            user.getUsername()
        );
    }

    public static GeoPointDto toGeoPointDto(Point geoPoint) {
        return new GeoPointDto(
            geoPoint.getY(),
            geoPoint.getX()
        );
    }
}
