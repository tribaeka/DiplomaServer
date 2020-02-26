package by.gsu.pms.controller;

import by.gsu.pms.domain.Cv;
import by.gsu.pms.payload.response.MessageResponse;
import by.gsu.pms.repo.CvRepo;
import by.gsu.pms.repo.UserRepo;
import by.gsu.pms.service.SkillService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("cv")
public class CvController {
    private ObjectMapper mapper = new ObjectMapper();

    @Autowired
    private CvRepo cvRepo;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private SkillService skillService;

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
    public Cv create(
            @RequestParam("title") String cvTitle,
            @RequestParam("skills") String skills,
            @RequestParam("user") String userId,
            @RequestBody MultipartFile file
    ) throws IOException {
        Cv cv = new Cv();
        cv.setTitle(cvTitle);
        cv.setCvSkillSet(skillService.restoreSkillListFromString(skills));
        cv.setUser(userRepo.getOne(Long.parseLong(userId)));
        if (file != null && ! file.getOriginalFilename().isEmpty()){
            File uploadDir = new File(cvFilesPath);
            if (!uploadDir.exists()){
                uploadDir.mkdir();
            }

            String uuidFile = UUID.randomUUID().toString();
            String resultFileName = uuidFile + "." + file.getOriginalFilename();

            file.transferTo(new File(cvFilesPath +"/" + resultFileName ));
            cv.setFileName(resultFileName);
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
    public ResponseEntity<MessageResponse> delete(@PathVariable("id") Cv cv){
        cvRepo.delete(cv);
        return ResponseEntity.ok(new MessageResponse("Deleted successfully!"));

    }
}
