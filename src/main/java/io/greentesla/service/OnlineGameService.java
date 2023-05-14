package io.greentesla.service;

import io.greentesla.model.generated.onlinegame.Clan;
import io.greentesla.model.generated.onlinegame.Group;
import io.greentesla.model.generated.onlinegame.Order;
import io.greentesla.model.generated.onlinegame.Players;
import io.greentesla.utils.ClanComparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class OnlineGameService {
    public Order solve(Players players) {
        List<Clan> sortedClans = players.getClans().subList(0, players.getClans().size()); // we shouldn't change incoming data

        Collections.sort(sortedClans, new ClanComparator());

        Order orderedGroups = new Order();

        while (!sortedClans.isEmpty()) {
            int currentGroupSize = 0;
            List<Clan> toRemove = new ArrayList<>();
            Group scheduledClans = new Group();

            for (int i = 0; i < sortedClans.size(); i++) {
                Clan clan = sortedClans.get(i);

                if (currentGroupSize + clan.getNumberOfPlayers() <= players.getGroupCount()) {
                    currentGroupSize += clan.getNumberOfPlayers();
                    scheduledClans.add(clan);
                    toRemove.add(clan);
                }

                if (currentGroupSize == players.getGroupCount()) {
                    break;
                }
            }

            for (Clan clanToRemove : toRemove) {
                sortedClans.remove(clanToRemove);
            }

            orderedGroups.add(scheduledClans);
        }

        return orderedGroups;
    }
}
