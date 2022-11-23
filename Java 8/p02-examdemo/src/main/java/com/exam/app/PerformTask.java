package com.exam.app;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.exam.app.models.CompetetiveExam;

public class PerformTask {

	public static void main(String[] args) {

		List<CompetetiveExam> examsList = Arrays.asList(new CompetetiveExam(1111, "NEET", "Teacher 1", 9, 5000),
				new CompetetiveExam(1112, "MPSC", "Teacher 4", 24, 1200),
				new CompetetiveExam(1113, "JEE", "Teacher 1", 12, 5000),
				new CompetetiveExam(1114, "UPSC", "Teacher 4", 36, 1500),
				new CompetetiveExam(1115, "CAT", "Teacher 2", 18, 5000),
				new CompetetiveExam(1116, "Exam1", "Teacher 1", 12, 5000),
				new CompetetiveExam(1117, "Exam2", "Teacher 4", 9, 1200),
				new CompetetiveExam(1118, "Exam4", "Teacher 1", 18, 12000),
				new CompetetiveExam(1119, "Exam3", "Teacher 3", 36, 15000),
				new CompetetiveExam(2221, "Exam5", "Teacher 2", 24, 15000),
				new CompetetiveExam(2222, "Exam6", "Teacher 1", 24, 25000),
				new CompetetiveExam(2223, "Exam8", "Teacher 4", 18, 22000),
				new CompetetiveExam(2224, "Exam7", "Teacher 1", 3, 2000),
				new CompetetiveExam(2225, "Exam10", "Teacher 2", 36, 15000),
				new CompetetiveExam(2226, "Exam9", "Teacher 2", 6, 4000));
		
		System.out.println("Print original Exams List: "+examsList);
		
		
		System.out.println("Q1. write Lambda expression to sort this list "
				+ " based on price in descending order");

		examsList.stream().sorted(Comparator.comparingDouble(CompetetiveExam::getTotalFees).reversed())
				.forEach(System.out::println);

		System.out.println("\nQ2. If price is same, then sort on duration in ascending order");

		examsList.stream().sorted(Comparator.comparingDouble(CompetetiveExam::getTotalFees).reversed()
				.thenComparingInt(CompetetiveExam::getCourseDuration)).forEach(System.out::println);
		
		
//		System.out.println("---------different way of sorting-----");		
//		Comparator<CompetetiveExam> totalFeesComparator = new Comparator<CompetetiveExam>() {
//			
//			public int compare(CompetetiveExam c1, CompetetiveExam c2) {
//				if(c1.getTotalFees()==c2.getTotalFees())
//				return 0;
//				else if(c1.getTotalFees() > c2.getTotalFees())  //desc
//					return -1;
//				else
//					return 1;
//			}
//		};
//		
//Comparator<CompetetiveExam> durationComparator = new Comparator<CompetetiveExam>() {
//			
//			public int compare(CompetetiveExam c1, CompetetiveExam c2) {
//				if(c1.getCourseDuration()==c2.getCourseDuration())
//				return 0;
//				else if(c1.getCourseDuration() < c2.getCourseDuration())  //asc
//					return -1;
//				else
//					return 1;
//			}
//		};
//		

//	 Collections.sort(examsList, totalFeesComparator
//                .thenComparing(durationComparator));
//	 System.out.println(examsList);
		
}
}
