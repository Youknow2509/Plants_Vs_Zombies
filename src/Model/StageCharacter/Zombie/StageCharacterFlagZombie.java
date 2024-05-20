package src.Model.StageCharacter.Zombie;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;
import src.Model.Characters.Zombies.FlagZombie.FlagZombie;
import src.Model.StageCharacter.StageCharacter;

public class StageCharacterFlagZombie implements StageCharacter {
    private FlagZombie flagZombie;
    // Constructor
    public StageCharacterFlagZombie(FlagZombie flagZombie) {
        this.flagZombie = flagZombie;
    }
    @Override
    public void start() {
        helpStart();
        // TimeLine xử lí sự kiện, mỗi SpeedAttack seconds giây thì sự kiện xảy ra ( handle() - Di chuyển hoặc tấn công tuỳ theo vị trí Zombie)
        flagZombie.setTimeline(new Timeline(new KeyFrame(Duration.seconds(flagZombie.getSpeedAttack()),
                e -> {
                    flagZombie.getAct().handle();
                }
        )));
        flagZombie.getTimeline().setCycleCount(Timeline.INDEFINITE);
        flagZombie.getTimeline().play();
    }

    @Override
    public void stop() {
        if (flagZombie.getTimeline() != null) {
            flagZombie.getTimeline().stop();
        }
    }

    @Override
    public void pause() {
        if (flagZombie.getTimeline() != null) {
            flagZombie.getTimeline().pause();
        }
    }

    @Override
    public void resume() {
        if (flagZombie.getTimeline() != null) {
            helpStart();
            flagZombie.getTimeline().play();
        }
    }

    // Help start
    private void helpStart() {
        flagZombie.createImageView();
    }
}
