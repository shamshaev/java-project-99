package hexlet.code.controller.api;

import hexlet.code.dto.LabelCreateDTO;
import hexlet.code.dto.LabelDTO;
import hexlet.code.dto.LabelUpdateDTO;
import hexlet.code.service.LabelService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class LabelController {
    @Autowired
    private LabelService labelService;

    @GetMapping("/labels")
    public ResponseEntity<List<LabelDTO>> index() {
        var labels = labelService.getAll();

        return ResponseEntity.status(HttpStatus.OK)
                .header("X-Total-Count", String.valueOf(labels.size()))
                .body(labels);
    }

    @GetMapping("/labels/{id}")
    public LabelDTO show(@PathVariable Long id) {

        return labelService.findById(id);
    }

    @PostMapping("/labels")
    @ResponseStatus(HttpStatus.CREATED)
    public LabelDTO create(@RequestBody @Valid LabelCreateDTO labelData) {

        return labelService.create(labelData);
    }

    @PutMapping("/labels/{id}")
    public LabelDTO update(@RequestBody @Valid LabelUpdateDTO labelData, @PathVariable Long id) {

        return labelService.update(labelData, id);
    }

    @DeleteMapping("/labels/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void destroy(@PathVariable Long id) {

        labelService.delete(id);
    }
}
