# 🧱 Design Pattern: Template Method

## 📌 Descrição
O **Template Method** é um padrão de projeto comportamental que define o esqueleto de um algoritmo na superclasse, mas permite que as subclasses sobrescrevam etapas específicas do algoritmo sem alterar sua estrutura.

Ele é útil quando temos várias classes que seguem uma **mesma sequência de passos**, mas que possuem **diferenças em etapas específicas**. Esse padrão evita duplicação de código e promove maior reutilização.

## 🛠️ Problema no sistema original

Imagine que trabalhamos em uma empresa de mineração de dados. Os usuários fazem uploads de arquivos `.doc`, `.csv` e `.pdf`, e o sistema:

1. Abre o arquivo
2. Extrai os dados
3. Faz o parse dos dados
4. Analisa os dados
5. Gera um relatório
6. Envia esse relatório

Inicialmente, criamos uma classe `DocDataMiner` (v1.0), depois `CSVDataMiner` (v2.0) e por fim `PDFDataMiner` (v3.0). No entanto, todas essas classes seguiam a **mesma estrutura** no método `mine()` e apenas mudavam em como extraíam e parseavam os dados.

Com o crescimento do sistema, percebemos que estávamos **repetindo muito código** entre as classes e que isso tornava a manutenção difícil e arriscada.

---

## ❌ Antes do uso do Template Method

Cada classe (Doc, CSV, PDF) implementava o método `mine()` com os mesmos passos, mas com trechos diferentes em `extractData` e `parseData`. O restante era exatamente igual:

```java
public void mine(String path) {
    String fileContent = this.openFile(path);
    List<String> rawData = this.extractCsvData(fileContent);
    List<String> data = this.parseCsvData(rawData);
    List<String> analysisResult = this.analyseData(data);
    sendReport(analysisResult);
}
```

Esse modelo gerava duplicação de lógica, dificultava manutenções e corria o risco de alguém alterar a sequência incorretamente em uma das classes.

## ✅ Após refatoração com Template Method
Foi criada uma classe abstrata DataMiner com o método mine() centralizado, contendo a sequência do processo (template). As etapas variáveis (extractData, parseData) foram transformadas em métodos abstratos:

```bash
public abstract class DataMiner {
    public final void mine(String path) {
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
```

E as classes concretas apenas sobrescrevem os métodos específicos:

```bash
public class DocDataMiner extends DataMiner {
    protected List<String> extractData(String fileContent){
        System.out.print("EXTRACT");
        return Collections.singletonList("raw_data_doc");
    }
    protected List<String> parseData(List<String> rawData){
        System.out.print("PARSE");
        return Collections.singletonList("parsed_data_doc");
    }
}
```

## 🔄 Benefícios obtidos com o padrão Template Method
- ✅ Evita duplicação de código
- ✅ Garante a ordem de execução dos métodos
- ✅ Facilita manutenção e adição de novos formatos
- ✅ Centraliza lógica comum na superclasse
- ⚠️ Requer cuidado com uso excessivo de herança

## 🧱 Considerações finais
O Template Method é útil quando já temos duplicações claras e uma estrutura bem definida de passos. Não é recomendado aplicá-lo prematuramente, sem necessidade real. Ele deve ser utilizado como uma solução para um problema, e não como ponto de partida do projeto.

## 🔗 Referência
Documentação completa: https://refactoring.guru/design-patterns/template-method

---