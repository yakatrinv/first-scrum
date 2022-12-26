package test.example.first_scrum.entity;

import org.example.first_scrum.entity.Student;
import org.example.first_scrum.entity.impl.StudentType2;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.example.first_scrum.entity.Student.RANDOM;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static test.example.first_scrum.entity.StudentType1Test.TESTS_NUM;
import static test.example.first_scrum.entity.StudentType1Test.TEST_GET_ANALYSIS_TIME_MESSAGE;
import static test.example.first_scrum.entity.StudentType1Test.TEST_GET_FLOW_TIME_MESSAGE;
import static test.example.first_scrum.entity.StudentType1Test.TEST_GET_PRACTICE_TIME_MESSAGE;
import static test.example.first_scrum.entity.StudentType1Test.UPPER_BOUND_BASE_TIME_FOR_ANALYSIS_VALUE;

public final class StudentType2Test {
    private final static List<Student> STUDENTS = new ArrayList<>();

    @BeforeAll
    static void addStudents() {
        for (int i = 0; i < TESTS_NUM; ++i) {
            Student student = new StudentType2((double) (RANDOM.nextInt(
                    UPPER_BOUND_BASE_TIME_FOR_ANALYSIS_VALUE)));
            STUDENTS.add(student);
        }
    }

    @TestFactory
    Stream<DynamicTest> testGetAnalysisTimeFromStream() {
        return STUDENTS.stream().map(x -> DynamicTest.dynamicTest(
                TEST_GET_ANALYSIS_TIME_MESSAGE + x,
                () -> assertEquals(x.getAnalysisTime(),
                        x.getBaseTimeForAnalysis() * 3 / x.getTalent())));
    }

    @TestFactory
    Stream<DynamicTest> testGetPracticeTimeFromStream() {
        return STUDENTS.stream().map(x -> DynamicTest.dynamicTest(
                TEST_GET_PRACTICE_TIME_MESSAGE + x,
                () -> assertEquals(x.getPracticeTime(),
                        x.getBaseTimeForAnalysis() * 3 / x.getTalent())));
    }

    @TestFactory
    Stream<DynamicTest> testGetFlowTimeFromStream() {
        return STUDENTS.stream().map(x -> DynamicTest.dynamicTest(
                TEST_GET_FLOW_TIME_MESSAGE + x,
                () -> assertEquals(x.getFlowTime(), 0)));
    }

    @AfterAll
    static void clearStudents() {
        STUDENTS.clear();
    }
}
