package com.qdm.es.controller;

import com.qdm.es.utils.JsonResult;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.time.LocalDate;

/**
 * @author qiudm
 * @date 2018/11/30 14:25
 * @desc
 */
@RestController
@RequestMapping("/file")
public class FileController {

    @Value("${file.upload.dir}")
    private String fileDir;


    @PostMapping("/upload")
    public JsonResult upload(@RequestParam("file") MultipartFile file) {
        try {
            LocalDate now = LocalDate.now();
            String filePath = fileDir + "/" + now.getYear() + "/" + now.getMonthValue();
            File fileDirector = new File(filePath);
            if (!fileDirector.exists()) {
                fileDirector.mkdirs();
            }
            file.transferTo(new File(filePath + "/" + file.getOriginalFilename()));
        } catch (Exception e) {
            JsonResult.ERROR(e);
        }
        return JsonResult.SUCCESS();
    }

}
