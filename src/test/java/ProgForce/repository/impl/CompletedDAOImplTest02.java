package ProgForce.repository.impl;

import ProgForce.domain.Completed;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

@RunWith(MockitoJUnitRunner.class)
public class CompletedDAOImplTest02 {
    private Completed completed;
    private CompletedDAOImpl completedDAO;
    private List<Completed> testList;

    @Before
    public void setUp(){
        completed = mock(Completed.class);
        completedDAO = mock(CompletedDAOImpl.class);
    }

    @Test
    public void getAllCompletedTest() throws Exception {
        testList = completedDAO.getAllCompleted();
        List<? extends Completed> expectedList = new ArrayList<Completed>();

        doReturn(expectedList).when(completedDAO).getAllCompleted();

        assertEquals(expectedList, testList);
    }

}