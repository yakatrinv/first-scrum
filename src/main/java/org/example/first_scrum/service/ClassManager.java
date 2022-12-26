package org.example.first_scrum.service;

import org.example.first_scrum.entity.Student;
import org.example.first_scrum.entity.impl.StudentType1;
import org.example.first_scrum.entity.impl.StudentType2;
import org.example.first_scrum.entity.impl.StudentType3;

import java.util.ArrayList;
import java.util.List;

public final class ClassManager {
	private final int numOfStudentsType1;
	private final int numOfStudentsType2;
	private final int numOfStudentsType3;
	private final double baseTimeForAnalysis;
	private final String subjectTitle;
	private List<Student> students;

	public ClassManager(final int numOfStudentsType1,
						final int numOfStudentsType2,
						final int numOfStudentsType3,
						final double baseTimeForAnalysis,
						final String subjectTitle) {
		this.numOfStudentsType1 = numOfStudentsType1;
		this.numOfStudentsType2 = numOfStudentsType2;
		this.numOfStudentsType3 = numOfStudentsType3;
		this.baseTimeForAnalysis = baseTimeForAnalysis;
		this.subjectTitle = subjectTitle;
		createStudents();
	}

	public List<Student> getStudents() {
		return students;
	}

	public String getSubjectTitle() {
		return subjectTitle;
	}

	public void printClassInfo() {
		if (students.size() > 0) {
			System.out.println("Subject: " + subjectTitle);
			students.forEach(System.out::println);
		}
	}

	private void createStudents() {
		students = new ArrayList<>();
		for (int i = 0; i < numOfStudentsType1; ++i) {
			students.add(new StudentType1(baseTimeForAnalysis));
		}
		for (int i = 0; i < numOfStudentsType2; ++i) {
			students.add(new StudentType2(baseTimeForAnalysis));
		}
		for (int i = 0; i < numOfStudentsType3; ++i) {
			students.add(new StudentType3(baseTimeForAnalysis));
		}
	}
}
