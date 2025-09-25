package hs.bssm.somonox.remedydrops.drops.detail.controller;

import hs.bssm.somonox.remedydrops.drops.detail.dto.DropDetailResponse;
import hs.bssm.somonox.remedydrops.drops.detail.service.DetailService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class DetailController {
    private final DetailService detailService;

    @GetMapping("/drops/detail")
    public @ResponseBody DropDetailResponse detail(@RequestParam(value = "drop_id") UUID dropId) {
        return detailService.getDetail(dropId);
    }
}
