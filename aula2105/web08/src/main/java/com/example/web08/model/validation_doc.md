## Como as validações funcionam "por baixo dos panos"?
Utilizou-se várias anotações como ```@NotBlank, @Size, @NotNull``` e ```@Min```. Elas fazem parte de uma especificação do Java chamada Jakarta Bean Validation (anteriormente conhecida como JSR 380).

### Aqui está o que acontece passo a passo nos bastidores:

#### 1. A Implementação (Hibernate Validator)
O Java em si apenas define a "interface" dessas anotações (a especificação). Quando você usa o Spring Boot, ele traz por padrão o Hibernate Validator, que é o motor real que executa o código de validação. (Nota: O Hibernate Validator não precisa de um banco de dados para funcionar, ele avalia os objetos em memória).

#### 2. O Fluxo (Intercepção e Reflection)

* **O Gatilho:** Quando um dado chega da web (um formulário, por exemplo) para ser salvo, o seu Controller geralmente recebe este objeto com uma anotação @Valid ou @Validated (ex: public String save(@Valid Product product, BindingResult result)).

* **Data Binding & Formatação:** Antes de validar, o Spring cria a instância de Product e tenta preencher os campos com os dados da requisição. Nesse momento, a anotação @NumberFormat entra em ação interceptando o texto da moeda que vem do formulário e usando conversores internos para transformar uma string formatada (ex: "1.234,50") em um objeto numérico exato do tipo BigDecimal.

* **Reflection e Execução:** Com o objeto preenchido, o Spring intercepta o fluxo e delega o objeto ao Hibernate Validator. Usando Java Reflection (um recurso que permite ler metadados de uma classe em tempo de execução), o motor lê que no campo name existe uma anotação @NotBlank.

* **Verificação de Regras:** Para cada anotação lida, o validador aciona uma classe validadora correspondente (por exemplo, NotBlankValidator). Ele verifica:
    * ```@NotBlank:``` O campo é diferente de nulo e contém caracteres que não são apenas espaços em branco?
    * ```@Size:``` O comprimento da string está entre os limites (ex: máx de 60 caracteres)?
    * ```@NotNull:``` É diferente de nulo?
    * ```@Min(0):``` O valor numérico é maior ou igual a zero?

* **Acumulando Erros:** Se a regra passar, o fluxo segue. Se falhar, o validador pega a mensagem customizada que você definiu (message = "Product name is required.") e adiciona a uma lista de erros de validação (no Spring, isso vai para o objeto BindingResult). O Controller então decide o que fazer com isso (como devolver o usuário à tela anterior para corrigir).