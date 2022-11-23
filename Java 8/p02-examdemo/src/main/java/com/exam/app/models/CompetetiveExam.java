package com.exam.app.models;

public class CompetetiveExam {

	private int courseId;
	private String courseName;
	private String courseTeacher;
	private int courseDuration;
	private double totalFees;
	
	@Override
	public String toString() {
		return "CompetetiveExam [courseId=" + courseId + ", courseName=" + courseName + ", courseTeacher="
				+ courseTeacher + ", courseDuration=" + courseDuration + ", totalFees=" + totalFees + "]";
	}
	public CompetetiveExam() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CompetetiveExam(int courseId, String courseName, String courseTeacher, int courseDuration, int totalFees) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.courseTeacher = courseTeacher;
		this.courseDuration = courseDuration;
		this.totalFees = totalFees;
	}
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getCourseTeacher() {
		return courseTeacher;
	}
	public void setCourseTeacher(String courseTeacher) {
		this.courseTeacher = courseTeacher;
	}
	public int getCourseDuration() {
		return courseDuration;
	}
	public void setCourseDuration(int courseDuration) {
		this.courseDuration = courseDuration;
	}
	public double getTotalFees() {
		return totalFees;
	}
	public void setTotalFees(double totalFees) {
		this.totalFees = totalFees;
	} 

}
