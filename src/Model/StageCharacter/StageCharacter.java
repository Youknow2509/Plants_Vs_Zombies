package src.Model.StageCharacter;

import java.io.Serializable;

public interface  StageCharacter extends Serializable {
    void start();
    void stop();
    void pause();
    void resume();
}
