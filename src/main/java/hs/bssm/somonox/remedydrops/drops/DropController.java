package hs.bssm.somonox.remedydrops.drops;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DropController {
    @GetMapping("/drops")
    public String getDrops(@RequestParam(value = "name", defaultValue = "World") String name) {
        return "Here are your remedy drops!";
    }
}