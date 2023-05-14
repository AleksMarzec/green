package io.greentesla.service;

import io.greentesla.model.generated.atmservice.ATM;
import io.greentesla.model.generated.atmservice.Order;
import io.greentesla.model.generated.atmservice.Task;

import java.util.*;

public class AtmsService {
    public Order solve(List<Task> tasks) {
        HashMap<Integer, List<Task>> groupedTasksByRegion = new HashMap<Integer, List<Task>>();
        for (Task student: tasks) {
            int key = student.getRegion();
            if (groupedTasksByRegion.get(key) == null) {
                groupedTasksByRegion.put(key, new ArrayList<Task>());
            }
            groupedTasksByRegion.get(key).add(student);
        }

        // you can try to not use hashmap and right away and instead use priorityqueue

        List<Task> sortedTasks = new ArrayList<Task>();

        for (int i = 1; i <= groupedTasksByRegion.size(); i++) {
            sortedTasks.addAll(sortByPriorityInsideTheRegion(groupedTasksByRegion.get(i)));
        }

        Order res = new Order();
        for (Task task : sortedTasks) {
            ATM atm = new ATM();
            atm.setAtmId(task.getAtmId());
            atm.setRegion(task.getRegion());
            res.add(atm);
        }
        return res;
    }

    private List<Task> sortByPriorityInsideTheRegion(List<Task> tasks) {
        Map<Integer, Task> tasksMap = new HashMap<>();

        for (Task task : tasks) {
            if (tasksMap.containsKey(task.getAtmId())) {
                Task currentMostImportant = tasksMap.get(task.getAtmId());

                if (mapper(task) > mapper(currentMostImportant)) {
                    tasksMap.put(task.getAtmId(), task);
                }
            } else {
                tasksMap.put(task.getAtmId(), task);
            }
        }

        PriorityQueue<Task> queue = new PriorityQueue<>(tasksMap.size(), new TaskComparator());
        queue.addAll(tasksMap.values());

        return new ArrayList<Task>(queue);
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
                // todo you can throw expection
                return 0;
        }
    }
}

class TaskComparator implements Comparator<Task> {
    @Override
    public int compare(Task o1, Task o2) {
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
                // todo you can throw expection
                return 0;
        }
    }
}
