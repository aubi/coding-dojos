package fish.payara.codingdojos.jakarta10view.resources;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.List;

@SessionScoped
@Named("tableBean")
public class TableBean implements Serializable {
    List<String> tableData;

    public TableBean() {
        this.tableData = List.of("Item 1", "<h1>Header</h1>");
    }

    public List<String> getTableData() {
        return tableData;
    }

    public void setTableData(List<String> tableData) {
        this.tableData = tableData;
    }
}
