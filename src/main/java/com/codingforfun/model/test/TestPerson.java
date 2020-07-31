package com.codingforfun.model.test;

import com.codingforfun.model.Identifiable;
import lombok.Data;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import java.util.Collection;


@Entity
@Data
public class TestPerson extends Identifiable {

    @ElementCollection
    @CollectionTable(name = "test_person_locations", joinColumns = @JoinColumn(name = "TEST_PERSON_ID"))
    private Collection<TestLocation> locations;
}
