package org.example.first_scrum.entity.impl;

import org.example.first_scrum.entity.Student;

import static org.example.first_scrum.entity.impl.StudentType1.TO_STRING_TEXT;

public final class StudentType2 implements Student {
    private final Double baseTimeForAnalysis;
    private final double talent = generateTalentValue();

    public StudentType2(final Double newBaseTimeForAnalysis) {
        baseTimeForAnalysis = newBaseTimeForAnalysis;
    }

    @Override
    public double getTalent() {
        return talent;
    }

    @Override
    public Double getBaseTimeForAnalysis() {
        return baseTimeForAnalysis;
    }

    @Override
    public double getAnalysisTime() {
        return baseTimeForAnalysis * 3 / talent;
    }

    @Override
    public double getPracticeTime() {
        return baseTimeForAnalysis * 3 / talent;
    }

    @Override
    public double getFlowTime() {
        return 0;
    }

    @Override
    public String toString() {
        return String.format(TO_STRING_TEXT, getType(), talent,
                getAnalysisTime(), getPracticeTime(), getFlowTime(),
                getTotalTime());
    }
}