package src.Help.LawnMower;

import src.Model.StageCharacter.StageCharacter;

import java.io.Serializable;

public class StageLawnMower implements StageCharacter, Serializable {
// Variables
    private LawnMower lawnMower;
// Constructors
    public StageLawnMower() {
        super();
    }
    public StageLawnMower(LawnMower lawnMower) {
        super();
        this.lawnMower = lawnMower;
    }
// Methods
    @Override
    public void start() {
        lawnMower.getActLawnMower().start();
    }

    @Override
    public void stop() {
        if (lawnMower.getTimeline() != null) {
            lawnMower.getTimeline().stop();
        }
    }

    @Override
    public void pause() {
        if (lawnMower.getTimeline() != null) {
            lawnMower.getTimeline().pause();
        }
    }

    @Override
    public void resume() {
        if (lawnMower.getTimeline() != null) {
            lawnMower.getTimeline().play();
        }
    }

// Getters and Setters
    public LawnMower getLawnMower() {
        return lawnMower;
    }

    public void setLawnMower(LawnMower lawnMower) {
        this.lawnMower = lawnMower;
    }
}
