# MANUAL DO USUÁRIO  
## Sistema de Gerenciamento de Documentos – JavaFX/Maven (JavaFX + MVC)

---

## 1. Introdução

Este manual tem o objetivo de orientar o usuário final a instalar, abrir e utilizar o Sistema de Gerenciamento de Documentos, disponibilizado no GitHub em formato `.zip`.  
O sistema foi desenvolvido em JavaFX utilizando Maven e segue o padrão arquitetural MVC.

O sistema permite:

- Cadastrar novos documentos  
- Visualizar todos os documentos  
- Editar documentos existentes  
- Excluir documentos  

Tudo isso por meio de uma interface simples e direta.

---

## 2. Como Obter e Executar o Sistema

### 2.1 Download do Projeto
- Acesse o repositório do projeto no GitHub.  
- Clique em **Code → Download ZIP**.  
- Extraia o conteúdo para qualquer pasta do seu computador.

### 2.2 Abrir o Projeto na IDE

O sistema pode ser aberto em IDEs como:

- IntelliJ IDEA (recomendado)  
- Eclipse (com suporte Maven)  
- NetBeans  

**Passos no IntelliJ IDEA:**
1. Abra o IntelliJ  
2. Clique em **Open**  
3. Selecione a pasta extraída do projeto  
4. Aguarde o IntelliJ baixar as dependências Maven  
5. Confirme se o Maven importou corretamente o JavaFX  

### 2.3 Executar o Sistema
1. Navegue até o pacote principal do sistema  
2. Abra a classe:  
   **DocumentosApplication**  
3. Execute a classe (clique no ícone ▶ ou em *Run*)  

A interface gráfica JavaFX será aberta automaticamente.

---

## 3. Visão Geral da Interface

Ao executar o sistema, a tela principal exibirá:

### 3.1 Tabela de Documentos
- Lista todos os documentos cadastrados  
- Ao clicar em um documento, seus dados são exibidos nos campos do formulário  
- Permite editar e excluir documentos existentes  

### 3.2 Botões Superiores

| Botão   | Função |
|---------|--------|
| **Novo**   | Limpa os campos para criar um novo documento |
| **Salvar** | Salva um novo documento ou atualiza o selecionado |
| **Excluir**| Remove o documento selecionado na tabela |

---

## 4. Funcionalidades do Sistema

### 4.1 Criar um Novo Documento
1. Clique no botão **Novo**  
2. Os campos do formulário ficarão vazios  
3. Preencha as informações desejadas  
4. Clique em **Salvar**  
O documento aparecerá automaticamente na tabela.

> **Observação:** Campos obrigatórios devem estar preenchidos para salvar.

### 4.2 Visualizar Todos os Documentos
- Assim que o sistema inicia, a tabela já mostra todos os documentos cadastrados  
- Você pode rolar a tabela para ver todos os registros  
- Ao clicar em uma linha da tabela, os dados são carregados nos campos acima  

### 4.3 Editar um Documento Existente
1. Clique em um documento da tabela  
2. Os dados dele aparecerão nos campos do formulário  
3. Altere as informações desejadas  
4. Clique em **Salvar**  
O documento será atualizado imediatamente na tabela.

### 4.4 Excluir um Documento
1. Clique em um documento da tabela  
2. Verifique se os dados apareceram nos campos  
3. Clique no botão **Excluir**  
O sistema apagará o documento permanentemente da lista.

---

## 5. Mensagens de Aviso e Erros

O sistema pode exibir mensagens como:

- **“Preencha todos os campos obrigatórios”**  
  → Preencha os dados antes de salvar  

- **“Documento salvo com sucesso”**  
  → O cadastro ou edição foi concluído corretamente  

- **“Nenhum documento selecionado”**  
  → Só é possível excluir se houver um documento selecionado na tabela  

---

## 6. Dicas de Uso
- Sempre clique em **Novo** se quiser cadastrar um documento do zero  
- Para editar, basta selecionar da tabela e salvar  
- Atualize a lista clicando novamente na tabela, caso necessário  
- Ao excluir, revise cuidadosamente o documento selecionado  
- Evite deixar campos vazios para manter os dados consistentes  

---

## 7. Suporte e Problemas Comuns

### Problema: O projeto não abre na IDE
- Verifique se o Java 17+ está instalado  
- Certifique-se de que a pasta `.idea` ou `pom.xml` não foram modificadas  

### Problema: O JavaFX não inicia
- Confirme que o Maven baixou todas as dependências  
- Verifique se a IDE está configurada com o JDK correto  

### Problema: A tabela aparece vazia
- Pode ser porque ainda não há documentos cadastrados  
- Tente criar um documento clicando em **Novo** e depois **Salvar**  


