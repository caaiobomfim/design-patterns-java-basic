# 🎯 Design Patterns

Este repositório contém implementações práticas e básicas dos principais **Design Patterns** usando **Java** e **Spring Boot**, organizados de forma modular.

---

## ✅ Padrões implementados

- [x] **Facade** – Extrair e encapsular complexidade, regras de negócio e fluxo do código para melhorar código do cliente.
- [ ] Singleton
- [ ] Strategy
- [ ] Observer
- [ ] Builder
- [ ] Factory Method
- [ ] Abstract Factory
- [ ] Adapter
- [ ] Decorator
- [ ] Command
- [ ] Template Method
- [ ] Chain of Responsibility

Outros:

- [ ] Simple Factory

---

## 🧱 Design Pattern: Facade

### 📌 Descrição
O padrão de projeto Facade tem como principal objetivo fornecer uma interface simples para um subsistema complexo. Ele atua como uma fachada entre o código cliente e a complexidade interna, ocultando detalhes de implementação, instanciamentos de objetos, controle de fluxo e regras de negócio.

Esse padrão facilita o uso do sistema por parte de quem consome a funcionalidade, promovendo desacoplamento, estabilidade e legibilidade.

### 🛍️ Analogia simples
Imagine que você está comprando um produto por telefone. Ao invés de falar com diversos departamentos (financeiro, estoque, expedição, atendimento), você fala com uma pessoa só, que entende o processo inteiro e cuida de tudo para você. Essa pessoa representa a fachada: ela intermedia a comunicação com a complexidade do sistema.

Um exemplo moderno seria o site da Amazon, que é a fachada entre o cliente e todas as operações internas (pagamento, estoque, envio, etc).

### 🧪 Exemplo implementado: sistema de e-commerce
Neste projeto, simulamos um fluxo de pedidos em um sistema de e-commerce. Temos um OrderController que expõe um endpoint POST para criar pedidos, e múltiplos serviços que lidam com etapas específicas:

- PaymentProcessor – processa o pagamento.
- Notifier – envia confirmação ao cliente.
- InventoryManager – atualiza o estoque.
- ShippingService – inicia a entrega.

### ❌ Antes do uso do Facade:
O OrderController injetava diretamente todos esses serviços e era responsável por orquestrar o fluxo. Com isso:

- A complexidade do fluxo ficava no controller.
- Qualquer mudança na ordem das operações exigiria alteração no código cliente.
- O controller era obrigado a conhecer os detalhes da regra de negócio.

### ✅ Após refatoração com Facade:
Criamos a classe OrderFacade, responsável por encapsular toda a complexidade do processo de pedido. Agora o controller apenas chama:

```bash
orderFacade.processOrder(orderRequest);
```

Com isso:

- O controller ficou mais simples e estável.
- A orquestração das etapas ficou centralizada em um único lugar.
- Alterações no fluxo do pedido impactam apenas a OrderFacade, respeitando o princípio da responsabilidade única (SRP – Single Responsibility Principle).

### 🔄 Benefícios obtidos com o padrão Facade
- 📦 Encapsulamento da complexidade.
- 💡 Código cliente mais limpo e focado.
- ⚙️ Facilidade para alteração de fluxos.
- 🧪 Testabilidade e manutenibilidade.
- 🤝 Melhor adesão ao SOLID, especialmente ao SRP.

---

## 🚀 Como executar

1. Clone o projeto:
```bash
git clone https://github.com/seu-usuario/design-patterns-java-basic.git
```

---

## 📚 Referências

- GoF – Design Patterns: Elements of Reusable Object-Oriented Software.
- Refactoring Guru – Facade (https://refactoring.guru/pt-br/design-patterns/facade).

## 📌 Objetivo

Esse repositório tem como objetivo servir como material de estudo prático, com exemplos reais e comentados dos padrões mais utilizados em engenharia de software, seguindo boas práticas e organização de código.

## ‍🧑‍💻 Autor

Desenvolvido por Caio Bomfim.