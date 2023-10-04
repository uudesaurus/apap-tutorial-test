import org.springframework.beans.factory.annotation.Autowired;

public class PenerbitRestServiceImpl {
 
    @Autowired
    private PenerbitDn penerbitDb;;

    @Override
    public List<Penerbit> retrieveRestAllPenerbit() {
        return penerbitDb.findAll();
    }
}
