package ProgForce.repository.impl;

import ProgForce.domain.Task;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.doCallRealMethod;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;


@RunWith(MockitoJUnitRunner.class)
public class TaskDAOImplTest02 {
    private TaskDAOImpl taskImpl;
    private Task task;
    Integer id;

    @Before
    public void setupMock(){
        task = new Task();
        taskImpl = mock(TaskDAOImpl.class);
        id = new Integer(task.getId());
    }

    @Test
    public void deleteTaskTest() throws Exception {
       doCallRealMethod().when(taskImpl).deleteTask(eq(id));
        taskImpl.deleteTask(id);

        verify(taskImpl).deleteTask(id);
    }

}