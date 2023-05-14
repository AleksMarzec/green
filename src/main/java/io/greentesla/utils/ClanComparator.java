package io.greentesla.utils;

import io.greentesla.model.generated.onlinegame.Clan;

import java.util.Comparator;

public class ClanComparator implements Comparator<Clan> {
    @Override
    public int compare(Clan c1, Clan c2) {
        if (c1.getPoints() == c2.getPoints()) {
            return Integer.compare(c1.getNumberOfPlayers(), c2.getNumberOfPlayers());
        }
        return Integer.compare(c2.getPoints(), c1.getPoints());
    }
}

