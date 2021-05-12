package services;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@ApplicationScoped
public class WorkoutGenerator {

    Random random = new Random();

    public String generateWorkout() {
        try {
            Thread.sleep(1500); // Simulate intensive work
        } catch (InterruptedException e) {
            System.out.println("interrupted!");
        }
        List<String> muscleGroups = new ArrayList<>();
        muscleGroups.add("Chest");
        muscleGroups.add("Back");
        muscleGroups.add("Shoulders");
        muscleGroups.add("Legs");
        muscleGroups.add("Biceps");
        muscleGroups.add("Triceps");
        int cnt = muscleGroups.size();

        int x = Math.abs(random.nextInt())%cnt;
        int y = Math.abs(random.nextInt())%cnt;
        if(x==y)x = (x+1)%cnt;

        return muscleGroups.get(x) + " and " + muscleGroups.get(y);
    }
}
