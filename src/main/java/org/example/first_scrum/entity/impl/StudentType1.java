package org.example.first_scrum.entity.impl;

import org.example.first_scrum.entity.Student;

public final class StudentType1 implements Student {
    public final static String TO_STRING_TEXT
            = "%s [talent = %.1f, analysis time = %.1f, practice time = %.1f, flow time = %.1f, total time = %.1f]";
    private final Double baseTimeForAnalysis;
    private final double talent = generateTalentValue();

    public StudentType1(final Double newBaseTimeForAnalysis) {
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
        return baseTimeForAnalysis / talent;
    }

    @Override
    public double getPracticeTime() {
        return baseTimeForAnalysis / talent;
    }

    @Override
    public double getFlowTime() {
        return baseTimeForAnalysis / talent;
    }

    @Override
    public String toString() {
        return String.format(TO_STRING_TEXT, getType(), talent,
                getAnalysisTime(), getPracticeTime(), getFlowTime(),
                getTotalTime());
    }
}
