package org.launchcode.techjobs.oo.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;

import static java.util.Objects.isNull;
import static org.junit.Assert.*;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {

    @Test
    public void testSettingJobId () {
        Job testJob = new Job();
        Job testJob2 = new Job();
        assertNotEquals(testJob.id, testJob2.id);
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        Job testJob3 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertEquals("Product tester", testJob3.name);
        assertTrue(testJob3 instanceof Job);
        assertEquals("ACME", testJob3.employer);
        assertTrue(testJob3.employer instanceof Employer);
        assertEquals("Desert", testJob3.location);
        assertTrue(testJob3.location instanceof Location);
        assertEquals("Quality control", testJob3.positionType);
        assertTrue(testJob3.positionType instanceof PositionType);
        assertEquals("Persistence", testJob3.coreCompetency);
        assertTrue(testJob3.coreCompetency instanceof CoreCompetency);


    }

    @Test
    public void testJobsForEquality() {
        Job testJob3 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job testJob4 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertNotEquals(testJob3, testJob4);
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine() {
        Job testJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String jobData = testJob.toString();
        char firstChar = jobData.charAt(0);
        char lastChar = jobData.charAt(jobData.length()-1);
        assertEquals(firstChar, "\n");
        assertEquals(lastChar, "\n");

    }

    @Test
    public void testToStringContainsCorrectLabelsAndData() {
        Job testJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String jobData = testJob.toString();
        String expectedJobData = "\n" +
                "ID: 1" +
                "Name: Product Tester" +
                "Employer: ACME" +
                "Location: Desert" +
                "Position Type: Quality control" +
                "Core Competency: Persistence" +
                "\n";
        assertEquals(jobData, expectedJobData);

    }
@Test
    public void testToStringHandlesEmptyField() {
    Job testJob = new Job("Product tester", new Employer(""), new Location("Desert"), new PositionType(""), new CoreCompetency("Persistence"));
    String jobData = testJob.toString();
    String expectedJobData = "\n" +
            "ID: 1" +
            "Name: Product Tester" +
            "Employer: Data not available" +
            "Location: Desert" +
            "Position Type: Data not available" +
            "Core Competency: Persistence" +
            "\n";
    assertEquals(jobData, expectedJobData);
    }
}
