package com.revature.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.models.Charm;

@Repository
public interface CharmRepository extends JpaRepository<Charm, Integer> {

	public Charm findCharmByName(String name);
}
