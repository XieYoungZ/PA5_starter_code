public class FileData {

    public String name; // the name of the file
    public String dir; // the directory that the file is in
    public String lastModifiedDate; // last modified date of file in string

    /**
     * If name is null, set it to "" If dir is null, set it to "/" the root
     * directory
     */
    public FileData(String name, String directory, String modifiedDate) {
        this.name = name;
        this.dir = directory;
        this.lastModifiedDate = modifiedDate;
    }

    public String toString() {
        return "{Name: " + name + ", Directory: " + dir + ", Modified Date: " + lastModifiedDate + "}";
    }
}
