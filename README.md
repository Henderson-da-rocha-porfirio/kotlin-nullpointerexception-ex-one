# kotlin-nullpointerexception-ex-one

### **Razão para o Erro no Código Original**
No código original, o **erro `NullPointerException`** ocorre devido ao uso do operador **`!!`** em Kotlin, que força o acesso a uma variável que contém `null`. 

---

### **Diferenciando os Cenários**

#### **1. Código Original (Erro no Kotlin):**
```kotlin
val str: String? = null
val str4 = str!!.toUpperCase() // Gera NullPointerException
```

##### **Por que o erro ocorreu?**
- **`!!`**: Força o Kotlin a tratar `str` como **não nulo**. No entanto, `str` é **nulo** (`null`).
- A tentativa de acessar um método (`toUpperCase()`) em um valor `null` causa o erro **`NullPointerException`** no Kotlin.

##### **Consequência:**
- O programa falha e não executa o restante do código.

---

#### **2. Código Corrigido (Kotlin):**
```kotlin
val str: String? = null

// Usando chamada segura com ?.
println("What happens when we do this: ${str?.toUpperCase()}")

// Usando operador Elvis ?: para fornecer um valor padrão
val str2 = str ?: "This is the default value"
println(str2)
```

##### **Por que o erro não ocorreu?**
1. **Operador `?.`:**
   - A chamada `str?.toUpperCase()` verifica se `str` é `null`. 
   - Se for `null`, a expressão retorna `null` em vez de tentar acessar o método `toUpperCase()`.

2. **Operador Elvis `?:`:**
   - A expressão `str ?: "This is the default value"` fornece um valor padrão caso `str` seja `null`.
   - Isso elimina a possibilidade de acessar métodos em valores `null`.

##### **Consequência:**
- O programa continua sua execução sem erros, mesmo que `str` seja `null`.

---

#### **3. Código Java**
```java
String str = null;
str.toUpperCase(); // NullPointerException
```

##### **Por que o erro ocorreu?**
- Diferentemente do Kotlin, o Java **não possui proteções automáticas contra valores `null`**.
- A chamada `str.toUpperCase()` é feita diretamente, sem verificar se `str` é `null`.

##### **Como corrigir no Java?**
Você precisaria verificar manualmente:
```java
String str = null;
if (str != null) {
    System.out.println(str.toUpperCase());
} else {
    System.out.println("str is null");
}
```

---

### **Interoperabilidade Kotlin-Java: Por Que Funciona Sem Alterar a Classe Java?**

A interoperabilidade Kotlin-Java garante que o código Kotlin possa chamar métodos Java diretamente, independentemente do suporte ou tratamento de `null` no Java.

#### **Por que funciona sem alterar a classe Java?**
1. **Platform Types no Kotlin:**
   - Quando você chama um método Java em Kotlin, o compilador Kotlin trata os tipos retornados como **platform types**.
   - Isso significa que o Kotlin não aplica `null safety` automaticamente e deixa ao desenvolvedor a responsabilidade de verificar `null`.

2. **Ferramentas de Kotlin para Null Safety:**
   - No código corrigido, o uso de operadores como `?.` e `?:` garante que `null` seja tratado antes de chamar métodos ou acessar valores.

3. **Exemplo Prático:**
   - A classe Java:
     ```java
     public class NullReferences {
         public static String getNullableString() {
             return null; // Retorna null
         }
     }
     ```
   - O Kotlin pode interagir com ela assim:
     ```kotlin
     val str: String? = NullReferences.getNullableString()
     println(str?.toUpperCase() ?: "Default Value") // Evita NullPointerException
     ```

---

### **Razão para a Diferença Entre o Código Original e o Corrigido**

| **Aspecto**            | **Código Original**                          | **Código Corrigido**                          |
|------------------------|---------------------------------------------|-----------------------------------------------|
| **Uso do Operador `!!`** | Força acesso a `null`, causando exceção.      | Não utiliza `!!`, evita exceções.             |
| **Tratamento de `null`** | Não há tratamento para `null`.               | Usa `?.` e `?:` para tratar valores nulos.    |
| **Interoperabilidade**  | Pode causar erro ao chamar métodos Java.      | Garante segurança ao chamar métodos Java.     |
| **Fluxo do Programa**   | O programa falha ao encontrar `null`.         | O programa continua executando sem falhas.    |

---

### **Resumo da Correção**

1. **Erro no Código Original (Kotlin):**
   - Uso do operador `!!` em uma variável nula.
   - Ocorreu **`NullPointerException`**.

2. **Correção no Kotlin:**
   - Uso de operadores seguros (`?.`, `?:`).
   - Tratamento explícito para valores nulos.

3. **Por Que a Classe Java Não Foi Alterada?**
   - Kotlin é compatível com Java e permite chamadas diretas aos métodos Java.
   - O código corrigido em Kotlin utiliza `null safety` para proteger chamadas Java.

     
4. Saída correta: 

````
What happens when we do this: null
This is the default value
null
null
````
