import org.springframework.beans.factory.annotation.Autowired;

public class PenerbitRestController {

    @Autowired
    private PenerbitRestService penerbitRestService;

    @GetMapping(value = "/penerbit/view-all")
    private List<Penerbit> retrieveAllPenerbit(){return penerbitRestService.retrieveAllPenerbit();}
}
