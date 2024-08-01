package org.sandopla.rockrest;

import org.sandopla.rockrest.repository.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@RestController
@CrossOrigin(maxAge = 3600)
public class ScoreController {

    @Autowired
    ScoreRepository scoreRepository;
    private final int userId = 1;

    public ScoreController(ScoreRepository scoreRepository) {
        this.scoreRepository = scoreRepository;
        score = scoreRepository.findById(userId).get();
    }

    String item = "";

    static Score score = new Score(0,0, 0);

    @GetMapping("/getUser")
    public Optional<Score> getUser() {
        return scoreRepository.findById(1);
    }

    @GetMapping("/health-check")
    public String PublicGetHealth(){
        return "Balls maintained " + score.toString();
    }

    @GetMapping("/getItem")
    public String getItem(){
        List<String> rockPaperList = Arrays.asList("rock", "paper", "scissors");
        Random rand = new Random();
        item = rockPaperList.get(rand.nextInt(rockPaperList.size()));
        return item;
    }

    @PutMapping("/score")
    public Score replaceScore(@RequestBody Score newScore){
        //score = scoreRepository.findById(userId).get();
        //newScore.setId(score.getId());
        scoreRepository.save(newScore);
        return newScore;
    }


    @DeleteMapping("/score")
    public void deleteScore(){
        score = null;
    }

    @PatchMapping("/score/wins")
    public Score updateWins(@RequestParam(name="new-value")int newValue){
        score.wins = newValue;
        return score;
    }

    @PostMapping("/score/wins")
    public Score increaseWins(){
        score.wins++;
        scoreRepository.save(score);
        return score;
    }

    @PostMapping("/score/losses")
    public Score increaseLosses(){
        score.losses++;
        scoreRepository.save(score);
        return score;
    }

    @PostMapping("/score/ties")
    public Score increaseTies(){
        score.ties++;
        scoreRepository.save(score);
        return score;
    }

    @GetMapping("/score")
    public Score getScore(){
        return score;
    }

    @GetMapping("/score/{winslosserorties}")
    public int getWinslosserores(@PathVariable String winslosserorties) {
        if(winslosserorties.equals("wins")) {
            return score.getWins();
        }
        if(winslosserorties.equals("losses")) {
            return score.getLosses();
        }
        return score.getTies();
    }

}


//    @GetMapping("/score/wins")
//    public int getWins() {
//        return score.getWins();
//    }
//
//    @GetMapping("/score/losses")
//    public int getLosses() {
//        return score.getLosses();
//    }
//
//    @GetMapping("/score/ties")
//    public int getTies() {
//        return score.getTies();
//    }