package br.com.marcela.api.repository.contasAReceber;

import br.com.marcela.api.model.ContasAReceber;
import br.com.marcela.api.repository.filter.ContasAReceberFilter;
import br.com.marcela.api.repository.projections.ContasAReceberDto;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class ContasAReceberRepositoryImpl implements ContasAReceberRepositoryQuery{

    @PersistenceContext
    private EntityManager manager;

    @Override
    public Page<ContasAReceberDto> filtrar(ContasAReceberFilter contasAReceberFilter, Pageable pageable) {
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<ContasAReceberDto> criteria = builder.createQuery(ContasAReceberDto.class);
        Root<ContasAReceber> root = criteria.from(ContasAReceber.class);

        criteria.select(builder.construct(ContasAReceberDto.class,
                root.get("id"),
                root.get("dataconta"),
                root.get("valorconta"),
                root.get("cliente").get("nomecliente")));

        Predicate[] predicates = criarRestricoes(contasAReceberFilter, builder, root);
        criteria.where(predicates);
        criteria.orderBy(builder.asc(root.get("valorconta")));


        TypedQuery<ContasAReceberDto> query = manager.createQuery(criteria);
        adicionaRestricoespPaginas(query, pageable);


        return new PageImpl<>(query.getResultList(), pageable, total(contasAReceberFilter));
    }

    private Long total(ContasAReceberFilter contasAReceberFilter){
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
        Root<ContasAReceber> root = criteria.from(ContasAReceber.class);

        Predicate[] predicates = criarRestricoes(contasAReceberFilter, builder, root);
        criteria.where(predicates);
        criteria.orderBy(builder.asc(root.get("valorconta")));

        criteria.select(builder.count(root));

        return manager.createQuery(criteria).getSingleResult();

    }

    private void adicionaRestricoespPaginas(TypedQuery<?> query, Pageable pageable) {
        int paginaAtual = pageable.getPageNumber();
        int totalRegistrosPorPagina = pageable.getPageSize();
        int primeiroRegistroPágina = paginaAtual * totalRegistrosPorPagina;

        query.setFirstResult(primeiroRegistroPágina);
        query.setMaxResults(totalRegistrosPorPagina);
    }

    private Predicate[] criarRestricoes(ContasAReceberFilter contasAReceberFilter, CriteriaBuilder builder, Root<ContasAReceber> root) {
        List<Predicate> predicates = new ArrayList<>();

        if(contasAReceberFilter.getValorconta() != null){
            predicates.add(builder.equal(root.get("valorconta"), contasAReceberFilter.getValorconta()));
        }
        if(contasAReceberFilter.getDataconta() != null){
            predicates.add(builder.greaterThanOrEqualTo(root.get("dataconta"), contasAReceberFilter.getDataconta()));
        }

        if (!StringUtils.isEmpty(contasAReceberFilter.getNomecliente())){
            predicates.add(builder.like(builder.lower(root.get("cliente").get("nomecliente")),
                    "%" + contasAReceberFilter.getNomecliente().toLowerCase() + "%"));
        }

        return predicates.toArray(new Predicate[predicates.size()]);
    }

    }
