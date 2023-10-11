package apap.tutorial.bacabaca.restservice;

import apap.tutorial.bacabaca.model.Buku;
import apap.tutorial.bacabaca.repository.BukuDb;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.UUID;

@Service
@Transactional

public class BukuRestServiceImpl implements BukuRestService {
    
    private final String mockUrl = System.getenv("MOCK_URL");

    private final WebClient webClient;

    public BukuRestServiceImpl(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl(mockUrl).build();
    }
    
    @Override
    public Mono<String> getStatus(String id){
        return this.webClient.get().url("/rest/buku/status").retrieve().bodyToMono(String.class);
    };
    
    @Override
    public Mono<BukuDetail> postStatus() {
        MultiValueMap<String, String> data = new LinkedMultiValueMap<>();
        data.add("judul","Buku Cara Membaca Jilid 2");
        data.add("tahunTerbit","2003");

        var response = this.webClient
            .post()
            .uri("/rest/buku/full-status")
            .bodyValue(data)
            .retrieve()
            .bodyToMono(BukuDetail.class);

        return response;
    }
    
    @Autowired
    private BukuDb bukuDb;

    @Override
    public void createRestBuku(Buku buku) {
        bukuDb.save(buku);
    }

    @Override
    public List<Buku> retrieveRestAllBuku() {
        return bukuDb.sortBukuByJudulLower();
    };

    @Override
    public List<Buku> getBukuByAwalanJudul(String awalan) {
    return bukuRepository.findByJudulStartingWith(awalan);
    }
}