package co.develhope.esercizio2springrepository.repositories;

import co.develhope.esercizio2springrepository.entities.ProgrammingLanguage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.Description;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(
        path = "repo-prog-languages",
        collectionResourceDescription = @Description("example description"))
public interface ProgrammingLanguageRepo extends JpaRepository<ProgrammingLanguage, Long> {

}