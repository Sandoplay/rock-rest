package org.sandopla.rockrest;

import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

@RestController
@CrossOrigin(maxAge = 3600)
public class ScoreController {

    String item = "";

    static Score score = new Score(30,20, 10);
    @GetMapping("/health-check")
    public String PublicGetHealth(){
        return "Balls maintained";
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
        score = newScore;
        return score;
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
        return score;
    }

    @PostMapping("/score/losses")
    public Score increaseLosses(){
        score.losses++;
        return score;
    }

    @PostMapping("/score/ties")
    public Score increaseTies(){
        score.ties++;
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