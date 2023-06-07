package com.aorri2.goodsforyou.productimage.application;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public interface ProductImageFileUploadManagement {

	void upload(Long postId, List<MultipartFile> files);
}
