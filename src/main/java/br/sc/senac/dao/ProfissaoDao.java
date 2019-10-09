package br.sc.senac.dao;

import br.sc.senac.model.Pessoa;
import br.sc.senac.model.Profissao;

public class ProfissaoDao extends GenericDao<Profissao, Integer> {
    public ProfissaoDao() {
        super(Profissao.class);
    }
}
