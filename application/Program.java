package application;

import entities.Lesson;
import entities.Task;
import entities.Video;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<Lesson> lessonList = new ArrayList<>();

        System.out.print("How many lessons does the course have? ");
        int numberOfLessons = sc.nextInt();

        System.out.println();
        for(int i = 0; i < numberOfLessons; i++) {
            System.out.printf("Class data #%d: %n", i+1);
            System.out.print("Content or task (c/t)? ");
            char typeOfLesson = sc.next().charAt(0);
            System.out.print("Title: ");
            sc.nextLine();
            String title = sc.nextLine();
            if(typeOfLesson == 'c') {
                System.out.print("Video URL: ");
                String url = sc.nextLine();
                System.out.print("Duration in seconds: ");
                int duration = sc.nextInt();
                lessonList.add(new Video(title, url, duration));
            }
            else {
                System.out.print("Description: ");
                String description = sc.nextLine();
                System.out.print("Number of questions: ");
                int numberOfQuestions = sc.nextInt();
                lessonList.add(new Task(title, description, numberOfQuestions));
            }
            System.out.println();
        }

        int sumLesson = 0;
        for(Lesson lesson : lessonList) {
            sumLesson += lesson.duration();
        }

        System.out.printf("TOTAL COURSE DURATION = %d seconds", sumLesson);

        sc.close();
    }
}
