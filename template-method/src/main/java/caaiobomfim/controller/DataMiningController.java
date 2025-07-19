package caaiobomfim.controller;

import caaiobomfim.service.CsvDataMiner;
import caaiobomfim.service.DocDataMiner;
import caaiobomfim.service.PdfDataMiner;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mine")
public class DataMiningController {

    private final DocDataMiner docDataMiner;
    private final CsvDataMiner csvDataMiner;
    private final PdfDataMiner pdfDataMiner;

    public DataMiningController(DocDataMiner docDataMiner, CsvDataMiner csvDataMiner, PdfDataMiner pdfDataMiner){
        this.docDataMiner = docDataMiner;
        this.csvDataMiner = csvDataMiner;
        this.pdfDataMiner = pdfDataMiner;
    }

    @PostMapping("/doc")
    public void mineDoc(@RequestBody String path) {
        docDataMiner.mine(path);
    }

    @PostMapping("/csv")
    public void mineCsv(@RequestBody String path) {
        csvDataMiner.mine(path);
    }

    @PostMapping("/pdf")
    public void minePdf(@RequestBody String path) {
        pdfDataMiner.mine(path);
    }
}