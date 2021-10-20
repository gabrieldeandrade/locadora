package br.gov.rj.seplag.sublog.testedev.locadora.model.specification;
import br.gov.rj.seplag.sublog.testedev.locadora.model.Filme;
import org.springframework.data.jpa.domain.Specification;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class FilmeSpecification implements Specification<Filme> {

    private String nomeFilme;
    private String nomeDiretor;
    private Integer ano;

    public FilmeSpecification(String nomeFilme, String nomeDiretor, Integer ano) {
        this.nomeFilme = nomeFilme;
        this.nomeDiretor = nomeDiretor;
        this.ano = ano;
    }

    @Override
    public Predicate toPredicate(Root<Filme> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
        criteriaQuery.orderBy(criteriaBuilder.desc(root.get("id")));
        criteriaQuery.distinct(true);

        List<Predicate> andPredicates = new ArrayList<>();

        if (nomeDiretor != null) {
            andPredicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("diretor")),
                    "%" + nomeDiretor.toLowerCase() + "%"));
        }

        if (nomeFilme != null) {
            andPredicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("nome")),
                    "%" + nomeFilme.toLowerCase() + "%"));
        }

        if (ano != null) {
            andPredicates.add(criteriaBuilder.equal(root.get("ano"), ano));
        }

        Predicate predAnd = criteriaBuilder.and(andPredicates.toArray(new Predicate[0]));

        return criteriaBuilder.and(predAnd);
    }

}
