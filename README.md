<p align="center">
  <a href="https://github.com/raul-lima/capgemini-desafio-programacao">
    <img src="https://media.cuponeria.com.br/2020/07/63f02582-cupom-de-desconto-alura.png" width="500" height="200" alt="Logo da Alura: mergulhe em tecnologia" />
  </a>
</p>

<div align="center">

![GitHub top language](https://img.shields.io/github/languages/top/raul-lima/capgemini-desafio-programacao)<space><space>
![Lines of Code](https://img.shields.io/tokei/lines/github/raul-lima/capgemini-desafio-programacao)<space><space>
![GitHub repo size](https://img.shields.io/github/repo-size/raul-lima/capgemini-desafio-programacao)<space><space>
![Feito por](https://img.shields.io/badge/feito%20por-Raul%20Lima-blueviolet)

</div>

<p align="center"> Bootcamp Java da Alura - Projeto 02 - Biblioteca </p>

  
Tabela de Conteúdos
=================
  <!--ts-->
  * [Projeto do módulo 2 do bootcamp java da Alura 2021](#projeto-do-módulo-2-do-bootcamp-java-da-alura-2021)
* [Demonstração do funcionamento](#demonstração-do-funcionamento)
  * [Requisição para cadastrar autor em formato JSON](#requisição-para-cadastrar-autor-em-formato-json)
  * [Requisição para listar autor em formato JSON](#requisição-para-listar-autor-em-formato-json)
  * [Requisição para cadastrar livro em formato JSON](#requisição-para-cadastrar-livro-em-formato-json)
  * [Requisição para listar livro em formato JSON](#requisição-para-listar-livro-em-formato-json)
- [Tecnologias](#tecnologias)
- [Contato](#contato)
  <!--te-->

  
## Projeto do módulo 2 do bootcamp java da Alura 2021

Trata-se de uma aplicação web em Java para gestão de uma livraria online.
A primeira parte do projeto (módulo 1) pode ser consultada neste [repositório](https://github.com/raul-lima/bootcamp-java-projeto01).
A aplicação permite o cadastro e a listagem de autores e livros no modelo
de API, de modo que as informações são consumidas e devolvidas no formato JSON.
<br>
<br>
A funcionalidade de cadastro de livros realiza as seguintes validações:

* Título deve ser obrigatório e ter no mínimo 10 caracteres;
* Data de lançamento deve ser uma data menor ou igual a data atual;
* O número de páginas deve ser maior ou igual a 100.
  
## Demonstração do funcionamento
  
  ### Requisição para cadastrar autor em formato JSON

  ![](img/autoresPost.jpg)
  
  ### Requisição para listar autor em formato JSON

  ![](img/autoresGet.jpg)
  
  Para simular o formulário elaborado no projeto do [módulo 1](https://github.com/raul-lima/bootcamp-java-projeto01), o sistema cadastra o autor com todos os atributos, mas não lista o atributo miniCurriculo. Isso é feito por meio da criação de classes DTO.
  
  ---
  
  ### Requisição para cadastrar livro em formato JSON
  
  ![](img/livrosPost.jpg)
  
  ### Requisição para listar livro em formato JSON
  
  ![](img/livrosGet.jpg)
  
  Aqui, novamente, cadastra-se todos os atributos no sistema, mas na hora de listar o atributo miniCurriculo da classe Autor fica oculto para simular o projeto do [módulo 1](https://github.com/raul-lima/bootcamp-java-projeto01).

## Tecnologias 

Para a construção da aplicação java web foram utilizados:

* Java
* API Rest
* Spring Boot
* Lombok
* ModelMapper
* Bean Validation
* DTO pattern

Para testar as funcionalidades da API pode ser utilizada a ferramenta gratuita [Postman](https://www.postman.com/downloads/), conforme demonstrado na seção anterior.


## Contato

<a href="https://www.linkedin.com/in/raultlima/">
 <img style="border-radius: 50%;" src="https://avatars.githubusercontent.com/u/79487007?s=460&u=61b426b901b8fe02e12019b1fdb67bf0072d4f00&v=4" width="100px;" alt="Raul Lima"/>
<br />
<br />

[![Linkedin Badge](https://img.shields.io/badge/-Raul%20Lima-blue?style=flat-square&logo=Linkedin&logoColor=white&link=https://www.linkedin.com/in/raul-lima-adv/)](https://www.linkedin.com/in/raultlima/) 
[![Gmail Badge](https://img.shields.io/badge/-raultorres.lima@gmail.com-c14438?style=flat-square&logo=Gmail&logoColor=white&link=mailto:raultorres.lima@gmail.com)](mailto:raultorres.lima@gmail.com)
