package ProgForce.repository.impl;

import ProgForce.domain.Task;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.sql.SQLException;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.stubVoid;



@RunWith(MockitoJUnitRunner.class)
public class TaskDAOImplTest01 {
    private TaskDAOImpl taskImpl;
    private Task task;

    @Before
    public void setUp(){
        task = new Task();
        taskImpl = mock(TaskDAOImpl.class);

    }

    @Test
    public void testAddmethod() throws SQLException {
        stubVoid(taskImpl).toReturn().on().addTask(task);
        taskImpl.addTask(task);
    }
}