package p4package;
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileNotFoundException;

public class grading_system {


    public static void main(String [] args) throws FileNotFoundException {

        Scanner scan = new Scanner(System.in);


        System.out.println("Welcome to the Grade Center!");
        System.out.println("Enter 1 to generate and display a grade report");
        System.out.println("Enter 2 to generate a grade and save it into a file");
        System.out.println("Enter 3 to quit");
        System.out.println("Enter Choice:");
        int choice = scan.nextInt();
        //Based on which integer the user inputs for their choice, the menu is called
        numMenu(choice);

    }

    public static void numMenu(int choice) throws FileNotFoundException {
        PrintWriter output;
        // These arrays stores the test scores inputted by the user
        int[] test1 = new int[4];
        int[] test2 = new int[4];
        Scanner scan = new Scanner(System.in) ;
        // Reads the file name inputted by the user
        String fName = "";
        switch(choice) {

            case 1:

                System.out.println("Enter grades for test1 and test2\nFor test 1,");
                // This for loops prompts the user to enter a score based on the array index which is 4
                for(int i = 0; i < test1.length; i++)
                {
                    System.out.println("Enter Score" + " " + (i+1) + ":");
                    test1[i] = scan.nextInt();
                    //output.println("Score"+ " " + (i+1)+ ":"+ " "+score[i]);
                }
                System.out.println("For test 2,");
                for(int i = 0; i < test2.length; i++)
                {
                    System.out.println("Enter Score" + " " + (i+1) + ":");
                    test2[i] = scan.nextInt();
                }

                // This calls the method that adds up test1 and test2 scores by the user
                double[] avgs = testAvg(test1, test2);
                // Calls the character array that assigns a letter grade based on the final average of test1 and test2
                char[] grade = gradeAvg(avgs);

                //The format in which the code is displayed
                System.out.println("Test1\tTest2\tAverage\t Grade");
                System.out.println("------\t------\t------\t------");
                System.out.println(test1[0]+ " \t   " + test2[0] + "     \t"+  avgs[0] + "      \t"+ grade[0]);
                System.out.println(test1[1]+ " \t   " + test2[1] + "     \t"+  avgs[1] + "      \t"+ grade[1]);
                System.out.println(test1[2]+ " \t   " + test2[2] + "     \t"+  avgs[2] + "      \t"+ grade[2]);
                System.out.println(test1[3]+ " \t.  " + test2[3] + "     \t"+  avgs[3] + "      \t"+ grade[3]);

                scan.close();
                break;

            case 2:


                System.out.println("Enter grades for test1 and test2\nFor test 1,");
                for(int i = 0; i < test1.length; i++)
                {			 System.out.println("Enter Score" + " " + (i+1) + ":");
                    test1[i] = scan.nextInt();
                    //output.println("Score"+ " " + (i+1)+ ":"+ " "+score[i]);
                }
                System.out.println("For test 2,");
                for(int i = 0; i < test2.length; i++)
                {
                    System.out.println("Enter Score" + " " + (i+1) + ":");
                    test2[i] = scan.nextInt();
                }
                System.out.println("A new file will be created for the report.\n Enter the new file name:");
                fName = scan.next();
                System.out.println("Report written to file: " +  fName);
                File file = new File(fName);
                output = new PrintWriter(file);
                avgs = testAvg(test1, test2);
                grade = gradeAvg(avgs);
                output.println("Test1\tTest2\tAverage\t Grade");
                output.println("------\t------\t------\t------");
                output.println(test1[0]+ "\t " + test2[0] + "\t"+  avgs[0] + "\t  "+ grade[0]);
                output.println(test1[1]+ "\t " + test2[1] + "\t"+  avgs[1] + "\t  "+ grade[1]);
                output.println(test1[2]+ "\t " + test2[2] + "\t"+  avgs[2] + "\t  "+ grade[2]);
                output.println(test1[3]+ "\t " + test2[3] + "\t"+  avgs[3] + "\t  "+ grade[3]);
                output.close();

                break;



            case 3:

                System.out.println("Successfully exited program");

                break;
        }

    }
    /**
     * This method allows us take the average of test 1 and test 2 of each of the 4 students
     * @param test1
     * @param test2
     * @return
     */
    public static double[] testAvg(int[] test1, int[] test2) {
        double[] average = new double[test2.length];
        for(int i = 0; i < test2.length; i++)
        {
            //Takes the average in each index
            average[i] = (test1[i] + test2[i]) / 2;
        }
        return average;
    }

    /**
     * The character array allows us to compute and assign a letter grade value based on the averages of test 1 and test2
     * @param average
     * @return
     */
    public static char[] gradeAvg(double[] average) {
        char[] grades = new char[average.length];
        for(int i = 0; i < average.length; i++)
        {	// if the average of the test score is greater than or equal to 90, the letter A is assigned as a grade
            if(average[i] >= 90) {
                grades[i] = 'A';
            } else if ( average[i] >= 80) {
                grades[i] = 'B';
            } else if( average[i] >= 70) {
                grades[i] = 'C';
            } else if ( average[i] < 70) {
                grades[i] = 'F';
            }
        }
        return grades;
    }
}

