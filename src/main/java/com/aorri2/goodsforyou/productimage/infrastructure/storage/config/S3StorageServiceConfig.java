package com.aorri2.goodsforyou.productimage.infrastructure.storage.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.services.s3.AmazonS3;
import com.aorri2.goodsforyou.productimage.infrastructure.storage.S3StorageService;
import com.aorri2.goodsforyou.productimage.infrastructure.storage.StorageService;

@Configuration
public class S3StorageServiceConfig {

	@Value("${aws.s3.bucket}")
	private String bucket;

	@Bean
	public BucketConfig bucketConfig() {
		return new BucketConfig(bucket);
	}

	@Bean
	public StorageService s3StorageService(AmazonS3 amazonS3Client, BucketConfig bucketConfig) {
		return new S3StorageService(amazonS3Client, bucketConfig);
	}
}
