class Task {
    String taskId;
    String taskName;
    String status;

    public Task(String taskId, String taskName, String status) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.status = status;
    }

    public String toString() {
        return "[" + taskId + ", " + taskName + ", " + status + "]";
    }
}

class Node {
    Task task;
    Node next;

    public Node(Task task) {
        this.task = task;
        this.next = null;
    }
}

public class TaskManagement {
    Node head = null;

    public void addTask(Task task) {
        Node newNode = new Node(task);
        newNode.next = head;
        head = newNode;
    }

    public Task searchTask(String id) {
        Node current = head;
        while (current != null) {
            if (current.task.taskId.equals(id))
                return current.task;
            current = current.next;
        }
        return null;
    }

    public void deleteTask(String id) {
        Node current = head, prev = null;
        while (current != null) {
            if (current.task.taskId.equals(id)) {
                if (prev == null) head = current.next;
                else prev.next = current.next;
                return;
            }
            prev = current;
            current = current.next;
        }
        System.out.println("Task not found.");
    }

    public void traverse() {
        Node current = head;
        while (current != null) {
            System.out.println(current.task);
            current = current.next;
        }
    }

    public static void main(String[] args) {
        TaskManagement tm = new TaskManagement();
        tm.addTask(new Task("T001", "Design UI", "Pending"));
        tm.addTask(new Task("T002", "Write Code", "In Progress"));
        tm.addTask(new Task("T003", "Test", "Completed"));

        tm.traverse();

        System.out.println("\nSearching for T002:");
        System.out.println(tm.searchTask("T002"));

        System.out.println("\nDeleting T002:");
        tm.deleteTask("T002");
        tm.traverse();
    }
}
