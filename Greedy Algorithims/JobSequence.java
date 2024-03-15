import java.util.*;

public class JobSequence {
     // Define a class to represent a job, with id, deadline, and profit attributes
     static class Job {
          int id;
          int deadline;
          int profit;

          // Constructor to initialize a job with id, deadline, and profit
          public Job(int i, int d, int p) {
               id = i;
               profit = p;
               deadline = d;
          }
     }

     public static void main(String[] args) {
          // Array representing job information: [deadline, profit]
          int jobsInfo[][] = { { 4, 20 }, { 1, 10 }, { 1, 40 }, { 1, 30 } };

          // Create an ArrayList to store Job objects
          ArrayList<Job> jobs = new ArrayList<Job>();

          // Populate the jobs ArrayList with Job objects using the information from
          // jobsInfo array
          for (int i = 0; i < jobsInfo.length; i++) {
               jobs.add(new Job(i, jobsInfo[i][0], jobsInfo[i][1]));
          }

          // Sort the jobs ArrayList based on profit in descending order
          Collections.sort(jobs, (obj1, obj2) -> obj2.profit - obj1.profit);

          // ArrayList to store the sequence of job ids to be executed
          ArrayList<Integer> seq = new ArrayList<Integer>();
          // Variable to keep track of time
          int time = 0;

          // Iterate through the sorted jobs list
          for (int i = 0; i < jobs.size(); i++) {
               // Get the current job
               Job curr = jobs.get(i);
               // Check if the current job's deadline is greater than the current time
               if (curr.deadline > time) {
                    // Add the current job's id to the sequence
                    seq.add(curr.id);
                    // Increment time as the job is executed
                    time++;
               }
          }

          // Print the total number of jobs
          System.out.println("max jobs " + jobs.size());

          // Print the sequence of job ids
          for (int i = 0; i < jobs.size(); i++) {
               System.out.println(seq.get(i));
          }
          System.out.println();
     }
}
