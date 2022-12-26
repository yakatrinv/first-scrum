package org.example.first_scrum.entity;

import java.util.Random;

public interface Student {
    int UPPER_BOUND_VALUE = 10;
    int LOWER_BOUND_VALUE = 1;
    double DECIMAL_DIVIDER = 10.0;
    Random RANDOM = new Random();

    double getAnalysisTime();

    double getPracticeTime();

    double getFlowTime();

    double getTalent();

    Double getBaseTimeForAnalysis();

    default String getType() {
        return getClass().getSimpleName();
    }

    default double getTotalTime() {
        return getAnalysisTime() + getPracticeTime() + getFlowTime();
    }

    default double generateTalentValue() {
        return (RANDOM.nextInt(UPPER_BOUND_VALUE) + LOWER_BOUND_VALUE)
                / DECIMAL_DIVIDER;
    }
}
