import java.util.*;

public class JobSequenceProblem {
     // Define a nested static class Job to represent each job
     static class Job {
          int deadline; // Deadline of the job
          int profit; // Profit of the job
          int id; // Unique identifier of the job

          // Constructor to initialize a Job object
          public Job(int i, int d, int p) {
               id = i;
               deadline = d;
               profit = p;
          }
     }

     // Main method
     public static void main(String[] args) {
          // Array to store job information (deadline, profit)
          int jobsInfo[][] = { { 4, 20 }, { 1, 10 }, { 1, 40 }, { 1, 30 } };

          // ArrayList to hold Job objects
          ArrayList<Job> jobs = new ArrayList<>();

          // Loop to create Job objects and add them to the ArrayList
          for (int i = 0; i < jobsInfo.length; i++) {
               // Create a new Job object with id, deadline, and profit from jobsInfo
               jobs.add(new Job(i, jobsInfo[i][0], jobsInfo[i][1]));
          }

          // Sort jobs ArrayList in descending order of profit using lambda expression
          Collections.sort(jobs, (obj1, obj2) -> obj2.profit - obj1.profit);

          // ArrayList to store the selected job IDs
          ArrayList<Integer> ans = new ArrayList<>();

          // Initialize time to 0
          int time = 0;

          // Loop through the sorted jobs
          for (int i = 0; i < jobs.size(); i++) {
               // Get the current job
               Job curr = jobs.get(i);
               // If the deadline of the current job is greater than the current time
               if (curr.deadline > time) {
                    // Add the ID of the current job to the answer list
                    ans.add(curr.id);
                    // Increment the time
                    time++;
               }
          }

          // Print the maximum number of jobs that can be completed within their deadlines
          System.out.println("max job is = " + ans.size());

          // Print the IDs of the selected jobs
          for (int i = 0; i < ans.size(); i++) {
               System.out.print(ans.get(i) + " ");
          }
          System.out.println();
     }
}
