:   import java.util.*;

public class CPU_Scheduler {

    static class Process {
        int procPriority;
        int procDuration;
        String procName;

        public Process(String name, int priority, int duration) {
            this.procName = name;
            this.procPriority = priority;
            this.procDuration = duration;
        }
    }

    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);

        List<Process> processList = new ArrayList<>();
        processList.add(new Process("Process1", 1, 10));
        processList.add(new Process("Process2", 2, 5));

        System.out.println("Choose a scheduling algorithm:");
        System.out.println("1. First Come First Served");
        System.out.println("2. Highest priority scheduling");
        System.out.println("3. Shortest Remaining Time First");

        int choice = inputScanner.nextInt();

        switch (choice) {
            case 1:
                fcfsScheduling(processList);
                break;
            case 2:
                hpScheduling(processList);
                break;
            case 3:
                srtfScheduling(processList);
                break;
            default:
                System.out.println("Invalid choice");
                break;
        }
    }

    public static void fcfsScheduling(List<Process> processList) {
        int currentTime = 0;
        for (Process process : processList) {
            while (process.procDuration > 0) {
                System.out.println("Time " + currentTime + ": Running " + process.procName);
                process.procDuration--;
                currentTime++;
            }
        }
    }

    public static void hpScheduling(List<Process> processList) {
        int currentTime = 0;
        while (!processList.isEmpty()) {
            Process currentProcess = Collections.max(processList, Comparator.comparingInt(proc -> proc.procPriority));
            while (currentProcess.procDuration > 0) {
                System.out.println("Time " + currentTime + ": Running " + currentProcess.procName);
                currentProcess.procDuration--;
                currentTime++;
            }
            processList.remove(currentProcess);
        }
    }

    public static void srtfScheduling(List<Process> processList) {
        int currentTime = 0;
        while (!processList.isEmpty()) {
            Process currentProcess = Collections.min(processList, Comparator.comparingInt(proc -> proc.procDuration));
            while (currentProcess.procDuration > 0) {
                System.out.println("Time " + currentTime + ": Running " + currentProcess.procName);
                currentProcess.procDuration--;
                currentTime++;
            }
            processList.remove(currentProcess);
        }
    }
}