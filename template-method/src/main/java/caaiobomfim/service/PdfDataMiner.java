package caaiobomfim.service;

import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class PdfDataMiner {

    public void mine(String path){
        String fileContent = this.openFile(path);
        List<String> rawData = this.extractPdfData(fileContent);
        List<String> data = this.parsePdfData(rawData);
        List<String> analysisResult = this.analyseData(data);
        sendReport(analysisResult);
    }

    private String openFile(String path){
        System.out.print("OPEN FILE");
        return "File content PDF";
    }

    private List<String> extractPdfData(String fileContent){
        System.out.print("EXTRACT");
        return Collections.singletonList("raw_data_pdf");
    }

    private List<String> parsePdfData(List<String> rawData){
        System.out.print("PARSE");
        return Collections.singletonList("parsed_data_pdf");
    }

    private List<String> analyseData(List<String> data){
        System.out.print("ANALYSE");
        return Collections.singletonList("analysed_data");
    }

    private void sendReport(List<String> analysisResult){
        System.out.print("SEND REPORT");
    }
}
