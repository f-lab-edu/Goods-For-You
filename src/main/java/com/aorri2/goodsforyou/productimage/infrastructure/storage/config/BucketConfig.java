package com.aorri2.goodsforyou.productimage.infrastructure.storage.config;

public class BucketConfig {
	private final String bucket;

	public BucketConfig(String bucket) {
		this.bucket = bucket;
	}

	public String getBucket() {
		return bucket;
	}
}
