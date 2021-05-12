package usecases;

import services.WorkoutGenerator;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@SessionScoped
@Named
public class Workout implements Serializable {

    @Inject
    WorkoutGenerator workoutGenerator;

    private CompletableFuture<String> workoutGenerationTask = null;

    public String generateNewWorkout() {
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();

        workoutGenerationTask = CompletableFuture.supplyAsync(() -> workoutGenerator.generateWorkout());

        return  "/index.xhtml?faces-redirect=true";
    }

    public boolean isWorkoutGenerationRunning() {
        return workoutGenerationTask != null && !workoutGenerationTask.isDone();
    }

    public String getWorkoutGenerationStatus() throws ExecutionException, InterruptedException {
        if (workoutGenerationTask == null) {
            return null;
        } else if (isWorkoutGenerationRunning()) {
            return "Workout generation in progress";
        }
        return "Suggested workout for today: " + workoutGenerationTask.get();
    }
}
