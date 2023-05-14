package io.greentesla.service;

import io.greentesla.model.generated.atmservice.ATM;
import io.greentesla.model.generated.atmservice.Order;
import io.greentesla.model.generated.atmservice.Task;

import java.util.*;

public class AtmsService {
    public Order solve(List<Task> tasks) {
        Collections.sort(tasks, new TaskComparator());
        int currentRegion = tasks.get(0).getRegion();
        HashSet<Integer> atmIdsAlreadySeen = new HashSet<>();

        List<ATM> result = new ArrayList<>();

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
                result.add(atm);
            }
        }

        Order order = new Order();
        order.addAll(result);
        return order;
    }
}

class TaskComparator implements Comparator<Task> {
    @Override
    public int compare(Task o1, Task o2) {
        if (o1.getRegion() != o2.getRegion()) {
            return o1.getRegion() - o2.getRegion();
        }
        return mapper(o2) - mapper(o1);
    }

    private static Integer mapper(Task task) {
        switch (task.getRequestType()) {
            case FAILURE_RESTART:
                return 4;
            case PRIORITY:
                return 3;
            case SIGNAL_LOW:
                return 2;
            case STANDARD:
                return 1;
            default:
                // could throw the exception
                return 0;
        }
    }
}
