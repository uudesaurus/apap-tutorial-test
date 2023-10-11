package apap.tutorial.bacabaca.restservice;

import apap.tutorial.bacabaca.model.Buku;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.UUID;

public interface BukuRestService {
    voic createRestBuku(Buku buku);
    List<Buku> retrieveRestAllBuku();
    Buku getRestBukuById(UUID id);
    Mono<String> getStatus(String code);
    Mono<BukuDetail> postStatus();
    List<Buku> getBukuByAwalanJudul(String awalan);
}