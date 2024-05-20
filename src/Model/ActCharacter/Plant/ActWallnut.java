package src.Model.ActCharacter.Plant;

import src.Config.Path;
import src.Model.ActCharacter.Act;
import src.Model.Characters.Plants.Plant;
import src.Model.Characters.Plants.Wallnut.Wallnut;

public class ActWallnut implements Act {
    // Var
    private Plant wallnut;
    // Constructor
    public ActWallnut(Wallnut wallnut) {
        this.wallnut = wallnut;
    }
    @Override
    public void move() {

    }

    @Override
    public void attack(Object object) {

    }

    @Override
    public void handle() {
        if (wallnut.getHp() > 2667 && wallnut.getPath() != Path.ASSETS_Image_Wallnut) {

            wallnut.setPath(Path.ASSETS_Image_Wallnut);
            wallnut.changeImageView(Path.ASSETS_Image_Wallnut);

        } else if (wallnut.getHp() <= 2667 && wallnut.getHp() > 1334
                && wallnut.getPath() != Path.ASSETS_Image_WallNut2)
            {
                wallnut.setPath(Path.ASSETS_Image_WallNut2);
                wallnut.changeImageView(Path.ASSETS_Image_WallNut2);

        } else if (wallnut.getHp() <= 1334 && wallnut.getHp() > 0
                && wallnut.getPath() != Path.ASSETS_Image_WallNut3)
            {
                wallnut.setPath(Path.ASSETS_Image_WallNut3);
                wallnut.changeImageView(Path.ASSETS_Image_WallNut3);
        }
    }
}
