package by.gsu.pms.controller;

import by.gsu.pms.domain.User;
import by.gsu.pms.repo.UserRepo;
import by.gsu.pms.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("user")
public class UserController {
    @Value("${user.images.path}")
    private String userImagesPath;
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private FileService fileService;

    @PostMapping("uploadImage")
    public User addImageToUser(@RequestParam("user") String userId, @RequestBody MultipartFile file) throws IOException {
        User user = userRepo.getOne(Long.parseLong(userId));
        String fileName = fileService.saveFileToFolder(file, userImagesPath);

        user.setImageName(fileName);

        return userRepo.save(user);
    }
}
