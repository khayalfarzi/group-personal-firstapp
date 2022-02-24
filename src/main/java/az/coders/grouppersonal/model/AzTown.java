package az.coders.grouppersonal.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AzTown {

    @JsonProperty("Status")
    public String status;

    @JsonProperty("StatusMessage")
    public Object statusMessage;

    @JsonProperty("Response")
    public List<Response> response;
}