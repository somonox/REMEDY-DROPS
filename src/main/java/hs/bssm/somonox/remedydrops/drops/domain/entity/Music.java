package hs.bssm.somonox.remedydrops.drops.domain.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "music")
public class Music {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "music_id", unique = true, nullable = false)
    @EqualsAndHashCode.Include
    private UUID musicId;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "artist", nullable = false)
    private String artist;

    @Column(name = "album_img", nullable = false, columnDefinition = "text")
    private String albumImg;

    @Column(name = "duration_seconds", nullable = false)
    private int durationSeconds;

    protected Music(String title, String artist, String albumImg, Integer durationSeconds) {
        this.title = title;
        this.artist = artist;
        this.albumImg = albumImg;
        this.durationSeconds = durationSeconds;
    }
}
