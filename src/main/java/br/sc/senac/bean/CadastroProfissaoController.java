package br.sc.senac.bean;

import br.sc.senac.dao.ProfissaoDao;
import br.sc.senac.model.Pessoa;
import br.sc.senac.model.Profissao;

import javax.annotation.ManagedBean;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.List;

@ViewScoped
@ManagedBean
public class CadastroProfissaoController implements Serializable {

    private static final long serialVersionUID = 1L;

    private Profissao profissao;
    private ProfissaoDao dao;
    private List<Profissao> profissaos;

    public Profissao getProfissao() {
        return profissao;
    }

    public void setProfissao(Profissao profissao) {
        this.profissao = profissao;
    }

    public List<Profissao> getProfissaos() {
        return profissaos;
    }

    public void buscar() {
        profissaos = dao.getList();
    }

    public void limpar() {
        profissao = new Profissao();
    }

    public void cadastrar(){
        if (profissao.getId() == null) {
            dao.salvar(profissao);
        } else {
            dao.atualizar(profissao);
        }
        limpar();
        buscar();
    }

    public void excluir(){
        dao.remover(profissao);
        limpar();
        buscar();

        FacesMessage mensagem = new FacesMessage();
        mensagem.setSeverity(FacesMessage.SEVERITY_INFO);
        mensagem.setSummary("Profissao excluída com sucesso!");
        FacesContext.getCurrentInstance().addMessage(null, mensagem);
    }
}
