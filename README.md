<div align="center">
  <img src="img/logoBootcampJava.jpg">


![GitHub top language](https://img.shields.io/github/languages/top/raul-lima/bootcamp-java-projeto04)<space><space>
![Lines of Code](https://img.shields.io/tokei/lines/github/raul-lima/bootcamp-java-projeto04)<space><space>
![GitHub repo size](https://img.shields.io/github/repo-size/raul-lima/bootcamp-java-projeto04)<space><space>
![Feito por](https://img.shields.io/badge/feito%20por-Raul%20Lima-blueviolet)

 </div align="center">


<p align="center"> Bootcamp Java da Alura - Projeto 04 - Biblioteca API</p>


Tabela de Conteúdos
=================
  <!--ts-->

* [Projeto do módulo 4 do bootcamp java da Alura 2021](#projeto-do-módulo-4-do-bootcamp-java-da-alura-2021)
* [Novas funcionalidades](#novas-funcionalidades)
* [Tecnologias](#tecnologias)
* [Contato](#contato)
  <!--te-->

## Projeto do módulo 4 do bootcamp java da Alura 2021

Trata-se de uma aplicação web em Java para gestão de uma livraria online desenvolvida em módulos:
 * [Módulo 01](https://github.com/raul-lima/bootcamp-java-projeto01)
 * [Módulo 02](https://github.com/raul-lima/bootcamp-java-projeto02) 
 * [Módulo 03](https://github.com/raul-lima/bootcamp-java-projeto03)
  
  A aplicação permite o cadastro, listagem, atualização, remoção e detalhamento de autores e livros no modelo de API, de modo que as informações são consumidas e devolvidas no formato
JSON.
<br>
<br>
A funcionalidade de cadastro de livros realiza as seguintes validações:

* Título deve ser obrigatório e ter no mínimo 10 caracteres;
* Data de lançamento deve ser uma data menor ou igual a data atual;
* O número de páginas deve ser maior ou igual a 100.
  
## Novas funcionalidades
  
  * A camada de persistência foi implementada em um banco de dados local MySQL com Spring Data JPA;
  * Controle de evolução do schema do banco de dados da API utilizando o Flyway como ferramenta de migration;
  * As funcionalidades de listagem de autores e de livros agora possuem o recurso de paginação;
  * A aplicação agora permite a devolução de um relatório em formato JSON que exibe, com base no banco de dados local, uma lista com os autores, a quantidade de livros de cada autor e o percentual de cada autor na composição do acervo bibliográfico;
  * A aplicação agora conta com um CRUD completo, além de uma funcionalidade para pesquisar por um livro ou autor específico por ID;
  * Foi implementada uma classe com métodos para tratamento dos erros 400, 404 e 500 que ocorrem na API;
  * As classes controller, repository e service da API agora contam com testes automatizados usando JUnit, AssertJ e Mockito;
  * A documentação da API é gerada automaticamente com a ferramenta Swagger.


## Tecnologias

Para a construção da aplicação java web foram utilizados:

* Flyway
* Java
* Lombok
* ModelMapper
* MySQL
* Spring Boot
* Swagger

Para testar as funcionalidades da API pode ser utilizada a ferramenta
gratuita [Postman](https://www.postman.com/downloads/). Também é possível realizar os testes por meio da documentação gerada pelo swagger, acessível por meio do seguinte caminho: http://localhost:8080/swagger-ui.html

## Contato

<a href="https://www.linkedin.com/in/raultlima/">
 <img style="border-radius: 50%;" src="https://avatars.githubusercontent.com/u/79487007?s=460&u=61b426b901b8fe02e12019b1fdb67bf0072d4f00&v=4" width="100px;" alt="Raul Lima"/>
<br />
<br />

[![Linkedin Badge](https://img.shields.io/badge/-Raul%20Lima-blue?style=flat-square&logo=Linkedin&logoColor=white&link=https://www.linkedin.com/in/raul-lima-adv/)](https://www.linkedin.com/in/raultlima/)
[![Gmail Badge](https://img.shields.io/badge/-raultorres.lima@gmail.com-c14438?style=flat-square&logo=Gmail&logoColor=white&link=mailto:raultorres.lima@gmail.com)](mailto:raultorres.lima@gmail.com)
