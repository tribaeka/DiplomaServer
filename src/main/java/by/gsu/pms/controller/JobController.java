package by.gsu.pms.controller;

import by.gsu.pms.domain.Job;
import by.gsu.pms.repo.JobRepo;
import by.gsu.pms.search.JobSearch;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("job")
public class JobController {
    private ObjectMapper mapper = new ObjectMapper();
    private final JobRepo jobRepo;
    private final JobSearch jobSearch;
    private Predicate<String> isFullSearch = (query -> query.isEmpty() || query.equals("*"));

    @Autowired
    public JobController(JobRepo jobRepo, JobSearch jobSearch) {
        this.jobRepo = jobRepo;
        this.jobSearch = jobSearch;
    }

    @GetMapping("search")
    public List<Job> executeSearch(@RequestParam(name = "query") String query) {
        return isFullSearch.test(query) ?
                jobRepo.findAll() :
                jobSearch.search(query);
    }

    @GetMapping("search/skill")
    public List<Job> executeSearchBySkill(@RequestParam(name = "skill") String searchSkill) {
        return jobRepo.findAll().stream()
                .filter(job -> job.getJobSkillSet()
                        .stream()
                        .anyMatch(skill -> skill.getName().equalsIgnoreCase(searchSkill)))
                .collect(Collectors.toList());
    }

    @GetMapping
    public List<Job> list(){
        return jobRepo.findAll();
    }

    @GetMapping("{id}")
    public Job getOne(@PathVariable("id") Job job){
        return job;
    }

    @PostMapping
    public Job create(@RequestBody String jsonJob){
        Job job = null;
        try {
            job = mapper.readValue(jsonJob, Job.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jobRepo.save(job);
    }

    @PutMapping("{id}")
    public Job update(@PathVariable("id") Job jobFromDb,
                       @RequestBody String jsonUser
    ){
        Job job = null;
        try {
            job = mapper.readValue(jsonUser, Job.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        BeanUtils.copyProperties(job, jobFromDb, "id");

        return jobRepo.save(jobFromDb);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Job job){
        jobRepo.delete(job);
    }
}
