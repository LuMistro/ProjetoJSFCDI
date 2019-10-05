package br.sc.senac.dao;

import br.sc.senac.model.Pessoa;

public class PessoaDao extends GenericDao<Pessoa, Integer> {
    public PessoaDao() {
        super(Pessoa.class);
    }
}
