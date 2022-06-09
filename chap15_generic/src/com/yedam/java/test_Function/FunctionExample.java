package com.yedam.java.test_Function;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;

public class FunctionExample {
	//필드
	private static List<Student> list = Arrays.asList(
            new Student("자바", 100, 100),
            new Student("으아악", 0, 0)
    );
	
	//메소드 												//t -> t.getName()
    public static void printString(Function<Student, String> function){
        for(Student student : list){	//student.getName()
            System.out.print(function.apply(student) + " ");
        }
        System.out.println();
    }

    public static void printInt(ToIntFunction<Student> function){
        for(Student student : list){
            System.out.print(function.applyAsInt(student) + " ");
        }
        System.out.println();
    }

    public static double getAverage(ToDoubleFunction<Student> function){
        int sum = 0;
        for(Student student : list){
            sum += function.applyAsDouble(student);
        }
        double average = sum / list.size();
        return average;
    }

    public static void main(String[] args) {
        System.out.println("-- 학생 이름 --");
        printString(t -> t.getName());

        System.out.println("-- 영어 점수 --");
        printInt(t -> t.getEnglishScore());

        System.out.println("-- 수학 점수 --");
        printInt(t -> t.getMathScore());

        double englishAvg = getAverage(t -> t.getEnglishScore());
        double mathAvg = getAverage(t -> t.getMathScore());

        System.out.println("영어 폄균 점수 : " + englishAvg);
        System.out.println("수학 평균 점수 : " + mathAvg);
    }
    
}
