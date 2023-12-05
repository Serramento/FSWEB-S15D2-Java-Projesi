package tr.com.workintech.task.model;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class TaskData {
    private Set<Task> annsTasks;
    private Set<Task> bobsTasks;
    private Set<Task> carolsTasks;
    private Set<Task> unassignedTasks;

    public TaskData(Set<Task> annsTasks, Set<Task> bobsTasks, Set<Task> carolsTasks, Set<Task> unassignedTasks) {
        this.annsTasks = annsTasks;
        this.bobsTasks = bobsTasks;
        this.carolsTasks = carolsTasks;
        this.unassignedTasks = unassignedTasks;
    }

    public Set<Task> getAnnsTasks() {
        return annsTasks;
    }

    public Set<Task> getBobsTasks() {
        return bobsTasks;
    }

    public Set<Task> getCarolsTasks() {
        return carolsTasks;
    }

    public Set<Task> getUnassignedTasks() {
        return unassignedTasks;
    }
    public Set<Task> getTasks(String assignee){
        if(assignee.equals("Bob")){
            return this.bobsTasks;
        }
        if(assignee.equals("Carol")){
            return this.carolsTasks;
        }
        if(assignee.equals("Ann")){
            return this.annsTasks;
        }
        if(assignee.equals("All")){
            return getUnion(bobsTasks,carolsTasks,annsTasks,unassignedTasks);
        }
        return new HashSet<>();
    }
    public Set<Task> getUnion(Set<Task>... tasksList){
        Set<Task> result= new LinkedHashSet<>();
        for(Set<Task> tasks: tasksList){
            result.addAll(tasks);
        }
        return result;
    }
    public Set<Task> getIntersect(Set<Task> tasks1, Set<Task> tasks2){
        Set<Task> result= new LinkedHashSet<>(tasks1);
        result.retainAll(tasks2);
        return result;
    }
    public Set<Task> getDifference(Set<Task> tasks1, Set<Task> tasks2){
        Set<Task> result= new LinkedHashSet<>(tasks1);
        result.removeAll(tasks2);
        return result;
    }
}
