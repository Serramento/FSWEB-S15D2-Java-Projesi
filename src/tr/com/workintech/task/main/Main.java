package tr.com.workintech.task.main;

import tr.com.workintech.task.model.Priority;
import tr.com.workintech.task.model.Status;
import tr.com.workintech.task.model.Task;
import tr.com.workintech.task.model.TaskData;

import java.util.LinkedHashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        Task task1= new Task("Sprint 15","Sunumunu hazırla.","Bob", Status.ASSIGNED, Priority.HIGH);
        Task task2= new Task("Sprint 16","Sunumunu hazırla.","Ann", Status.ASSIGNED, Priority.HIGH);
        Task task3= new Task("Sprint 17","Sunumunu hazırla.","Carol", Status.ASSIGNED, Priority.HIGH);
        Task task4= new Task("Sprint 18","Sunumunu hazırla.","Bob", Status.ASSIGNED, Priority.HIGH);
        Task task5= new Task("Sprint 19","Sunumunu hazırla.","Bob", Status.ASSIGNED, Priority.HIGH);
        Task task6= new Task("Sprint 20","Sunumunu hazırla.","Carol", Status.ASSIGNED, Priority.HIGH);
        System.out.println(task1);

        Set<Task> annsTask = new LinkedHashSet<>();
        Set<Task> bobsTask = new LinkedHashSet<>();
        Set<Task> carolsTask = new LinkedHashSet<>();
        Set<Task> unassignedTask = new LinkedHashSet<>();

        annsTask.add(task2);
        bobsTask.add(task1);
        bobsTask.add(task4);
        bobsTask.add(task5);
        bobsTask.add(task3);
        carolsTask.add(task3);
        carolsTask.add(task6);
        unassignedTask.add(new Task("Sprint 21", "", "",Status.IN_QUEUE, Priority.LOW));

        TaskData data= new TaskData(annsTask,bobsTask,carolsTask,unassignedTask);

        System.out.println("All tasks");
        System.out.println(data.getTasks("All"));
        System.out.println("Ann's tasks");
        System.out.println(data.getTasks("Ann"));
        System.out.println("Bob's tasks");
        System.out.println(data.getTasks("Bob"));
        System.out.println("Carol's tasks");
        System.out.println(data.getTasks("Carol"));
        System.out.println("Unassigned, Ann and Bob's unassigned tasks");
        System.out.println(data.getDifference(data.getTasks("All"), data.getUnion(annsTask,bobsTask)));
        System.out.println("Bob and Carol's tasks");
        System.out.println(data.getIntersect(carolsTask, bobsTask));

    }

}