package sn.esmt.jobsearch.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sn.esmt.jobsearch.entities.CVEntity;

@Repository
public interface CVRepository extends JpaRepository<CVEntity, Integer> {

}

/*
 * Cette interface étend l'interface JpaRepository de Spring Data JPA.
 * Elle utilise l'annotation @Repository de Spring pour indiquer qu'elle
 * est un composant Spring et doit être gérée par le conteneur IoC.
 */