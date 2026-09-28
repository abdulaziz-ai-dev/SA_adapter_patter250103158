public class LocalStorageBlobAdapter implements ICloudBlobStorage {
    private LocalDiskFileSystem fileSystem;

    public LocalStorageBlobAdapter(LocalDiskFileSystem fileSystem) {
        this.fileSystem = fileSystem;
    }

    public boolean uploadBlob(String bucketName, String objectKey, byte[] data) {
        String fullPath = "/var/data/" + bucketName + "/" + objectKey;

        while (fullPath.contains("//")) {
            fullPath = fullPath.replace("//", "/");
        }

        return fileSystem.saveToPath(fullPath, data);
    }
}