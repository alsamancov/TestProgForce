package ProgForce.repository.impl;

import ProgForce.domain.Task;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TaskDAOImplTest03 {
    private TaskDAOImpl taskDAO;
    private Task task;
    Integer id;


    @Before
    public void setUp(){
        task = mock(Task.class);
        taskDAO = mock(TaskDAOImpl.class);
        id = new Integer(task.getId());
    }

    @Test
    public void findTaskByIdTest() throws Exception {
        when(taskDAO.findTaskById(id)).thenReturn(task);
        assertEquals(taskDAO.findTaskById(id), task);
    }

}