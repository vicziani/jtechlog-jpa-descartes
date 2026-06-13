package employees;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query("select distinct e from Employee e join fetch e.phones join fetch e.addresses where e.id = :id")
    Employee findEmployeeById(long id);

    @Query("select distinct e from Employee e left join fetch e.phones where e.id = :id")
    Employee findEmployeeByIdFetchPhones(long id);

    @Query("select distinct e from Employee e left join fetch e.addresses where e.id = :id")
    Employee findEmployeeByIdFetchAddresses(long id);

}
