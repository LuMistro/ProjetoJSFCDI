package br.sc.senac.bean;

import br.sc.senac.dao.PessoaDao;
import br.sc.senac.model.Pessoa;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@ViewScoped
@ManagedBean
public class CadastroPessoaController implements Serializable {

    private static final long serialVersionUID = 1L;

    private Pessoa pessoa;
    private PessoaDao dao;
    private List<Pessoa> pessoas;

    @PostConstruct
    public void init() {
        pessoa = new Pessoa();
        dao = new PessoaDao();
        pessoas = new ArrayList<>();
        pessoas.addAll(dao.getList());

    }

    public void excluir() {
        dao.remover(pessoa);
        limpar();
        buscar();

        FacesMessage mensagem = new FacesMessage();
        mensagem.setSeverity(FacesMessage.SEVERITY_INFO);
        mensagem.setSummary("Pessoa excluída com sucesso!");
        FacesContext.getCurrentInstance().addMessage(null, mensagem);

    }

    public void cadastrar() {
        if (pessoa.getId() == null) {
            dao.salvar(pessoa);
        } else {
            dao.atualizar(pessoa);
        }
        limpar();
        buscar();
    }

    public void buscar() {
        pessoas = dao.getList();
    }

    public void limpar() {
        pessoa = new Pessoa();
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public List<Pessoa> getPessoas() {
        return pessoas;
    }

}
