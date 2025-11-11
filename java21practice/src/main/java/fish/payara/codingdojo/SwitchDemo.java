package fish.payara.codingdojo;

import java.util.List;

public class SwitchDemo {
    public static void main(String[] args) {
        List<Object> listOfRecords = List.of(
            new RecordsTest("record1"),
            new RecordsTest("record2"),
            new RecordsTest("record3"),
            new RecordsTest("record4"),
            new RecordsTest("5"),
            "record6"
        );
        
        for (Object object : listOfRecords) {
            if (!(object instanceof RecordsTest record)) {
                continue;
            }
            
            int x = switch (record.path()) {
                case "record1" -> 1;
                case "record2" -> 2;
                case "record3" -> 3;
                case null, default -> 0;
            };
            System.out.println(x);
            
            switch (object) {
                case RecordsTest record2 when record2.path().startsWith("record") -> {
                    System.out.println("Starts with \"record\".");
                }
                case null, default -> System.out.println("object is null or unknown");
            }
        }
        
        List<RecordType> recordTypes = List.of(
            RecordType.TYPE_1,
            RecordType.TYPE_2,
            RecordType.TYPE_3,
            RecordType.TYPE_4
        );
        
        for (RecordType type : recordTypes) {
            String typeString = switch (type) {
                case TYPE_1 -> "Type 1";
                case TYPE_2 -> "Type 2";
                case TYPE_3 -> "Type 3";
                case null, default -> "Unknown Type";
            };
            System.out.println(typeString);
        }
    }
    
    public enum RecordType {
        TYPE_1,
        TYPE_2,
        TYPE_3,
        TYPE_4
    }
}
