package com.woori.BAM;

import java.util.Scanner;

public class GradeCalculator {
    static final int STUDENT_COUNT = 5;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] names = new String[STUDENT_COUNT];
        int[] scores = new int[STUDENT_COUNT];
        String[] grades = new String[STUDENT_COUNT];

        int totalScore = 0;

        // 입력 받기
        for (int i = 0; i < STUDENT_COUNT; i++) {
            System.out.printf("%d번째 학생 이름 : ", i + 1);
            names[i] = sc.nextLine();

            System.out.printf("%d번째 학생 점수 : ", i + 1);
            scores[i] = sc.nextInt();
            sc.nextLine(); // 버퍼 비우기

            // 학점 계산
            switch (scores[i] / 10) {
                case 10:
                case 9:
                    grades[i] = "A";
                    break;
                case 8:
                    grades[i] = "B";
                    break;
                case 7:
                    grades[i] = "C";
                    break;
                case 6:
                    grades[i] = "D";
                    break;
                default:
                    grades[i] = "F";
            }

            totalScore += scores[i];
        }

        // 출력
        System.out.println("\n학생 성적 결과:");
        System.out.println("=======================================");
        for (int i = 0; i < STUDENT_COUNT; i++) {
            System.out.printf("%d. %s 학생 점수: %d, 학점: %s\n",
                    i + 1, names[i], scores[i], grades[i]);
        }

        double average = (double) totalScore / STUDENT_COUNT;
        System.out.println("=======================================");
        System.out.printf("총점: %d\n", totalScore);
        System.out.printf("평균: %.2f\n", average);

        sc.close();
    }
}
