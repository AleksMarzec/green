package io.greentesla.service;

import io.greentesla.model.onlinegame.Clan;
import io.greentesla.model.onlinegame.Group;
import io.greentesla.model.onlinegame.Order;
import io.greentesla.model.onlinegame.Players;

import java.util.*;

public class OnlineGameService {
    public Order solve(Players players) {
        // shouldn't change the objects inside the request
        List<Clan> sortedClans = players.getClans();

        Collections.sort(sortedClans, new Comparator<Clan>() {
            @Override
            public int compare(Clan c1, Clan c2) {
                if (c1.getPoints() == c2.getPoints()) {
                    return Integer.compare(c1.getNumberOfPlayers(), c2.getNumberOfPlayers());
                }
                return Integer.compare(c2.getPoints(), c1.getPoints());
            }
        });

        List<Group> res = new ArrayList<>();

        while (!sortedClans.isEmpty()) {
            int currentGroupSize = 0;
            List<Integer> toRemove = new ArrayList<>();
            Group scheduledClans = new Group();

            for (int i = 0; i < sortedClans.size(); i++) {
                Clan clan = sortedClans.get(i);

                if (currentGroupSize + clan.getNumberOfPlayers() <= players.getGroupCount()) {
                    currentGroupSize += clan.getNumberOfPlayers();
                    scheduledClans.add(clan);
                    toRemove.add(i);
                }

                if (currentGroupSize == players.getGroupCount()) {
                    break;
                }
            }

            for (int i = toRemove.size() - 1; i >= 0; i--) {
                sortedClans.remove((int) toRemove.get(i));
            }

            res.add(scheduledClans);
        }

        Order order = new Order();
        order.addAll(res);

        return order;
    }
}
