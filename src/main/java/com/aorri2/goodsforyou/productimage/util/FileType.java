package com.aorri2.goodsforyou.productimage.util;

import java.util.Arrays;

public enum FileType {

	PNG("png"),
	JPEG("jpeg"),
	JPG("jpg"),
	GIF("gif");

	private final String extension;

	FileType(String extension) {
		this.extension = extension;
	}

	public String getExtension() {
		return extension;
	}

	public static boolean isNotSupportedType(String extension) {
		return Arrays.stream(FileType.values())
			.anyMatch(type -> type.getExtension().equals(extension));
	}
}
