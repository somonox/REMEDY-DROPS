package hs.bssm.somonox.remedydrops.drops.domain.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import org.locationtech.jts.geom.Point;

import java.time.OffsetDateTime;
import java.util.Objects;
import java.util.UUID;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(
        name = "drops",
        indexes = {
                @Index(name = "ix_drops_expires_at", columnList = "expires_at")
        }
)
public class Drops {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "drop_id", unique = true, nullable = false)
    @EqualsAndHashCode.Include
    private UUID dropId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false, foreignKey = @ForeignKey(name = "fk_drops_users"))
    private Users users;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "music_id", nullable = false, foreignKey = @ForeignKey(name = "fk_drops_music"))
    private Music music;

    @Column(name = "content", nullable = false, length = 2000)
    private String content;

    @JdbcTypeCode(SqlTypes.GEOMETRY)
    @Column(name = "coord", columnDefinition = "geometry(Point,4326)", nullable = false)
    private Point coord;

    @Column(name = "expires_at", columnDefinition = "timestamptz", nullable = false)
    private OffsetDateTime expiresAt;

    public Drops(Users users, Music music, String content, Point coord, OffsetDateTime expiresAt) {
        if (content == null || content.isBlank()) throw new IllegalArgumentException("content must not be blank");
        this.users = Objects.requireNonNull(users, "user");
        this.music = Objects.requireNonNull(music, "music");
        this.coord = Objects.requireNonNull(coord, "coord");
        this.expiresAt = Objects.requireNonNull(expiresAt, "expiresAt");
        this.content = content;
    }
}
