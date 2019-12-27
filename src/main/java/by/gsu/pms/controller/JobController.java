package by.gsu.pms.controller;

import by.gsu.pms.domain.Job;
import by.gsu.pms.repo.JobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class JobController {

    @Autowired
    private JobRepo jobRepo;

    @GetMapping("/jobs")
    public List<Job> getJobs(){
        return jobRepo.findAll();
    }

    @PostMapping("/jobs")
    void addUser(@RequestBody Job job) {
        jobRepo.save(job);
    }
}
