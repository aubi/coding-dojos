package fish.payara.codingdojo;

public record RecordsTest(String path, String name) {
    public RecordsTest(String path) {
        this(path, path + "/" + path);
    }
}
