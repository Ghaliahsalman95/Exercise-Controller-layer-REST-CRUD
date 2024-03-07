package com.example.exercisecontrollerlayerrestcrud.Controller;

import com.example.exercisecontrollerlayerrestcrud.APIResponse.ApiResponse;
import com.example.exercisecontrollerlayerrestcrud.Model.Task;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("api/v1/task")
public class TaskController {

    ArrayList<Task> tasks = new ArrayList<Task>();
    //------------------Create a new taks (title , description , status)
    @PostMapping("/addTask")
    public ApiResponse addTask(@RequestBody Task task){
        tasks.add(task);
        return new ApiResponse("Added Successful");
    }

    //-----------------------Display all tasks .
    @GetMapping("/displayAllTask")
    public ArrayList<Task> displayAllTask() {
        return tasks;
    }

    //---------------------Update a task
    @PutMapping("/update/{index}")
    public ApiResponse updateTask(@PathVariable int index, @RequestBody Task task) {
        tasks.set(index, task);
        return new ApiResponse("Updated Successful");
    }

    //-----------------------------Delete a task
    @DeleteMapping("delete/{index}")
    public ApiResponse deleteTask(@PathVariable int index) {
        tasks.remove(index);
        return new ApiResponse("Deleted is successful");
    }

    //--------------------------Change the task status as done or not done
    @PutMapping("change/{status}/{index}")
    public ApiResponse changeStatus(@PathVariable boolean status, @PathVariable int index) {
        if (status) {
            tasks.get(index).setStatus("Done");
            return new ApiResponse("Changed successfully");
        } else {
            tasks.get(index).setStatus("Not Done");
            return new ApiResponse("Changed successfully");
        }
    }

    //--------------------------Search for a task by given title
    @GetMapping("/serach/{title}")
    public Task getTask(@PathVariable String title) {
        for (Task task : tasks) {
            if (task.getTitle().equalsIgnoreCase(title))
                return task;
        }
        return null;
    }
//-------------------------------------

}