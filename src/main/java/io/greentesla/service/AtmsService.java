package io.greentesla.service;

import io.greentesla.model.generated.atmservice.ATM;
import io.greentesla.model.generated.atmservice.Order;
import io.greentesla.model.generated.atmservice.Task;
import io.greentesla.utils.TaskComparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class AtmsService {
    public Order solve(List<Task> tasks) {
        Collections.sort(tasks, new TaskComparator());
        int currentRegion = tasks.get(0).getRegion();
        HashSet<Integer> atmIdsAlreadySeen = new HashSet<>();

        List<ATM> atmsOrder = new ArrayList<>();

        for (Task task : tasks) {
            int taskRegion = task.getRegion();

            if (currentRegion != taskRegion) {
                currentRegion = taskRegion;
                atmIdsAlreadySeen.clear();
            }

            if (atmIdsAlreadySeen.contains(task.getAtmId())) {
                continue;
            } else {
                atmIdsAlreadySeen.add(task.getAtmId());
                ATM atm = new ATM();
                atm.setAtmId(task.getAtmId());
                atm.setRegion(task.getRegion());
                atmsOrder.add(atm);
            }
        }

        Order order = new Order();
        order.addAll(atmsOrder);
        return order;
    }
}
