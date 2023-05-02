package com.aorri2.goodsforyou.productimage.infrastructure.storage;

import org.springframework.web.multipart.MultipartFile;

public interface StorageService {

	String upload(MultipartFile file, String fileName);
}
