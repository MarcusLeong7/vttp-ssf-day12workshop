package vttp.ssf.day12.workshop.controller;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/")
public class ImageController {


    @GetMapping
    public String showForm() {
        return "Form"; // Thymeleaf form page
    }

    @GetMapping(path = "/display-image")
    public String getIndex(@RequestParam("number") int numberOfImages , Model model) {
        model.addAttribute("randomPicture",getRandomPictures(numberOfImages));
        return "DisplayImages";
    }

    
    // Utility method 
    private List<String> getRandomPictures(int numberOfImages) {
        if (Constants.images.isEmpty()) {
            throw new IllegalStateException("No images available");
        }

        // Ensure requsted number does not exceed available images
        int maxImages = Math.min(numberOfImages,Constants.images.size());
        
        Random rand = new SecureRandom();
        Set<Integer> uniqueIndexes = new HashSet<>();

        while (uniqueIndexes.size()< maxImages) {
            int idx = rand.nextInt(Constants.images.size());
            uniqueIndexes.add(idx);
        }

        // Build List of image paths
        List<String> randomPictures = new ArrayList<>();
        for (int idx : uniqueIndexes) {
            randomPictures.add("/images/%s".formatted(idx + ".jpg"));
        }
        return randomPictures; 
        
    }
    
    
}
