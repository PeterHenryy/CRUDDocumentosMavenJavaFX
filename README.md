MANUAL DO USUÁRIO
 Sistema de Gerenciamento de Documentos – JavaFX/Maven (JavaFX + MVC)
 1. Introdução
 Este manual tem o objetivo de orientar o usuário final a instalar, abrir e utilizar o Sistema de
 Gerenciamento de Documentos, disponibilizado no GitHub em formato .zip. O sistema foi
 desenvolvido em JavaFX utilizando Maven e segue o padrão arquitetural MVC.
 O sistema permite:
 Cadastrar novos documentos
 Visualizar todos os documentos
 Editar documentos existentes
 Excluir documentos
 Tudo isso por meio de uma interface simples e direta.
 2. Como Obter e Executar o Sistema
 2.1 Download do Projeto
 Acesse o repositório do projeto no GitHub.
 Clique em Code !’ Download ZIP.
 Extraia o conteúdo para qualquer pasta do seu computador.
 2.2 Abrir o Projeto na IDE
 O sistema pode ser aberto em IDEs como:
 IntelliJ IDEA (recomendado)
 Eclipse (com suporte Maven)
 NetBeans
 Passos em IntelliJ IDEA:
 Abra o IntelliJ
 Clique em Open
 Selecione a pasta extraída do projeto
 Aguarde o IntelliJ baixar as dependências Maven
 Confirme se o Maven importou corretamente o JavaFX
 2.3 Executar o Sistema
 Navegue até o pacote principal do sistema
 Abra a classe:
 DocumentosApplication
 Execute essa classe (clique no ícone % o¶u Run)
 A interface gráfica JavaFX será aberta automaticamente
 3. Visão Geral da Interface
 Ao executar o sistema, a tela principal exibirá:
 3.1 Tabela de Documentos
 Lista todos os documentos cadastrados
 Ao clicar em um documento, seus dados são exibidos nos campos do formulário
 Permite editar e excluir documentos existentes
 3.2 Botões Superiores
 No topo da aplicação existem 3 botões principais:
 Botão F u n ção
 Novo L i m pa os campos para criar um novo documento
 Salvar S a l va um novo documento ou atualiza o selecionado
 Excluir R e m ove o documento selecionado na tabela
4. Funcionalidades do Sistema
 4.1 Criar um Novo Documento
 Clique no botão Novo
 Os campos do formulário ficarão vazios
 Preencha as informações desejadas
 Clique em Salvar
 O documento aparecerá automaticamente na tabela
 Observação: Campos obrigatórios devem estar preenchidos para salvar.
 4.2 Visualizar Todos os Documentos
 Assim que o sistema inicia, a tabela já mostra todos os documentos cadastrados
 Você pode rolar a tabela para ver todos os registros
 Ao clicar em uma linha da tabela, os dados do documento são carregados nos campos acima
 4.3 Editar um Documento Existente
 Clique em um documento da tabela
 Os dados dele aparecerão nos campos do formulário
 Altere as informações desejadas
 Clique em Salvar
 O documento será atualizado imediatamente na tabela
 4.4 Excluir um Documento
 Clique em um documento da tabela
 Verifique se os dados apareceram nos campos
 Clique no botão Excluir
 O sistema apagará o documento permanentemente da lista
 5. Mensagens de Aviso e Erros
 O sistema pode exibir mensagens como:
 “Preencha todos os campos obrigatórios”
 !’ Preencha os dados antes de salvar
 “Documento salvo com sucesso”
 !’ O cadastro ou edição foi feita corretamente
 “Nenhum documento selecionado”
 !’ Tente excluir apenas quando um documento estiver selecionado na tabela
 6. Dicas de Uso
 Sempre clique em Novo se quiser cadastrar um documento do zero
 Para editar, basta selecionar da tabela e salvar
 Atualize a lista clicando novamente na tabela caso necessário
 Ao excluir, revise cuidadosamente o documento selecionado
 Evite deixar campos vazios para manter os dados consistentes
 7. Suporte e Problemas Comuns
 Problema: O projeto não abre na IDE
 Verifique se o Java 17+ está instalado
 Certifique-se de que a pasta .idea ou pom.xml não foram modificadas
 Problema: O JavaFX não inicia
 Confirme que o Maven baixou todas as dependências
 Verifique se a IDE está configurada para usar o JDK correto
 Problema: A tabela aparece vazia
 Pode ser porque ainda não há documentos cadastrados
 Tente criar um documento clicando em Novo e após isso Salvar
