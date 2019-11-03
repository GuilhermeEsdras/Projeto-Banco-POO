<!-- Logotipo do Projeto -->
<p align="center">
  <a href="https://github.com/guilhermeesdras/projeto-banco-poo">
    <img src="images/Projeto Banco Logotipo.png" alt="Logo">
  </a>
</p>

---

<!-- Glossário -->
## Glossário
- [Glossário](#gloss%c3%a1rio)
- [Sobre o Projeto](#sobre-o-projeto)
- [Premissas](#premissas)
- [Funcionalidades do Projeto](#funcionalidades-do-projeto)
- [Fluxogramas e Diagramas](#fluxogramas-e-diagramas)
- [Contato](#contato)
- [Licença](#licen%c3%a7a)

---
<!-- Descrição do projeto -->
## Sobre o Projeto

 Projeto pessoal criado com a finalidade de por em prática todos os tópicos abordados pela disciplina de Programação Orientada à Objetos (POO).

---
<!-- Premissas e Conceitos -->
## Premissas

> Lógica usada para modelar as classes e objetos deste projeto.

- Um Banco é uma PessoaJurídica e possui uma (lista de) Agências contendo (lista de) Funcionários e (lista de) Clientes; <br/>
- Uma Agência faz parte de um Banco, é uma PessoaJurídica e possui uma (lista de) Clientes e uma (lista de) Funcionários; <br/>
- Um Cliente é um tipo genérico e faz parte de uma Agência (e consequentemente do Banco desta Agência), é uma PessoaFísica e possui Conta(s) (uma poupança e/ou uma corrente); <br/>
- Um Funcionário é um tipo genérico e faz parte de uma Agência (e consequentemente do Banco desta Agência) e, dependendo do seu tipo mais específico (cargo), pode relizar alterações nos Clientes e suas respectivas Contas.

---
<!-- -->
## Funcionalidades do Projeto
Assuntos da disciplina de Programação Orientada a Objetos *(que devem ser)* colocados em prática nesse projeto:

- Construção do Projeto:
  - [x] Automação com Maven
  - [x] Organização do Projeto em Módulos
  - [x] Criação de Diagramas UML
  - [x] Documentação e Comentários

- Específicos da Linguagem Java:
  - Estrutura Sequencial:
    - [x] Uso de Expressões Aritméticas
    - [x] Uso de Funções matemáticas
    - [x] Uso de Casting
    - [x] Uso de todos os tipos básicos de variáveis
    - [x] Uso de manipuladores de entrada e saída de dados
  - Estrutura Condicional:
    - [x] Uso de Expressões comparativas
    - [x] Uso de Expressões lógicas
    - [x] Uso de Estruturas condicionais (if-else)
    - [x] Uso de incrementadores (++ --)
    - [x] Uso de Switch-case
    - [x] Uso de Condicional ternária ( expressão ? Sim : Não )
  - Estruturas Repetitivas:
    - [x] Uso de while / do while
    - [x] Uso de for
    - [x] Uso de for each
  - Listas:
    - [x] Uso de LinkedList e/ou ArrayList
    - [x] Uso de Array
    - [ ] Uso de Vector
  - Tópicos Especiais
    - [x] Manipulação de Datas
    - [x] Uso do Apache Utils e funções úteis
    - [ ] Uso de operadores bitwise

- Específicos da Disciplina de Orientação a Objetos:
  - [x] Construtores, Sobrecarga e Encapsulamento
  - [x] Tipo Enum
  - Herança e Polimorfismo
    - [x] Uso de Herança (extends)
    - [x] Uso de Classes e métodos abstratas
  - [x] Tratamento de Exceções (try-catch-finally)
  - Arquivos:
    - [ ] FileReader/BufferedReader  +  FileWriter/BufferedWriter
    - [x] Uso de try-with-resources
  - Interfaces:
    - [x] Uso de Interfaces
    - [x] Uso de Interface Comparable
    - [x] Uso de Default methods
  - Generics, Set, Map:
    - [x] HashCode e Equals
    - [x] CompareTo
    - [x] Uso de Sets
    - [x] Uso de Maps
  
- Programação Funcional e Expressões Lambda:
  - [x] Uso de Comparador com expressão lambda
  - [x] Uso de cálculos lambda
  - [x] Uso de Interface funcional
  - [x] Uso de Predicate
  - [x] Uso de Consumer
  - [x] Uso de Function
  - [x] Uso de Stream

Extras:
- [ ] Implementação de Banco de Dados
- [x] Criação de Interface Gráfica (com JavaFX e/ou Swing)

---
<!-- Fluxogramas e Diagramas -->
## Fluxogramas e Diagramas

Mapas e maquetes do projeto.
> Alguns estão incompletos, outros faltam implementar.

<p align="center">
  <a href="https://github.com/guilhermeesdras/projeto-banco-poo">
    <img src="images/Diagramas/Diagrama de Atividade de Saque em Conta.png" alt="Diagrama de Atividade de Saque em Conta">
  </a>
</p>

---
<!-- Contato -->
## Contato

Guilherme Esdras - [@guihesdras](https://instagram.com/guihesdras) - guilherme.esdras@outlook.com

Link do Projeto: [https://github.com/guilhermeesdras/projeto-banco-poo](https://github.com/guilhermeesdras/projeto-banco-poo)

---
<!-- Licença de uso -->
## Licença

[![License](http://img.shields.io/:license-mit-blue.svg?style=flat-square)](http://badges.mit-license.org)

- **[MIT license](http://opensource.org/licenses/mit-license.php)**
- Copyright 2019 © <a href="http://guilhermeesdras.tk" target="_blank">Guilherme Esdras</a>.