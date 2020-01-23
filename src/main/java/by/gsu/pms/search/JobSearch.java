package by.gsu.pms.search;

import by.gsu.pms.domain.Job;
import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class JobSearch {
    @PersistenceContext
    private EntityManager entityManager;

    public List<Job> search(String text) {
        FullTextEntityManager fullTextEntityManager =
                org.hibernate.search.jpa.Search.getFullTextEntityManager(entityManager);

        QueryBuilder queryBuilder = fullTextEntityManager.getSearchFactory()
                .buildQueryBuilder().forEntity(Job.class).get();

        org.apache.lucene.search.Query query =
                queryBuilder
                .keyword()
                .onFields("title", "description")
                .matching(text)
                .createQuery();

        org.hibernate.search.jpa.FullTextQuery jpaQuery =
                fullTextEntityManager.createFullTextQuery(query, Job.class);

        List<Job> results = jpaQuery.getResultList();

        return results;
    }
}
