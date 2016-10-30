package ProgForce.repository.impl;

import ProgForce.domain.Completed;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.stubVoid;

@RunWith(MockitoJUnitRunner.class)
public class CompletedDAOImplTest01 {
    private Completed completed;
    private CompletedDAOImpl completedDAO;

    @Before
    public void setUp(){
        completed = new Completed();
        completedDAO = mock(CompletedDAOImpl.class);
    }


    @Test
    public void addCompletedTest() throws Exception {
        stubVoid(completedDAO).toReturn().on().addCompleted(completed);
        completedDAO.addCompleted(completed);
    }

}