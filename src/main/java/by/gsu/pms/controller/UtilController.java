package by.gsu.pms.controller;

import by.gsu.pms.domain.Experience;
import by.gsu.pms.domain.Skill;
import by.gsu.pms.repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("util")
public class UtilController {

    private final JobRepo jobRepo;
    private final SkillRepo skillRepo;
    private final CompanyRepo companyRepo;
    private final LocationRepo locationRepo;
    private final ExperienceRepo experienceRepo;

    @Autowired
    public UtilController(JobRepo jobRepo, SkillRepo skillRepo, CompanyRepo companyRepo, LocationRepo locationRepo,
                          ExperienceRepo experienceRepo) {
        this.jobRepo = jobRepo;
        this.skillRepo = skillRepo;
        this.companyRepo = companyRepo;
        this.locationRepo = locationRepo;
        this.experienceRepo = experienceRepo;
    }

    @GetMapping("autocomplete/search")
    public List<String> getAutocompleteSearchDictionary () {
        List<String> result = new ArrayList<>();

        skillRepo.findAll().forEach(skill -> result.add(skill.getName()));
        companyRepo.findAll().forEach(company -> result.add(company.getName()));
        locationRepo.findAll().forEach(location -> result.add(location.getName()));
        Collections.sort(result);

        return result;
    }

    @GetMapping("autocomplete/skills")
    public List<String> getAutocompleteSkillsDictionary () {
        return skillRepo.findAllByOrderByName().stream()
                .map(Skill::getName)
                .collect(Collectors.toList());

    }

    @GetMapping("experiences")
    public List<Experience> getExperiences() {
        return experienceRepo.findAll();
    }

    @GetMapping("search-builds/job")
    public Map<String, String> getSearchBuildsForJob() {
        return new HashMap<String, String>() {{
            put("#Angular Front-end Developer", "JavaScript Git Angular HTML CSS SASS");
            put("#React Front-end Developer", "JavaScript Git React HTML CSS SASS");
            put("#Java Back-end Developer", "Java JavaEE Spring Git XML");
            put("JavaScript Back-end Developer", "NodeJS JavaScript Git Express");
            put("Python Developer", "Python Git Machine Learning");
            put("Data Analytic", "Data Analytics MySQL Python");
            put("DevOps", "Docker");
            put("for test #Angular Front-end Developer", "JavaScript Git Angular HTML CSS SASS");
            put("for test #React Front-end Developer", "JavaScript Git React HTML CSS SASS");
            put("for test #Java Back-end Developer", "Java JavaEE Spring Git XML");
            put("for test JavaScript Back-end Developer", "NodeJS JavaScript Git Express");
            put("for test Python Developer", "Python Git Machine Learning");
            put("for test Data Analytic", "Data Analytics MySQL Python");
            put("for test DevOps", "Docker");
        }};
    }

    @GetMapping("search-builds/cv")
    public Map<String, String> getSearchBuildsForCv() {
        return new HashMap<>();
    }

}
