public interface ICloudBlobStorage {
    boolean uploadBlob(String bucketName, String objectKey, byte[] data);
}