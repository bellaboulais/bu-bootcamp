import java.io.*; 
import java.util.ArrayList;
 
public class GradeAnalyzer {
 
    public static void main(String[] args) {
        // Step 1: read scores from file
        // Step 2: calculate statistics
        // Step 3: write and print report
        String filename = "scores.txt";
        String outputFile = "report.txt";
        ArrayList<Integer> scores = readScores(filename);
        if (scores.isEmpty()) {
            System.out.println("No scores in file: " + filename);
            return;
        }

        // calculate highest and lowest score
        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;
        for (Integer score : scores) {
            if (score <= low) {
                low = score;
            }
            else if (score >= high) {
                high = score;
            }
        }
        double average = calculateAverage(scores);

        // Grade bands: A = 90+, B = 80 to 89, C = 70 to 79, D = 60 to 69, F = below 60. 
        int countA = 0, countB = 0, countC = 0, countD = 0, countF = 0;
        for (Integer score : scores) {
            if (score >= 90) {
                countA +=1;
            }
            else if (score < 90 && score >= 80) {
                countB +=1;
            }
            else if (score < 80 && score >= 70) {
                countC +=1;
            }
            else if (score < 70 && score >= 60) {
                countD +=1;
            }
            else {
                countF +=1;
            }
        }

        writeReport(scores, average, high, low, outputFile, 
                        countA, countB, countC, countD, countF);
    } 
 
    // Returns a list of valid scores read from the file
    public static ArrayList<Integer> readScores(String filename) {
        // your code here
        ArrayList<Integer> valid_scores = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (!line.isEmpty()) {
                    try {
                        int score = Integer.parseInt(line);
                        valid_scores.add(score);
                    }
                    catch (NumberFormatException e) {
                        System.out.println("WARNING: " + line + " is not a valid score");
                    }
                }
            }
            return valid_scores;
        }
        catch (IOException e) {
            System.out.println("Error: " + e);
            return null;
        }
    }
 
    // Returns the average of a list of scores, or 0.0 if the list is empty
    public static double calculateAverage(ArrayList<Integer> scores) {
        // your code here
        if (scores.isEmpty()) {
            return 0.0;
        }
        int total = 0;
        for (Integer score : scores) {
            total += score;
        }
        return (double) total / (double) scores.size();
    } 
 
    // Writes and prints the report
    public static void writeReport(ArrayList<Integer> scores,
                                   double avg, int high, int low,
                                   String outputFile, int countA,
                                   int countB, int countC, 
                                   int countD, int countF) {
        // your code here
        int total_scores = scores.size();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            writer.write(String.format("=== Grade Analysis Report ===\n"));
            writer.write(String.format("Total scores processed: ", total_scores));
            writer.write(String.format("\n\nAverage score: %.2f%n", avg));
            writer.write(String.format("Highest score: %5d%n", high));
            writer.write(String.format("Lowest score: %6d%n", low));    
            writer.write(String.format("\nGrade Distribution:\n"));  
            writer.write(String.format(" A (90-100): %4d%n", countA));  
            writer.write(String.format(" B (80-89): %5d%n", countB));  
            writer.write(String.format(" C (70-79): %5d%n", countC)); 
            writer.write(String.format(" D (60-69): %5d%n", countD)); 
            writer.write(String.format(" F (below 60): %2d%n", countF)); 

            System.out.println("\n=== Grade Analysis Report ===");
            System.out.println(String.format("Total scores processed: %d%n", total_scores));
            System.out.print(String.format("Average score: %.2f%n", avg));
            System.out.print(String.format("Highest score: %5d%n", high));
            System.out.print(String.format("Lowest score: %6d%n", low));    
            System.out.println("\nGrade Distribution:");  
            System.out.print(String.format(" A (90-100): %4d%n", countA));  
            System.out.print(String.format(" B (80-89): %5d%n", countB));  
            System.out.print(String.format(" C (70-79): %5d%n", countC)); 
            System.out.print(String.format(" D (60-69): %5d%n", countD)); 
            System.out.print(String.format(" F (below 60): %2d%n", countF)); 

        }
        catch (IOException e) {
            System.out.println("Error: " + e);
        } 
    }
} 