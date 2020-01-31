package by.gsu.pms.service;

import by.gsu.pms.domain.Job;
import by.gsu.pms.repo.JobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class JobSearchService {
    private final JobRepo jobRepo;
    private static final String QUERY_SEPARATOR = " ";
    @Autowired
    public JobSearchService(JobRepo jobRepo) {
        this.jobRepo = jobRepo;
    }

    public List<Job> search(String query) {
        if (!query.contains(QUERY_SEPARATOR)) return executeSearchWithSingleWord(query);
        else return executeSearchWithMultiWords(new ArrayList<>(Arrays.asList(query.split(QUERY_SEPARATOR))));
    }

    private List<Job> executeSearchWithSingleWord(String query) {
        List<Job> resultInTitle = new ArrayList<>();
        List<Job> resultInLocation = new ArrayList<>();
        List<Job> resultInCompany = new ArrayList<>();
        List<Job> resultInSkills = new ArrayList<>();

        if (isAnyMatchInTitle(jobRepo.findAll(), query)){
            resultInTitle = jobRepo.findAll().stream()
                    .filter(job -> job.getTitle().contains(query))
                    .collect(Collectors.toList());
        }
        if (isAnyMatchInLocation(jobRepo.findAll(), query)) {
            resultInLocation = jobRepo.findAll().stream()
                    .filter(job -> job.getLocation().getName().contains(query))
                    .collect(Collectors.toList());
        }
        if (isAnyMatchInCompany(jobRepo.findAll(), query)) {
            resultInCompany = jobRepo.findAll().stream()
                    .filter(job -> job.getCompaniesJob().getName().contains(query))
                    .collect(Collectors.toList());
        }
        if (isAnyMatchInSkills(jobRepo.findAll(), query)) {
            resultInSkills = jobRepo.findAll().stream()
                    .filter(job -> job.getJobSkillSet().stream()
                            .anyMatch(skill -> skill.getName().contains(query)))
                    .collect(Collectors.toList());
        }
        return Stream.of(resultInTitle, resultInLocation, resultInCompany, resultInSkills)
                .flatMap(Collection::stream)
                .distinct()
                .sorted(Comparator.comparing(Job::getPostDate).reversed())
                .collect(Collectors.toList());
    }

    private boolean isAnyMatchInTitle(List<Job> jobs, String query) {
        return jobs.stream().anyMatch(job -> job.getTitle().contains(query));
    }

    private boolean isAnyMatchInTitle(List<Job> jobs, List<String> query) {
        return jobs.stream().anyMatch(job -> query.stream()
                .anyMatch(subQuery -> job.getTitle().contains(subQuery)));
    }

    private boolean isAnyMatchInLocation(List<Job> jobs, String query) {
        return jobs.stream().anyMatch(job -> job.getLocation().getName().contains(query));
    }

    private boolean isAnyMatchInLocation(List<Job> jobs, List<String> query) {
        return jobs.stream().anyMatch(job -> query.stream()
                .anyMatch(subQuery -> job.getLocation().getName().contains(subQuery)));
    }

    private boolean isAnyMatchInCompany(List<Job> jobs, String query) {
        return jobs.stream().anyMatch(job -> job.getCompaniesJob().getName().contains(query));
    }

    private boolean isAnyMatchInCompany(List<Job> jobs, List<String> query) {
        return jobs.stream().anyMatch(job -> query.stream()
                .anyMatch(subQuery -> job.getCompaniesJob().getName().contains(subQuery)));    }

    private boolean isAnyMatchInSkills(List<Job> jobs, String query) {
        return jobs.stream()
                .anyMatch(job -> job.getJobSkillSet().stream()
                        .anyMatch(skill -> skill.getName().contains(query))
                );
    }

    private boolean isAnyMatchInSkills(List<Job> jobs, List<String> query) {
        return jobs.stream()
                .anyMatch(job -> job.getJobSkillSet().stream()
                        .anyMatch(skill -> query.stream()
                                .anyMatch(subQuery -> skill.getName().contains(subQuery))));
    }

    private List<Job> executeSearchWithMultiWords(List<String> query) {
        List<Job> resultInTitle = new ArrayList<>();
        List<Job> resultInLocation = new ArrayList<>();
        List<Job> resultInCompany = new ArrayList<>();
        List<Job> resultInSkills = new ArrayList<>();

        if (isAnyMatchInTitle(jobRepo.findAll(), query)){
            resultInTitle = jobRepo.findAll().stream()
                    .filter(job -> query.stream()
                            .anyMatch(subQuery -> job.getTitle().contains(subQuery)))
                    .collect(Collectors.toList());
        }
        if (isAnyMatchInLocation(jobRepo.findAll(), query)) {
            resultInLocation = jobRepo.findAll().stream()
                    .filter(job -> query.stream()
                            .anyMatch(subQuery -> job.getLocation().getName().contains(subQuery)))
                    .collect(Collectors.toList());
        }
        if (isAnyMatchInCompany(jobRepo.findAll(), query)) {
            resultInCompany = jobRepo.findAll().stream()
                    .filter(job -> query.stream()
                            .anyMatch(subQuery -> job.getCompaniesJob().getName().contains(subQuery)))
                    .collect(Collectors.toList());
        }
        if (isAnyMatchInSkills(jobRepo.findAll(), query)) {
            resultInSkills = jobRepo.findAll().stream()
                    .filter(job -> job.getJobSkillSet().stream()
                            .anyMatch(skill -> query.stream()
                                    .anyMatch(subQuery -> skill.getName().contains(subQuery))))
                    .collect(Collectors.toList());
        }
        return Stream.of(resultInTitle, resultInLocation, resultInCompany, resultInSkills)
                .flatMap(Collection::stream)
                .distinct()
                .sorted(Comparator.comparing(Job::getPostDate).reversed())
                .collect(Collectors.toList());
    }
}
