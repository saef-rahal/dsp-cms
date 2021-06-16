package com.dsp.cms.controller;

import com.dsp.cms.configs.FileUploadUtil;
import com.dsp.cms.model.Content;
import com.dsp.cms.repository.CategoryRepository;
import com.dsp.cms.repository.ContentProviderRepository;
import com.dsp.cms.repository.ContentRepository;
import com.dsp.cms.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by Saef Rahal on 5/25/2021.
 */
@Controller
@RequestMapping("/enthaply/content")
public class ContentController {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ServiceRepository serviceRepository;

    @Autowired
    private ContentProviderRepository contentProviderRepository;

    @Autowired
    private ContentRepository contentRepository;

    @GetMapping("/content-create")
    public String getContentCreate(Model model){

        model.addAttribute("categories", categoryRepository.findAll());
        model.addAttribute("services", serviceRepository.findAll());
        model.addAttribute("contentProviders", contentProviderRepository.findAll());
        return "content/content-create";
    }

    @PostMapping("/content-create")
    public String postContentCreate(@RequestParam(required=false,name = "inputCategory") String inputCategory, @RequestParam(required=false, name = "contentName") String contentName, @RequestParam(required=false, name = "smsContent") String smsContent, @RequestParam(required=false, name = "inputService") String inputService, @RequestParam(required=false, name = "inputContentProvider") String inputContentProvider, @RequestParam(required=false, name = "status") boolean status, @RequestParam(required=false, name = "notes") String notes, @RequestParam(required=false, name = "contentDesc") String contentDecs, @RequestParam(required=false, name = "file") MultipartFile file){

        Content content = new Content();
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        content.setContentName(contentName);
        content.setCategory(categoryRepository.getOne(Long.parseLong(inputCategory)));
        content.setContentProvider(contentProviderRepository.getOne(Long.parseLong(inputContentProvider)));
        content.setDescription(contentDecs);
        content.setService(serviceRepository.getOne(Long.parseLong(inputService)));
        content.setSmsContent(smsContent);
        content.setStatus(status);
        content.setFilePath(fileName);

        Content savedContent = contentRepository.save(content);
        String uploadDir = "content/"+ savedContent.getId();
        try {
            FileUploadUtil.saveFile(uploadDir, fileName, file);
        }catch (Exception e){
            System.out.println(e);
        }

        return "content/content-list";
    }

    @GetMapping("/content-list")
    public String getContentList(Model model){

        model.addAttribute("categories", categoryRepository.findAll());
        model.addAttribute("services", serviceRepository.findAll());
        model.addAttribute("contentProviders", contentProviderRepository.findAll());
        model.addAttribute("contents", contentRepository.findAll());
        return "content/content-list";
    }

    public String getContentShow(Model model){
        return "content/content-show";
    }
}
