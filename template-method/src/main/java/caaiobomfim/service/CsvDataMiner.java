package caaiobomfim.service;

import caaiobomfim.DataMiner;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class CsvDataMiner extends DataMiner {

    protected String openFile(String path){
        System.out.print("OPEN FILE");
        return "File content CSV";
    }

    protected List<String> extractData(String fileContent){
        System.out.print("EXTRACT");
        return Collections.singletonList("raw_data_csv");
    }

    protected List<String> parseData(List<String> rawData){
        System.out.print("PARSE");
        return Collections.singletonList("parsed_data_csv");
    }
}