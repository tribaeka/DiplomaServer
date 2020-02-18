package by.gsu.pms.controller;

import by.gsu.pms.domain.Cv;
import by.gsu.pms.repo.CvRepo;
import by.gsu.pms.repo.UserRepo;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("cv")
public class CvController {
    private ObjectMapper mapper = new ObjectMapper();

    @Autowired
    private CvRepo cvRepo;

    @Autowired
    private UserRepo userRepo;

    @Value("${cv.files.path}")
    private String cvFilesPath;

    @GetMapping
    public List<Cv> list(){
        return cvRepo.findAll();
    }

    @GetMapping("{id}")
    public Cv getOne(@PathVariable("id") Cv cv){
        return cv;
    }

    @GetMapping("/download/{id}")
    public ResponseEntity<byte[]> downloadCv(@PathVariable("id") Cv cv) throws IOException {
        Path path = Paths.get(cvFilesPath + "/" + cv.getFileName());
        byte[] data = Files.readAllBytes(path);
        HttpHeaders respHeaders = new HttpHeaders();
        respHeaders.setContentLength(data.length);
        respHeaders.setContentType(new MediaType("text", "json"));
        respHeaders.setCacheControl("must-revalidate, post-check=0, pre-check=0");
        respHeaders.set(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + (cv.getTitle() + ".docx"));
        return new ResponseEntity<byte[]>(data, respHeaders, HttpStatus.OK);
    }

    @GetMapping("user/{username}")
    public List<Cv> getCvByUsername(@PathVariable("username") String username) {
        return userRepo.findByUsername(username)
                .map(user -> cvRepo.findAllByUser(user)).orElse(null);
    }

    @PostMapping
    public Cv create(@RequestBody String jsoncv){
        Cv cv = null;
        try {
            cv = mapper.readValue(jsoncv, Cv.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return cvRepo.save(cv);
    }

    @PutMapping("{id}")
    public Cv update(@PathVariable("id") Cv cvFromDb,
                      @RequestBody String jsonCv
    ){
        Cv cv = null;
        try {
            cv = mapper.readValue(jsonCv, Cv.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        BeanUtils.copyProperties(cv, cvFromDb, "cvId");

        return cvRepo.save(cvFromDb);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Cv cv){
        cvRepo.delete(cv);
    }
}
