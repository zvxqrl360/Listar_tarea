package com.utp.app.taskmanager.rest;

import com.utp.app.taskmanager.models.Task;
import com.utp.app.taskmanager.services.TaskService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

@Path("/tasks")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TaskController {

    @Inject
    private TaskService taskService;

    @GET
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    @POST
    public Response createTask(Task task) {
        taskService.createTask(task);
        return Response.status(Response.Status.CREATED).entity(task).build();
    }

    @GET
    @Path("/{taskId}")
    public Response getTaskById(@PathParam("taskId") Long taskId) {
        Task task = taskService.getTaskById(taskId);
        if (task != null) {
            return Response.ok().entity(task).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @PUT
    @Path("/{taskId}")
    public Response updateTask(@PathParam("taskId") Long taskId, Task task) {
        Task updatedTask = taskService.updateTask(task);
        if (updatedTask != null) {
            return Response.ok().entity(updatedTask).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @DELETE
    @Path("/{taskId}")
    public Response deleteTask(@PathParam("taskId") Long taskId) {
        boolean deleted = taskService.deleteTask(taskId);
        if (deleted) {
            return Response.noContent().build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}
