package jtechlog.descartes;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
public class EmployeeServiceJpa implements EmployeeService {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Employee> findEmployees() {
        return em.createNamedQuery("findEmployees", Employee.class).getResultList();
    }

    @Override
    @Transactional(readOnly = true)
    public Employee findEmployeeById(long id) {
        //return em.find(Employee.class, id);

        //return em.createNamedQuery("findEmployeeById", Employee.class).setParameter("id", id).getSingleResult();

        em.createNamedQuery("findEmployeeByIdFetchPhones", Employee.class).setParameter("id", id)
                .getSingleResult();
        return em.createNamedQuery("findEmployeeByIdFetchAddresses", Employee.class).setParameter("id", id)
                .getSingleResult();
    }
}
