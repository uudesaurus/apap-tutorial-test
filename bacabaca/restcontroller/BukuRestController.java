import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class BukuRestController {

    @Autowired
    private BukuMapper bukuMapper;

    @Autowired
    private BukuRestService bukuRestService;

    @GetMapping(value = "/buku/view-all")
    private List<Buku> retrieveAllBuku() {
        return bukuRestService.retrieveRestAllBuku();
    }

    @GetMapping(value = "/buku/{id}")
    private Buku retrieveBuku(@PathVariable("id") String id) {
        try {
            return bukuRestService.getRestBukuById(UUID.fromString(id));
        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Id Buku " + id + " not found"
            );
        }
    }

    @PostMapping(value = "/buku/create")
    public Buku restAddBuku(@Valid @RequestBody CreateBukuRequestDTO bukuDTO, BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Request body has invalid type or missing field"
            );
        } else {
            var buku = bukuMapper.createBukuRequestDTOToBuku(bukuDTO);
            bukuRestService.createRestBuku(buku);
            return buku;
        }
    }

    @GetMapping(value = "/buku/{id}/status")
    private Mono<String> getStatus(@PathVariable("id") String id){
        return bukuRestService.getStatus(id);
    }

    @PostMapping(value = "/full")
    private Mono<BukuDetail> postStatus() {
        return bukuRestService.postStatus();
    }
}
