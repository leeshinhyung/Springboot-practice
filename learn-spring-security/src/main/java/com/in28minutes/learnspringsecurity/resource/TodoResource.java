package com.in28minutes.learnspringsecurity.resource;

import jakarta.annotation.security.RolesAllowed;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TodoResource {

    private Logger logger = LoggerFactory.getLogger(getClass());

    private static final List<Todo> todos =
            List.of(new Todo("in28minutes", "Learn AWS"),
            new Todo("in28minutes", "Get AWS Certified"));

    @GetMapping("/todos")
    public List<Todo> retrieveAllTodos() {
        return todos;
    }

    @GetMapping("/users/{username}/todos")
    @PreAuthorize("hasRole('USER') and #username == authentication.name")
    @PostAuthorize("returnObject.username == 'in28minutes'")
    @RolesAllowed({"ADMIN", "USER"})
    @Secured({"ADMIN", "USER"})
    public Todo retrieveTodosForASpecificUser(@PathVariable String username) {
        return todos.get(0);
    }

    @PostMapping("/users/{username}/todos")
    public void createTodosForASpecificUser(@PathVariable String username, @RequestBody Todo todo) {
        logger.info("create {} for {}", todo, username);
    }
}

record Todo (String username, String description ){}

