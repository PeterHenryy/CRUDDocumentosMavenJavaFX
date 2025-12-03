package inf.pedro.demo.controller;

import inf.pedro.demo.dao.DocumentoDAO;
import inf.pedro.demo.model.Documento;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

import java.sql.SQLException;
import java.time.LocalDate;

public class DocumentoController {

    @FXML private TextField txtTitulo;
    @FXML private ComboBox<String> cbTipo;
    @FXML private TextField txtAutor;
    @FXML private DatePicker dpData;
    @FXML private TextField txtDescricao;

    @FXML private TableView<Documento> table;
    @FXML private TableColumn<Documento, Number> colId;
    @FXML private TableColumn<Documento, String> colTitulo;
    @FXML private TableColumn<Documento, String> colTipo;
    @FXML private TableColumn<Documento, String> colAutor;
    @FXML private TableColumn<Documento, LocalDate> colData;
    @FXML private TableColumn<Documento, String> colDescricao;

    @FXML private GridPane formPane;

    private final DocumentoDAO dao = new DocumentoDAO();
    private final ObservableList<Documento> dados = FXCollections.observableArrayList();
    
    private Documento documentoSelecionado = null;

    @FXML
    public void initialize() {
        
        cbTipo.setItems(FXCollections.observableArrayList(
                "Livro", "Revista", "Jornal", "Carta"
        ));
        
        formPane.setVisible(false);
        formPane.setManaged(false);
        
        colId.setCellValueFactory(c -> new javafx.beans.property.SimpleIntegerProperty(c.getValue().getId()));
        colTitulo.setCellValueFactory(c -> new javafx.beans.property.SimpleStringProperty(c.getValue().getTitulo()));
        colTipo.setCellValueFactory(c -> new javafx.beans.property.SimpleStringProperty(c.getValue().getTipo()));
        colAutor.setCellValueFactory(c -> new javafx.beans.property.SimpleStringProperty(c.getValue().getAutor()));
        colData.setCellValueFactory(c -> new javafx.beans.property.SimpleObjectProperty<>(c.getValue().getDataPublicacao()));
        colDescricao.setCellValueFactory(c -> new javafx.beans.property.SimpleStringProperty(c.getValue().getDescricao()));

        table.setItems(dados);
        
        table.getSelectionModel().selectedItemProperty().addListener((obs, old, sel) -> preencherFormulario(sel));

        recarregarTabela();
    }

    private void preencherFormulario(Documento d) {
        documentoSelecionado = d;

        if (d == null) {
            txtTitulo.clear();
            cbTipo.getSelectionModel().clearSelection();
            txtAutor.clear();
            dpData.setValue(null);
            txtDescricao.clear();
            return;
        }

        formPane.setVisible(true);
        formPane.setManaged(true);

        txtTitulo.setText(d.getTitulo());
        cbTipo.setValue(d.getTipo());
        txtAutor.setText(d.getAutor());
        dpData.setValue(d.getDataPublicacao());
        txtDescricao.setText(d.getDescricao());
    }

    @FXML
    private void onNovo() {
        documentoSelecionado = null;       // new object
        table.getSelectionModel().clearSelection();

        txtTitulo.clear();
        cbTipo.getSelectionModel().clearSelection();
        txtAutor.clear();
        dpData.setValue(null);
        txtDescricao.clear();

        formPane.setVisible(true);
        formPane.setManaged(true);
    }

    @FXML
    private void onSalvar() {
        try {
            String titulo = txtTitulo.getText().trim();
            String tipo = cbTipo.getValue();
            String autor = txtAutor.getText().trim();
            LocalDate date = dpData.getValue();
            String descricao = txtDescricao.getText().trim();

            validar(titulo, tipo, autor, date);

            if (documentoSelecionado == null) {
                // Insert
                Documento novo = new Documento(titulo, autor, date, descricao, tipo);
                dao.inserir(novo);
            } else {
                // Update existing doc
                documentoSelecionado.setTitulo(titulo);
                documentoSelecionado.setTipo(tipo);
                documentoSelecionado.setAutor(autor);
                documentoSelecionado.setDataPublicacao(date);
                documentoSelecionado.setDescricao(descricao);

                dao.atualizar(documentoSelecionado);
            }

            recarregarTabela();
            onNovo();
            showInfo("Sucesso", "Documento salvo com sucesso.");

        } catch (IllegalArgumentException e) {
            showError("Validação", e.getMessage());
        } catch (SQLException e) {
            showError("Banco de dados", e.getMessage());
        }
    }

    @FXML
    private void onExcluir() {
        try {
            Documento selecionado = table.getSelectionModel().getSelectedItem();

            if (selecionado == null) {
                showError("Atenção", "Selecione um documento para excluir.");
                return;
            }

            Alert confirm = new Alert(Alert.AlertType.CONFIRMATION,
                    "Excluir o documento selecionado?",
                    ButtonType.YES, ButtonType.NO);

            confirm.setHeaderText("Confirmação");
            confirm.showAndWait();

            if (confirm.getResult() == ButtonType.YES) {
                dao.excluir(selecionado.getId());
                recarregarTabela();
                onNovo();
            }

        } catch (SQLException e) {
            showError("Banco de dados", e.getMessage());
        }
    }

    private void recarregarTabela() {
        try {
            dados.setAll(dao.listar());
        } catch (SQLException e) {
            showError("Banco de dados", e.getMessage());
        }
    }

    private void validar(String titulo, String tipo, String autor, LocalDate date) {
        if (titulo.isBlank()) throw new IllegalArgumentException("Título é obrigatório.");
        if (tipo == null) throw new IllegalArgumentException("Tipo é obrigatório.");
        if (autor.isBlank()) throw new IllegalArgumentException("Autor é obrigatório.");
        if (date == null) throw new IllegalArgumentException("Data de publicação é obrigatória.");
    }

    private void showError(String titulo, String msg) {
        Alert a = new Alert(Alert.AlertType.ERROR);
        a.setTitle(titulo);
        a.setHeaderText(titulo);
        a.setContentText(msg);
        a.showAndWait();
    }

    private void showInfo(String titulo, String msg) {
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setTitle(titulo);
        a.setHeaderText(titulo);
        a.setContentText(msg);
        a.showAndWait();
    }
}
