package com.example.application.solver;

import ai.timefold.solver.core.api.score.stream.Constraint;
import org.junit.Assert;
import org.junit.Test;

public class TimeTableConstraintProviderTest {
    TimeTableConstraintProvider timeTableConstraintProvider = new TimeTableConstraintProvider();

    @Test
    public void testDefineConstraints() throws Exception {
        Constraint[] result = timeTableConstraintProvider.defineConstraints(null);
        Assert.assertArrayEquals(new Constraint[]{null}, result);
    }

    @Test
    public void testRoomConflict() throws Exception {
        Constraint result = timeTableConstraintProvider.roomConflict(null);
        Assert.assertEquals(null, result);
    }

    @Test
    public void testTeacherConflict() throws Exception {
        Constraint result = timeTableConstraintProvider.teacherConflict(null);
        Assert.assertEquals(null, result);
    }

    @Test
    public void testStudentGroupConflict() throws Exception {
        Constraint result = timeTableConstraintProvider.studentGroupConflict(null);
        Assert.assertEquals(null, result);
    }

    @Test
    public void testTeacherRoomStability() throws Exception {
        Constraint result = timeTableConstraintProvider.teacherRoomStability(null);
        Assert.assertEquals(null, result);
    }

    @Test
    public void testTeacherTimeEfficiency() throws Exception {
        Constraint result = timeTableConstraintProvider.teacherTimeEfficiency(null);
        Assert.assertEquals(null, result);
    }

    @Test
    public void testStudentGroupSubjectVariety() throws Exception {
        Constraint result = timeTableConstraintProvider.studentGroupSubjectVariety(null);
        Assert.assertEquals(null, result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: https://weirddev.com/forum#!/testme