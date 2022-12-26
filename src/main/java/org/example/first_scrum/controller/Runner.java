package org.example.first_scrum.controller;

import org.example.first_scrum.service.ClassManager;

public final class Runner {
    private final static int NUM_OF_STUDENTS_TYPE_1 = 3;
    private final static int NUM_OF_STUDENTS_TYPE_2 = 3;
    private final static int NUM_OF_STUDENTS_TYPE_3 = 3;
    public final static double BASE_TIME_FOR_ANALYSIS = 66;
    public final static String SUBJECT_TITLE = "java core";

    public static void main(final String[] args) {
        new ClassManager(NUM_OF_STUDENTS_TYPE_1, NUM_OF_STUDENTS_TYPE_2,
                NUM_OF_STUDENTS_TYPE_3, BASE_TIME_FOR_ANALYSIS,
                SUBJECT_TITLE).printClassInfo();
    }
}