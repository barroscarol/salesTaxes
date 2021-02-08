# API - SalesTaxes


## Api - Para calculo e impressão de Receitas com e sem impostos.

[Requisitos]
    
    Obrigatórios:
    * BackEnd Desenvolvido em java.
   

### Criação da Arquietura do projeto

<br>

<b>OOP - Conceito de Interface x Implementação.</b>

No desenvolvimento da aplicação as Classes estão sendo implementadas por Interfaces. Assim, as Interfaces serão utilizadas como um contrato "simples" estabelecendo que cada classe que as implementem são obrigadas a implementar seus métodos.

Como iremos implementar cada Entidade principal, vamos desenvolver seus métodos e por fim a Interface poderá ser substituida pela classe na qual está sendo implementada,utilizando conceitos do <b>SOLID</b>.

O projeto foi dividido em três Entidades principais, essas são as classes de level mais alto que irão implementar em sequencia as interfaces.

Na classe mais alta <b>ItemBasket</b> estão os produtos, os produtos serão colocados na calsse ShoppingCart e por último calculados de acordo com a classe de ServiceTaxCalculator.

   * ItemBasket implementa ItemBasketInterface
   * ShoppingCart implementa ShoppingCartInterface
   * ServiceTaxCalculator implementa TaxCalculatorInterface

Implementando por interfaces evitamos o alto acomplamento entre Implementação e Classes concretas.

</br>

<b>[Entidade ItemBasket - Camada de Domínio ]</b>

<br>" Quando eu faço uma compra eu recebo um "recibo",que lista o nome de todos os meus ítens e seus preços, incluindo suas taxas "</br>

{
<br> O produto possui um preço - private float priceForItem;</br>
<br> O produto possui um nome - String nameOfItem;</br>
<br> O produto possui uma Categoria - ItemCategories itemCategory;</br>
}

      
    Requisitos Funcionais :
    *  "priceForItem","nameOfItem" e "ItemCategories" precisam estar Preenchidos.
    

<b>[Entidade ServiceTaxCalculator - Camada de Domínio ]</b>

<br>"Uma taxa básica de compra é aplicada em 10% em todos os produtos, exceto em livros, comida e insumos médicos."</br>
<br>"Para produtos importados uma taxa adicional é aplicada em 5%, sem exceções"</br>

{
<br> * A taxa possui um %.</br>
<br> * A taxa possui uma categoria.</br>
}
     
    Requisitos Funcionais :
    *  "Obrigatoriamente a taxa deve ter uma categoria."
    *  "As opções de taxas mediante as regras de negócios estão em TaxCategories e são : " 
        - BASIC_TAX -> taxa de 10%.
        - IMPORTED_TAX -> taxa de 5% em produtos importados.
        - EXEMPT_FROM_TAX -> Significa que o produto está isento de taxação. Taxa de valor 0%.
        - BOTH_TAXES -> Quando o produto terá a taxa de 10% com o acrescimo de 5% no caso de ser um produto exportado.   
 
 
<b>[Entidade  ShoppingCart- Camada de Domínio ]</b>

<br>"Quando eu faço uma compra com o meu carrinho, no meu recibo constam : A lista dos items + suas taxas, o total das minhas compras e o total de taxas pagas, assim como em  uma nota fiscal ."</br>

{
<br>"No meu carrinho devem constar a lista de Items de compras"</br>
<br>"No meu carrinho deve se constar as taxas de compras "</br>
<br>"No meu carrinho deve ser demostrado o total de compras  "</br>
}

    Requisitos Funcionais :
    *  "Obrigatoriamente o carrinho deve possuir items, taxas e o total das compras ."
        
[<b>Caso de Teste Input 1</b>]
    
    Obrigatórios :
    * Input 1:  1 book at 12,49,1 music CD at 14,99,1 chocolate bar at 0,85.
    * Output 1: 1 book: 12,49,1 music CD: 16,49,1 chocolate bar: 0,85,Sales Taxes: 1.50,Total: 29.83.

![image](https://user-images.githubusercontent.com/52337111/107251729-71236500-6a13-11eb-9a4c-393f872cfd9a.png)

[<b>Caso de Teste Input 2</b>]
    
    Obrigatórios :
    * Input 2:  1 imported box of chocolates at 10,00,1 imported bottle of perfume at 47,50.
    * Output 2: 1 imported box of chocolates: 10,50,1 imported bottle of perfume: 54,65,Sales Taxes: 7.65,Total: 65.15

![image](https://user-images.githubusercontent.com/52337111/107253318-f4918600-6a14-11eb-9c8f-8163341f30cf.png)

[<b>Caso de Teste Input 3</b>]
    
    Obrigatórios :
    * Input 3:  1 imported bottle of perfume at 27,99,1 bottle of perfume at 18,99,1 packet of headache pills at 9,75,1 imported box of chocolates at 11,25.
    * Output 3: 1 imported bottle of perfume: 32.19,1 bottle of perfume: 20,89,1 packet of headache pills: 9,75,1 imported box of chocolates: 11,85,Sales Taxes: 6,70,Total:    74,68.

![image](https://user-images.githubusercontent.com/52337111/107255168-ca40c800-6a16-11eb-8098-1b6e3615c0ef.png)


## Requisitos para a Instalação.
* Java 8 ou superior
* Git
* Maven
      
    Instalação :
    *  Git clone : https://github.com/barroscarol/salesTaxes.git
    *  Mvn clean install
    *  Maven Update nas dependencias do projeto.

## How
Acessos:

* `A API está funcionando a partir da classe Main de teste, não existem configurações adicionais para instalação.`

## Estrutura da API

A Api foi construida respeitando a arquitetura do Spring, suas injeções foram feitas com o Google Guice, uma outra opção seria utilizar a estrutura de injeção automática do Spring @Autowired.


 SalesTaxesApp 
```
SalesTaxes
├── src
│   ├── com.salestaxes
|       ├── SalesTaxesApplication.java
│   ├── com.salestaxe.module
|       ├── InjectorFactory.java
|       ├── ShoppingModules.java
│   ├── com.salestaxes.items
|       ├── ItemBasket.java
|       ├── ItemBasketInterface.java
|       com.salestaxes.items.enums
|       ├── ItemCategories.java
│   ├── com.salestaxes.shoppingcart
│       ├── ShoppingCart.java
│       ├── ShoppingCartInterface.java
|   ├── com.salestaxes.taxes
│       ├── ServiceTaxCalculator.java
│       ├── TaxCalculatorInterface.java
│   ├── com.salestaxes.taxes.enums
│       ├── TaxCategories.java
├── src/test/java
│   ├── com.salestaxes
|       ├── Main.java
|       ├── SalesTaxesApplicationTests.java

```

## Status
Project is: _in progress
to_do : testes unitários 



## Contact
Created by [@barroscarol](https://github.com/barroscarol) - Feel free to talk !
