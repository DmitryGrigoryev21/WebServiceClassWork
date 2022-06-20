package com.gerard.diactivity.entities;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LanguageRepo extends CrudRepository<Language, Integer> {
    Language findLanguageByLanguageUUID(String languageUUID);
    Language findLanguageByName(String name);
    boolean existsLanguageByName(String language);
}
