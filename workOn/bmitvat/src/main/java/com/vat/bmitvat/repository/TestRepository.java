package com.vat.bmitvat.repository;

import com.vat.bmitvat.entity.test.Person;
import com.vat.bmitvat.entity.test.PersonAddressDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TestRepository extends JpaRepository<Person, Long> {
    @Query("SELECT new com.vat.bmitvat.entity.test.PersonAddressDto(p.id, p.name, p.email, a.street, a.city) FROM Person p JOIN Address a ON p.id = a.personId")
    List<PersonAddressDto> getUserAddressDTOList();


}
