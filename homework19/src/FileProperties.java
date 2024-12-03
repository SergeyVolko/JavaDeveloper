public class FileProperties {
    private long timeWrite;
    private long fileSize;

    public FileProperties(long timeWrite, long fileSize) {
        this.timeWrite = timeWrite;
        this.fileSize = fileSize;
    }

    public long getTimeWrite() {
        return timeWrite;
    }

    public long getFileSize() {
        return fileSize;
    }
}
