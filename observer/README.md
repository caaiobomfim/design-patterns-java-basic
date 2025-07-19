# 🧱 Design Pattern: Observer

## 📌 Descrição
O padrão de projeto **Observer** tem como objetivo permitir que múltiplos objetos "observem" e reajam às mudanças de estado de outro objeto. Ele implementa uma forma de **programação orientada a eventos**, onde os observadores são notificados automaticamente quando algo acontece com o objeto observado.

Também é conhecido por outros nomes como: **PubSub**, **EventListener**, **EventSubscriber**, **PublishSubscriber**, entre outros.

## 🛍️ Analogia simples
- **Fila do iPhone**: Em vez de ir até a loja todos os dias para saber se o novo iPhone já foi lançado, seria mais eficiente se a loja notificasse os interessados assim que o produto estivesse disponível.
- **Assinatura de revista**: Não precisamos ir até a banca verificar a chegada da revista. A publicadora envia a edição diretamente para nosso endereço mensalmente.

Essas analogias representam o comportamento reativo do padrão Observer.

## 💼 Cenário do projeto: Criptomoedas
Neste exemplo, trabalhamos com um sistema que monitora o preço do Bitcoin:

- A classe `Bitcoin` possui um atributo `price`.
- Um método `setPrice` atualiza o valor e notifica os interessados quando houver alteração.
- Uma API fictícia chamada `BinanceAPI` simula a recuperação de preços randômicos.
- Um controller (`BitcoinController`) busca o novo preço e o define no objeto `Bitcoin`.

## 🔔 Problema real resolvido pelo Observer

Ao invés de criar condicionais (if/else) em vários lugares do código para reagir a uma mudança no preço do Bitcoin, utilizamos o padrão Observer para:

- Registrar logs.
- Notificar investidores.
- Atualizar plataformas de notícias.

Essas ações são executadas automaticamente **somente quando o preço muda**.

Além disso, cada observador pode ter **suas próprias regras de negócio**, como:
- Notificar investidores apenas se a variação for superior a 10%.
- Atualizar as notícias apenas se a variação for superior a 20%.

## ❌ Antes do uso do Observer:
No código sem Observer, o controller precisaria conter:

- Várias estruturas `if`.
- Lógicas específicas de negócio.
- Alto acoplamento entre controle e regras.

Esse modelo gera complexidade e dificulta a manutenção.

## ✅ Após refatoração com Observer:
Criamos a interface:

```bash
public interface BitcoinPriceObserver {
    void update(float price);
}
```

E as classes que a implementam:
- BitcoinPriceLogger
- InvestorNotifier
- NewsPlatform

A classe Bitcoin passa a manter uma lista de observadores e notifica-os automaticamente:

```bash
// Dentro de Bitcoin.java
private final List<BitcoinPriceObserver> observers = new ArrayList<>();

public void addObserver(BitcoinPriceObserver observer) {
    observers.add(observer);
}

private void notifyObservers() {
    for (BitcoinPriceObserver observer : observers) {
        observer.update(this.price);
    }
}
```

No método setPrice, a notificação acontece após a alteração de valor:

```bash
public void setPrice(float newPrice) {
    if (this.price != newPrice) {
        this.price = newPrice;
        notifyObservers();
    }
}
```

No controller, os observadores são registrados:

```bash
bitcoin.addObserver(new BitcoinPriceLogger());
bitcoin.addObserver(new InvestorNotifier());
bitcoin.addObserver(new NewsPlatform());
```

## 🔄 Benefícios obtidos com o padrão Observer
- 📡 Código reativo e desacoplado.
- 🔧 Facilidade para adicionar novos comportamentos sem alterar o core.
- 🧪 Melhora na testabilidade e manutenibilidade.
- 🧱 Aderência ao SRP (Single Responsibility Principle).
- 🚪 Aderência ao OCP (Open/Closed Principle): novas funcionalidades via novas classes, sem modificar código existente.

## 🔗 Referência
Documentação completa: https://refactoring.guru/design-patterns/observer

---