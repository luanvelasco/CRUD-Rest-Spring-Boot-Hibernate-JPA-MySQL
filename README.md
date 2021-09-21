# **CRUD REST utilizando Spring Boot 2, Hibernate, JPA, e MySQ**

O objetivo é desenvolver uma API REST para um CRUD (Criar, Ler, Atualizar e Remover) utilizando Spring Boot 2, Hibernate, JPA e MySQL.


## **A API que será desenvolvida**
Será criado um Controller para uma API de voos que irá expor cinco métodos HTTP (URIs RESTFul) definidos abaixo:

1. Listar todos os voos - @GetMapping(“/flights)
2. Obter um voos específico pelo ID - @GetMapping(“/flights/{id}”)
3. Remover um voos pelo ID - @DeleteMapping(“/flights/{id}”)
4. Criar um novo voos - @PostMapping(“/flights)
5. Atualizar detalhes de um voos - @PutMapping(“/flights/{id}”)

### **Observações**

As anotações são do projeto Lombok que ajuda a manter o código mais limpo e enxuto, pois não é necessário criar os getters/setters e construtores (Eles estarão presentes no arquivo .class quando o código for compilado).

1. **AllArgsConstructor**: cria automaticamente um construtor com todas os atributos da classe como argumento.
2. **NoArgsConstructor**: cria automaticamente um construtor vazio (sem argumentos).
3. **Data**: cria automaticamente os métodos toString, equals, hashCode, getters e setters.

### **Testes da API**
Utilizaremos o swagger para descrever os os recursos que uma API deve possuir, como endpoints, dados recebidos, dados retornados, códigos HTTP e outros.

