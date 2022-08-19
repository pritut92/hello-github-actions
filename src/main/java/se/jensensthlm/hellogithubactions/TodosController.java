package se.jensensthlm.hellogithubactions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/todos")
public class TodosController extends ControllerBase {
    @GetMapping
    public ResponseEntity<String> getAll() {
        return get("https://jsonplaceholder.typicode.com/todos");
    }

    @GetMapping("{id}")
    public ResponseEntity<String> getById(@PathVariable long id) {
        return get("https://jsonplaceholder.typicode.com/todos/%d".formatted(id));
    }
}
