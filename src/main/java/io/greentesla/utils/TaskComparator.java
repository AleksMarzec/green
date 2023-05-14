package io.greentesla.utils;

import io.greentesla.model.generated.atmservice.Task;

import java.util.Comparator;

public class TaskComparator implements Comparator<Task> {
    private static Integer priorityMapper(Task.RequestTypeEnum requestType) {
        switch (requestType) {
            case FAILURE_RESTART:
                return 4;
            case PRIORITY:
                return 3;
            case SIGNAL_LOW:
                return 2;
            case STANDARD:
                return 1;
            default:
                return 0;
        }
    }

    @Override
    public int compare(Task o1, Task o2) {
        if (o1.getRegion() != o2.getRegion()) {
            return o1.getRegion() - o2.getRegion();
        }
        return priorityMapper(o2.getRequestType()) - priorityMapper(o1.getRequestType());
    }
}
