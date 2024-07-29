package org.sandopla.rockrest;

import org.sandopla.rockrest.repository.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ScoreDbController {

    @Autowired
    private final ScoreRepository scoreRepository;

    public ScoreDbController(ScoreRepository scoreRepository) {
        this.scoreRepository = scoreRepository;
    }

    @GetMapping
    public ResponseEntity getAllProducts() {
        return ResponseEntity.ok(scoreRepository.findAll());
    }


    @PostMapping(path="/add") // Map ONLY POST Requests
    public @ResponseBody String addNewScore (@RequestParam int wins, @RequestParam int losses, @RequestParam int ties) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        Score s = new Score();
        s.setWins(wins);
        s.setLosses(losses);
        s.setTies(ties);
        scoreRepository.save(s);
        return "Saved";
    }
}
