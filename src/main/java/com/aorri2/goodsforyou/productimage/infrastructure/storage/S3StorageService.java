package com.aorri2.goodsforyou.productimage.infrastructure.storage;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.util.IOUtils;
import com.aorri2.goodsforyou.productimage.domain.exception.S3StorageFileNotUploadException;
import com.aorri2.goodsforyou.productimage.infrastructure.storage.config.BucketConfig;
import com.aorri2.goodsforyou.productimage.util.FileUtils;

public class S3StorageService implements StorageService {
	private final AmazonS3 amazonS3Client;

	private final String bucket;

	public S3StorageService(AmazonS3 amazonS3Client, BucketConfig bucketConfig) {
		this.amazonS3Client = amazonS3Client;
		this.bucket = bucketConfig.getBucket();
	}

	@Override
	public String upload(MultipartFile file, String fileName) {
		return putObjectToS3Storage(amazonS3Client, FileUtils.getFilePath(file, fileName), file);
	}

	private String putObjectToS3Storage(AmazonS3 amazonS3Client, String filePath, MultipartFile file) {

		ObjectMetadata metadata = setMetadata(file);

		ByteArrayInputStream stream = getByteArrayInputStream(file, metadata);

		amazonS3Client.putObject(new PutObjectRequest(bucket, filePath, stream, metadata)
			.withCannedAcl(CannedAccessControlList.PublicRead));
		return amazonS3Client.getUrl(bucket, filePath).toString();
	}

	private ObjectMetadata setMetadata(MultipartFile file) {
		ObjectMetadata metadata = new ObjectMetadata();
		metadata.setContentLength(file.getSize());
		metadata.setContentType(file.getContentType());
		return metadata;
	}

	private ByteArrayInputStream getByteArrayInputStream(MultipartFile file, ObjectMetadata metadata) {
		byte[] bytes;
		try (InputStream inputStream = file.getInputStream()) {
			bytes = IOUtils.toByteArray(inputStream);
		} catch (IOException e) {
			throw new S3StorageFileNotUploadException(e);
		}
		metadata.setContentLength(bytes.length);
		return new ByteArrayInputStream(bytes);
	}
}
