package market.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import market.dao.ImageRepository;
import market.domain.Image;

//@RestController
public class ImageController {
	//private final ImageRepository imageDao;
	
	
	
//	@GetMapping("images/{id}")
//	private ResponseEntity<?> getImageById(@PathVariable Long id){
//		Image im = imageDao.findById(id).orElse(null);
//		return ResponseEntity.ok()
//				.header("fileName", im.getOriginalName())
//				.contentType(MediaType.valueOf(im.getContentType()))
//				.contentLength(im.getSize())
//				.body(new InputStreamResource(new ByteArrayInputStream(im.getBytesFile())) {
//				});
//	}


//
//	public ImageController(ImageRepository imageDao) {
//		super();
//		this.imageDao = imageDao;
//	}
	
	


	
}
