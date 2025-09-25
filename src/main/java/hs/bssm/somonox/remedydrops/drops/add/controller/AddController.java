package hs.bssm.somonox.remedydrops.drops.add.controller;

import hs.bssm.somonox.remedydrops.drops.add.dto.DropAddRequest;
import hs.bssm.somonox.remedydrops.drops.add.dto.DropAddResponse;
import hs.bssm.somonox.remedydrops.drops.add.service.AddService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AddController {
    private final AddService addService;

    @PostMapping("/drops")
    public @ResponseBody DropAddResponse addDrop(@RequestBody DropAddRequest dropAddRequest) {
        return addService.addDrop(dropAddRequest);
    }
}
