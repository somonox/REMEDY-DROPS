package hs.bssm.somonox.remedydrops.drops;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DropController {
    @GetMapping("/drops")
    public String getDrops() {
        return "Here are your remedy drops!";
    }
}
