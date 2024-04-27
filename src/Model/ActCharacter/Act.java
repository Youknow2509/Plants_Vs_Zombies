package src.Model.ActCharacter;

import java.io.Serializable;

public interface Act extends Serializable {
    void move();

    void attack(Object object);

    void handle();
}
