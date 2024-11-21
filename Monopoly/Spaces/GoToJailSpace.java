package Monopoly.Spaces;

import Monopoly.Main.*;

public class GoToJailSpace extends Space {
    public GoToJailSpace(String name) {
        super(name);
    }

    @Override
    public void landOn(Player player) {
        player.goToJail();
    }
}