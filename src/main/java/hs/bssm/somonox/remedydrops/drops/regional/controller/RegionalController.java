package hs.bssm.somonox.remedydrops.drops.regional.controller;

import hs.bssm.somonox.remedydrops.drops.common.GeoPointDto;
import hs.bssm.somonox.remedydrops.drops.regional.dto.DropRegionalResponse;
import hs.bssm.somonox.remedydrops.drops.regional.service.RegionalService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@AllArgsConstructor
public class RegionalController {
    private final RegionalService regionalService;

    @GetMapping("/drops")
    public @ResponseBody DropRegionalResponse getDrops(@RequestParam double latitude, @RequestParam double longitude, @RequestParam int radius) {
        return regionalService.getRegionalDrops(new GeoPointDto(latitude, longitude), radius);
    }
}
