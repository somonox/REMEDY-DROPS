package hs.bssm.somonox.remedydrops.drops.add.service;

import hs.bssm.somonox.remedydrops.drops.add.dto.DropAddRequest;
import hs.bssm.somonox.remedydrops.drops.add.dto.DropAddResponse;
import hs.bssm.somonox.remedydrops.drops.domain.entity.Drops;
import hs.bssm.somonox.remedydrops.drops.domain.repository.DropsRepository;
import hs.bssm.somonox.remedydrops.drops.domain.repository.MusicRepository;
import hs.bssm.somonox.remedydrops.drops.domain.repository.UsersRepository;
import hs.bssm.somonox.remedydrops.drops.exceptions.DropNotFoundException;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.Point;
import org.postgresql.util.PSQLException;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.time.ZoneId;

@Service
public class AddService {
    private final DropsRepository dropsRepository;
    private final UsersRepository usersRepository;
    private final MusicRepository musicRepository;
    private final GeometryFactory geometryFactory;

    public AddService(DropsRepository dropsRepository, UsersRepository usersRepository, MusicRepository musicRepository, GeometryFactory geometryFactory) {
        this.musicRepository = musicRepository;
        this.dropsRepository = dropsRepository;
        this.usersRepository = usersRepository;
        this.geometryFactory = geometryFactory;
    }

    public DropAddResponse addDrop(DropAddRequest dropAddRequest) {
        Drops drops = new Drops(
            usersRepository.getReferenceById(dropAddRequest.userId()),
            musicRepository.getReferenceById(dropAddRequest.musicId()),
            dropAddRequest.content(),
            toPoint(dropAddRequest.coordinates().latitude(), dropAddRequest.coordinates().longitude()),
            OffsetDateTime.now(ZoneId.systemDefault()).plusDays(3)
        );
        drops = dropsRepository.save(drops);

        return new DropAddResponse(drops.getDropId());
    }

    private Point toPoint(double lat, double lng) {
        Point p = geometryFactory.createPoint(new Coordinate(lng, lat)); // x=lng, y=lat
        p.setSRID(4326);
        return p;
    }
}
