package se.jensensthlm.hellogithubactions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/users")
public class UsersController extends ControllerBase {

    @GetMapping
    public ResponseEntity<String> getAll() {
        return get("https://jsonplaceholder.typicode.com/users");
    }

    @GetMapping("{id}")
    public ResponseEntity<String>  getById(@PathVariable long id) {
        return get("https://jsonplaceholder.typicode.com/users/%d".formatted(id));
    }
}
