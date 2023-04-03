package repository;

 import DTO.StatisticsDTO;
 import model.Detail;
 import util.HibernateUtil;

 import javax.persistence.EntityManager;
         import java.util.List;
         import java.util.Optional;

public class Repository {
    private static Repository instance;

    private Repository() {
    }

    public static Repository getInstance() {
        if (instance == null) {
            instance = new Repository();
        }
        return instance;
    }

    public void save(Detail detail) {
        final EntityManager entityManager = HibernateUtil.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(detail);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public Optional<Detail> getById(String id) {
        final EntityManager entityManager = HibernateUtil.getEntityManager();
        return Optional.ofNullable(entityManager.find(Detail.class, id));
    }

    public StatisticsDTO getStatistics() {
        final EntityManager entityManager = HibernateUtil.getEntityManager();
        return entityManager.createQuery(
                        "SELECT new from DTO.StatisticsDTO " +
                                "(COUNT (d.id), SUM (d.brokenMicrocircuits), " +
                                "SUM (d.producedFuel), SUM (d.usedFuel)) " +
                                "FROM Detail d", StatisticsDTO.class)
                .getSingleResult();
    }

    public List<String> getAllId() {
        final EntityManager entityManager = HibernateUtil.getEntityManager();
        return entityManager.createQuery(
                        "SELECT  d.id FROM Detail d", String.class)
                .getResultList();
    }
}
