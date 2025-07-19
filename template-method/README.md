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
7. Fecha o arquivo

Inicialmente, criamos uma classe `DocDataMiner` (v1.0), depois `CSVDataMiner` (v2.0) e por fim `PDFDataMiner` (v3.0). No entanto, todas essas classes seguiam a **mesma estrutura** no método `mine()` e apenas mudavam em como extraíam e parseavam os dados.

Com o crescimento do sistema, percebemos que estávamos **repetindo muito código** entre as classes e que isso tornava a manutenção difícil e arriscada.

---

## ❌ Antes do uso do Template Method

Cada classe (Doc, CSV, PDF) implementava o método `mine()` com os mesmos passos, mas com trechos diferentes em `extractData` e `parseData`. O restante era exatamente igual:

```java
public void mine(String path) {
    File file = openFile(path);
    String rawData = extractDocData(file);
    String data = parseDocData(rawData);
    String analysis = analyzeData(data);
    sendReport(analysis);
    closeFile(file);
}
```

Esse modelo gerava duplicação de lógica, dificultava manutenções e corria o risco de alguém alterar a sequência incorretamente em uma das classes.

## ✅ Após refatoração com Template Method
Foi criada uma classe abstrata DataMiner com o método mine() centralizado, contendo a sequência do processo (template). As etapas variáveis (extractData, parseData) foram transformadas em métodos abstratos:

```bash
public abstract class DataMiner {
    public final void mine(String path) {
        File file = openFile(path);
        String rawData = extractData(file);
        String data = parseData(rawData);
        String analysis = analyzeData(data);
        sendReport(analysis);
        closeFile(file);
    }

    protected File openFile(String path) { return new File(path); }
    protected abstract String extractData(File file);
    protected abstract String parseData(String rawData);
    protected String analyzeData(String data) { return "Analysis of: " + data; }
    protected void sendReport(String report) { System.out.println(report); }
    protected void closeFile(File file) { System.out.println("File closed."); }
}
```

E as classes concretas apenas sobrescrevem os métodos específicos:

```bash
public class DocDataMiner extends DataMiner {
    protected String extractData(File file) { return "DOC raw data"; }
    protected String parseData(String rawData) { return "Parsed DOC"; }
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