package by.gsu.pms.controller;

import by.gsu.pms.domain.Company;
import by.gsu.pms.domain.User;
import by.gsu.pms.repo.CompanyRepo;
import by.gsu.pms.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("company")
public class CompanyController {

    @Autowired
    private FileService fileService;

    @Autowired
    private CompanyRepo companyRepo;

    @Value("${company.images.path}")
    private String companyImagesPath;

    @GetMapping("byUser/{id}")
    public Company getCompanyByUser(@PathVariable("id") User user) {
        return user.getCompany();
    }

    @PostMapping("uploadImage")
    public Company addLogoToCompany(
            @RequestParam("company") String companyId,
            @RequestBody MultipartFile file) throws IOException
    {
        Company company = companyRepo.getOne(Long.parseLong(companyId));
        String fileName = fileService.saveFileToFolder(file, companyImagesPath);

        company.setLogoPath("/img/company/" + fileName);

        return companyRepo.save(company);
    }
}
