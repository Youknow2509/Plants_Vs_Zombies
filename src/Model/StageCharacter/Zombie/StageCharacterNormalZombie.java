package src.Model.StageCharacter.Zombie;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;
import src.Model.Characters.Zombies.Normal.NormalZombie;
import src.Model.StageCharacter.StageCharacter;

public class StageCharacterNormalZombie implements StageCharacter {
    private NormalZombie normalZombie;
    // Constructor
    public StageCharacterNormalZombie(NormalZombie normalZombie) {
        this.normalZombie = normalZombie;
    }
    @Override
    public void start() {
        helpStart();
        // TimeLine xử lí sự kiện, mỗi SpeedAttack seconds giây thì sự kiện xảy ra ( handle() - Di chuyển hoặc tấn công tuỳ theo vị trí Zombie)
        normalZombie.setTimeline(new Timeline(new KeyFrame(Duration.seconds(normalZombie.getSpeedAttack()),
                e -> {
                    normalZombie.getAct().handle();
                }
        )));
        normalZombie.getTimeline().setCycleCount(Timeline.INDEFINITE);
        normalZombie.getTimeline().play();
    }

    @Override
    public void stop() {
        if (normalZombie.getTimeline() != null) {
            normalZombie.getTimeline().stop();
        }
    }

    @Override
    public void pause() {
        if (normalZombie.getTimeline() != null) {
            normalZombie.getTimeline().pause();
        }
    }

    @Override
    public void resume() {
        if (normalZombie.getTimeline() != null) {
            helpStart();
            normalZombie.getTimeline().play();
        }
    }

    // Help start
    private void helpStart() {
        normalZombie.createImageView();
    }
}
