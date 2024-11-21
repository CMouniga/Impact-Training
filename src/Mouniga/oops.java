package Mouniga;
 
class Worker {
    String workerName;
    int workerId;
 
    Worker(String workerName, int workerId) {
        this.workerName = workerName;
        this.workerId = workerId;
    }
 
    void showWorkerDetails() {
        System.out.println("Worker Name: " + workerName);
        System.out.println("Worker ID: " + workerId);
    }
}
 
class Leader extends Worker {
    String team;
 
    Leader(String workerName, int workerId, String team) {
        super(workerName, workerId);
        this.team = team;
    }
 
    void showLeaderDetails() {
        showWorkerDetails();
        System.out.println("Team: " + team);
    }
}
 
class Captain extends Leader {
    int membersCount;
 
    Captain(String workerName, int workerId, String team, int membersCount) {
        super(workerName, workerId, team);  
        this.membersCount = membersCount;
    }
 
    void showCaptainDetails() {
        showLeaderDetails();
        System.out.println("Members Count: " + membersCount);
    }
}
 
class Coder extends Worker {
    String techStack;
 
    Coder(String workerName, int workerId, String techStack) {
        super(workerName, workerId);
        this.techStack = techStack;
    }
 
    void showCoderDetails() {
        showWorkerDetails();
        System.out.println("Tech Stack: " + techStack);
    }
}
 
interface PerformanceBonus {
    void computeBonus();
}
 
interface RemoteWork {
    void enableRemoteWork();
}
 
class SeniorCoder extends Worker implements PerformanceBonus, RemoteWork {
    int experienceYears;
 
    SeniorCoder(String workerName, int workerId, int experienceYears) {
        super(workerName, workerId);
        this.experienceYears = experienceYears;
    }
 
    void showSeniorCoderDetails() {
        showWorkerDetails();
        System.out.println("Experience: " + experienceYears + " years");
    }
 
    @Override
    public void computeBonus() {
        System.out.println("Bonus: Calculating based on performance and experience.");
    }
 
    @Override
    public void enableRemoteWork() {
        System.out.println("Remote work is available for senior coders.");
    }
}
 
public class oops {
    public static void main(String[] args) {
        // Single Inheritance
        Leader leader = new Leader("Abinaya", 201, "Marketing");
        leader.showLeaderDetails();
 
        System.out.println();
 
        // Multilevel Inheritance
        Captain captain = new Captain("Kowsalya", 202, "Development", 10);
        captain.showCaptainDetails();
 
        System.out.println();
 
        // Hierarchical Inheritance
        Coder coder = new Coder("Charlie", 203, "Java");
        coder.showCoderDetails();
 
        System.out.println();
 
        // Multiple Inheritance via Interfaces
        SeniorCoder seniorCoder = new SeniorCoder("David", 204, 5);
        seniorCoder.showSeniorCoderDetails();
        seniorCoder.computeBonus();
        seniorCoder.enableRemoteWork();
    }
}