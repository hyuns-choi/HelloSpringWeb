package org.oraclejava.spring.sample;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

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
			
			// 실제 업로드
			file.transferTo(uploadFile);

			return "upload/singlesuccess";
		}
		else {

			return "redirect:/upload/single";
		}		
	}
	
	@RequestMapping(value="/upload/multi", method=RequestMethod.GET)
	public String multiUpload(Map<String, Object> model) {
		model.put("formUpload", new FileUpload());
		
		return "upload/multi";
	}
	
	@RequestMapping(value="/upload/multi", method=RequestMethod.POST)
	public String multiUpload(Map<String, Object> model, FileUpload fileUpload) throws IllegalStateException, IOException {
		
		
		List<FileInfo> list = new ArrayList<FileInfo>();
		
		CommonsMultipartFile[] files = fileUpload.getFiles();
		for(CommonsMultipartFile file : files) {
			
			if(!file.getOriginalFilename().isEmpty() && !file.isEmpty()) {
				File uploadFile = new File("c:/upload/", file.getOriginalFilename());
				
				// 실제 업로드
				file.transferTo(uploadFile);
				
				FileInfo fi = new FileInfo();

				fi.setFilename(file.getOriginalFilename());
				fi.setFiletype(file.getContentType());
				fi.setFilesize(file.getSize());
							
				list.add(fi);				
			}
			else {

				return "redirect:/upload/multi";
			}
		}
		
		
		model.put("fileList", list);
		
		return "upload/multisuccess";
	}
	
}
