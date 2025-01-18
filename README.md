# Manipulação de Arquivos e Pastas com Java
## Repositório para Testes e Estudos em Java
### Este repositório é dedicado ao estudo e prática de manipulação de arquivos e pastas em Java. O objetivo é criar um sistema simples para organização de diretórios escolares, utilizando rotinas que criam, identificam e movem arquivos entre pastas específicas.

## Descrição do Sistema
### O sistema organiza pastas de turmas escolares com base em arquivos criados para cada aluno. Cada arquivo contém informações relevantes, e seu nome inclui uma letra que identifica a turma do aluno. O sistema identifica essa letra e move o arquivo para o diretório correspondente à turma, utilizando o método renameTo.

## Funcionalidades:
### Criação de Arquivos:

#### - Utilizando o File. gero arquivos contendo informações de alunos.
#### - O nome do arquivo inclui a letra identificadora da turma (ex.: 26B.txt, onde B é a turma).
### Identificação da Turma:

#### - O sistema extrai a letra da turma do nome do arquivo.
#### - Um novo repositório será criado(caso não exista) utilizando o mkdirs
### Movimentação de Arquivos:

#### - Usa o método renameTo para mover arquivos para os diretórios correspondentes às turmas.
