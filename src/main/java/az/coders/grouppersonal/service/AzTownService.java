package az.coders.grouppersonal.service;

import az.coders.grouppersonal.client.AzTownsClient;
import az.coders.grouppersonal.model.AzTown;
import az.coders.grouppersonal.model.Response;
import org.springframework.stereotype.Service;

@Service
public class AzTownService {

    private final AzTownsClient client;

    public AzTownService(AzTownsClient client) {
        this.client = client;
    }

    public Response getTownById(Long id) {

        AzTown azTown = client.getTowns();

        for (Response response : azTown.getResponse())
            if (response.getObjectId() == id)
                return response;

        return null;
    }
}