package team.marela.jpp.backend.jpp_restapi.client;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import team.marela.jpp.backend.jpp_restapi.client.models.in.VozniRedPostRequest;
import team.marela.jpp.backend.jpp_restapi.client.models.out.RootVozniRedElement;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class VozniRedRetreiver {
    private final String url = "https://vozovnice.nomago.si/api/v2/departures";
    private final WebClient webClient = WebClient.create(url);

    public RootVozniRedElement getVozniRed(VozniRedPostRequest req) {
        Mono<RootVozniRedElement> response = webClient.post()
                .body(Mono.just(req), VozniRedPostRequest.class)
                .retrieve()
                .bodyToMono(RootVozniRedElement.class);
        return response.block();
    }
}
