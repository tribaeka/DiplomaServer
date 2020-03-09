package by.gsu.pms.service;

import by.gsu.pms.domain.Job;
import by.gsu.pms.repo.JobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class JobSearchService {
    private final static List<String> JOB_RANKS = new ArrayList<>(Arrays.asList("junior", "middle", "senior"));
    private final JobRepo jobRepo;
    private static final String QUERY_SEPARATOR = " ";
    private Predicate<String> findJobRank = query ->
            JOB_RANKS.stream().anyMatch(rank -> query.equalsIgnoreCase(rank) || query.contains(rank));
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
                    .filter(job -> containsIgnoreCase(job.getTitle(), query))
                    .collect(Collectors.toList());
        }
        if (isAnyMatchInLocation(jobRepo.findAll(), query)) {
            resultInLocation = jobRepo.findAll().stream()
                    .filter(job -> containsIgnoreCase(job.getLocation().getName(), query))
                    .collect(Collectors.toList());
        }
        if (isAnyMatchInCompany(jobRepo.findAll(), query)) {
            resultInCompany = jobRepo.findAll().stream()
                    .filter(job -> containsIgnoreCase(job.getCompaniesJob().getName(), query))
                    .collect(Collectors.toList());
        }
        if (isAnyMatchInSkills(jobRepo.findAll(), query)) {
            resultInSkills = jobRepo.findAll().stream()
                    .filter(job -> job.getJobSkillSet().stream()
                            .anyMatch(skill -> containsIgnoreCase(skill.getName(), query)))
                    .collect(Collectors.toList());
        }
        return Stream.of(resultInTitle, resultInLocation, resultInCompany, resultInSkills)
                .flatMap(Collection::stream)
                .distinct()
                .sorted(Comparator.comparing(Job::getPostDate).reversed())
                .collect(Collectors.toList());
    }

    private List<Job> executeSearchWithMultiWords(List<String> query) {
        List<String> queryRanks = query.stream().filter(findJobRank).collect(Collectors.toList());
        List<Job> resultInTitle = new ArrayList<>();
        List<Job> resultInLocation = new ArrayList<>();
        List<Job> resultInCompany = new ArrayList<>();
        List<Job> result;

        if (!queryRanks.isEmpty() && isAnyMatchInTitle(jobRepo.findAll(), queryRanks)) {
            List<Job> resultsInRank = jobRepo.findAll().stream()
                    .filter(job -> queryRanks.stream()
                            .anyMatch(subQuery -> containsIgnoreCase(job.getTitle(), subQuery)))
                    .collect(Collectors.toList());
            resultInTitle = resultsInRank.stream()
                    .filter(job -> query.stream()
                            .anyMatch(subQuery -> containsIgnoreCase(job.getTitle(), subQuery)))
                    .collect(Collectors.toList());
        } else {
            if (isAnyMatchInTitle(jobRepo.findAll(), query)){
                resultInTitle = jobRepo.findAll().stream()
                        .filter(job -> query.stream()
                                .anyMatch(subQuery -> containsIgnoreCase(job.getTitle(), subQuery)))
                        .collect(Collectors.toList());
            }
        }

        if (isAnyMatchInLocation(jobRepo.findAll(), query)) {
            resultInLocation = jobRepo.findAll().stream()
                    .filter(job -> query.stream()
                            .anyMatch(subQuery -> containsIgnoreCase(job.getLocation().getName(), subQuery)))
                    .collect(Collectors.toList());
        }
        if (isAnyMatchInCompany(jobRepo.findAll(), query)) {
            resultInCompany = jobRepo.findAll().stream()
                    .filter(job -> query.stream()
                            .anyMatch(subQuery -> containsIgnoreCase(job.getCompaniesJob().getName(), subQuery)))
                    .collect(Collectors.toList());
        }

        result = intesect(intesect(resultInTitle, resultInLocation), resultInCompany);

        if (isAnyMatchInSkills(result, query)) {
            List<Job> resultInSkills = result.stream()
                    .filter(job -> job.getJobSkillSet().stream()
                            .anyMatch(skill -> query.stream()
                                    .anyMatch(subQuery -> containsIgnoreCase(skill.getName(), subQuery))))
                    .collect(Collectors.toList());
            result.addAll(resultInSkills);
        }

        return result.stream()
                .distinct()
                .sorted(Comparator.comparing(Job::getPostDate).reversed())
                .collect(Collectors.toList());
    }

    private boolean isAnyMatchInTitle(List<Job> jobs, String query) {
        return jobs.stream().anyMatch(job -> containsIgnoreCase(job.getTitle(), query));
    }

    private boolean isAnyMatchInTitle(List<Job> jobs, List<String> query) {
        return jobs.stream().anyMatch(job -> query.stream()
                .anyMatch(subQuery -> containsIgnoreCase(job.getTitle(), subQuery)));
    }

    private boolean isAnyMatchInLocation(List<Job> jobs, String query) {
        return jobs.stream().anyMatch(job -> containsIgnoreCase(job.getLocation().getName(), query));
    }

    private boolean isAnyMatchInLocation(List<Job> jobs, List<String> query) {
        return jobs.stream().anyMatch(job -> query.stream()
                .anyMatch(subQuery -> containsIgnoreCase(job.getLocation().getName(), subQuery)));
    }

    private boolean isAnyMatchInCompany(List<Job> jobs, String query) {
        return jobs.stream().anyMatch(job -> containsIgnoreCase(job.getCompaniesJob().getName(), query));
    }

    private boolean isAnyMatchInCompany(List<Job> jobs, List<String> query) {
        return jobs.stream().anyMatch(job -> query.stream()
                .anyMatch(subQuery -> containsIgnoreCase(job.getCompaniesJob().getName(), subQuery)));    }

    private boolean isAnyMatchInSkills(List<Job> jobs, String query) {
        return jobs.stream()
                .anyMatch(job -> job.getJobSkillSet().stream()
                        .anyMatch(skill -> containsIgnoreCase(skill.getName(), query))
                );
    }

    private boolean isAnyMatchInSkills(List<Job> jobs, List<String> query) {
        return jobs.stream()
                .anyMatch(job -> job.getJobSkillSet().stream()
                        .anyMatch(skill -> query.stream()
                                .anyMatch(subQuery -> containsIgnoreCase(skill.getName(), subQuery))));
    }

    private boolean containsIgnoreCase(String str1, String str2) {
        return str1.toLowerCase().contains(str2.toLowerCase());
    }

    private List<Job> intesect(List<Job> list1, List<Job> list2) {
        List<Job> list = new ArrayList<>();

        if (list2.isEmpty()) return list1;

        for (Job item : list1) {
            if(list2.contains(item)) {
                list.add(item);
            }
        }

        return list;
    }
}
