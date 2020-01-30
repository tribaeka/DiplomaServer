package by.gsu.pms.controller;

import by.gsu.pms.repo.CompanyRepo;
import by.gsu.pms.repo.JobRepo;
import by.gsu.pms.repo.LocationRepo;
import by.gsu.pms.repo.SkillRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("util")
public class UtilController {

    private final JobRepo jobRepo;
    private final SkillRepo skillRepo;
    private final CompanyRepo companyRepo;
    private final LocationRepo locationRepo;

    @Autowired
    public UtilController(JobRepo jobRepo, SkillRepo skillRepo, CompanyRepo companyRepo, LocationRepo locationRepo) {
        this.jobRepo = jobRepo;
        this.skillRepo = skillRepo;
        this.companyRepo = companyRepo;
        this.locationRepo = locationRepo;
    }

    @GetMapping("autocomplete")
    public List<String> getAutocompleteDictionary () {
        List<String> result = new ArrayList<>();

        jobRepo.findAll().forEach(job -> result.add(job.getTitle()));
        skillRepo.findAll().forEach(skill -> result.add(skill.getName()));
        companyRepo.findAll().forEach(company -> result.add(company.getName()));
        locationRepo.findAll().forEach(location -> result.add(location.getName()));

        return result;
    }

}
