package hexlet.code.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class LabelCreateDTO {

    @NotNull
    @Size(min = 3, max = 1000)
    private String name;

    private Set<Long> taskIds = new HashSet<>();
}
