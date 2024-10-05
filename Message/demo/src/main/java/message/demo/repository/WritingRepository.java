package message.demo.repository;

import jakarta.persistence.EntityManager;
import lombok.Locked;
import lombok.RequiredArgsConstructor;
import message.demo.domain.writing;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class WritingRepository {

    private final EntityManager em;

    public void save(writing write) {
        em.persist(write);
    }

    public writing findOne(Long id) {
        return  em.find(writing.class, id);

    }

    public List<writing> findAll() {
        return em.createQuery("select w from writing w", writing.class)
                .getResultList();
    }


}
