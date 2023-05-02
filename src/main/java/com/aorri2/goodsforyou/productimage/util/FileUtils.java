package com.aorri2.goodsforyou.productimage.util;

import static com.aorri2.goodsforyou.productimage.util.FileType.*;

import java.util.UUID;

import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.aorri2.goodsforyou.productimage.domain.exception.UnSupportedFileTypeException;

public class FileUtils {

	private FileUtils() {
	}
	
	public static String getRandomFileName() {
		return UUID.randomUUID().toString();
	}

	public static String getFilePath(MultipartFile file, String fileName) {
		String extension = StringUtils.getFilenameExtension(file.getOriginalFilename());

		if (!isNotSupportedType(extension)) {
			throw new UnSupportedFileTypeException();
		}

		return fileName + "." + extension;
	}

}
