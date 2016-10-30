package ProgForce.repository.impl;


import ProgForce.domain.Task;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

@RunWith(MockitoJUnitRunner.class)
public class TaskDAOImplTest04 {
    private TaskDAOImpl taskDAO;
    private Task task;
    private List<Task> testList;

    @Before
    public void setUp(){
        task = mock(Task.class);
        taskDAO = mock(TaskDAOImpl.class);
    }


    @Test
    public void getAllTaskTest() throws SQLException {
        testList = taskDAO.getAllTask();
        List<? extends Task> expectedList = new ArrayList<Task>();
        //expectedList.add(task);

        doReturn(expectedList).when(taskDAO).getAllTask();

        assertEquals(expectedList, testList);
    }

}