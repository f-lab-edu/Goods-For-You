package com.aorri2.goodsforyou.productimage.util;

import java.util.Arrays;
import java.util.List;

public enum FileType {

	PNG("png"),
	JPEG("jpeg"),
	JPG("jpg"),
	GIF("gif");

	private final String extension;

	private static final List<String> SUPPORTED_EXTENSIONS = Arrays.stream(FileType.values())
		.map(FileType::getExtension)
		.toList();

	FileType(String extension) {
		this.extension = extension;
	}

	public String getExtension() {
		return extension;
	}

	public static boolean isNotSupportedType(String extension) {
		return !SUPPORTED_EXTENSIONS.contains(extension);
	}
}
