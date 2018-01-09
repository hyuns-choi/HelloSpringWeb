package org.oraclejava.spring.sample;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UploadController {
	
	@RequestMapping(value="/upload/single", method=RequestMethod.GET)
	public String singleUpload() {
		
		return "upload/single";
	}
	
	@RequestMapping(value="/upload/single", method=RequestMethod.POST)
	public String singleUpload(@RequestParam("file") MultipartFile file) throws IllegalStateException, IOException {
		
		if(!file.getOriginalFilename().isEmpty() && !file.isEmpty()) {
			File uploadFile = new File("c:/upload/", file.getOriginalFilename());
			file.transferTo(uploadFile);

			return "upload/singlesuccess";
		}
		else {

			return "redirect:/upload/single";
		}
		
	}


}
