package caaiobomfim.service;

import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class DocDataMiner {

    public void mine(String path){
        String fileContent = this.openFile(path);
        List<String> rawData = this.extractDocData(fileContent);
        List<String> data = this.parseDocData(rawData);
        List<String> analysisResult = this.analyseData(data);
        sendReport(analysisResult);
    }

    private String openFile(String path){
        System.out.print("OPEN FILE");
        return "File content DOC";
    }

    private List<String> extractDocData(String fileContent){
        System.out.print("EXTRACT");
        return Collections.singletonList("raw_data_doc");
    }

    private List<String> parseDocData(List<String> rawData){
        System.out.print("PARSE");
        return Collections.singletonList("parsed_data_doc");
    }

    private List<String> analyseData(List<String> data){
        System.out.print("ANALYSE");
        return Collections.singletonList("analysed_data");
    }

    private void sendReport(List<String> analysisResult){
        System.out.print("SEND REPORT");
    }
}