package az.coders.grouppersonal.client;

import az.coders.grouppersonal.model.AzTown;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "https://api.opendata.az/v1/json/map")
public interface AzTownsClient {

    @GetMapping("/towns")
    AzTown getTowns();
}