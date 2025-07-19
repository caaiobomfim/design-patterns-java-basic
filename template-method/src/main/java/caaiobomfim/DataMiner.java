package caaiobomfim;

import java.util.Collections;
import java.util.List;

public abstract class DataMiner {

    public void mine(String path){
        String fileContent = this.openFile(path);
        List<String> rawData = this.extractData(fileContent);
        List<String> data = this.parseData(rawData);
        List<String> analysisResult = this.analyseData(data);
        sendReport(analysisResult);
    }

    protected abstract String openFile(String path);
    protected abstract List<String> extractData(String fileContent);
    protected abstract List<String> parseData(List<String> rawData);

    protected List<String> analyseData(List<String> data){
        System.out.print("ANALYSE");
        return Collections.singletonList("analysed_data");
    }

    protected void sendReport(List<String> analysisResult){
        System.out.print("SEND REPORT");
    }
}
