package sn.esmt.jobsearch.ws; // On déclare le package qui contiendra notre classe CVController

// On importe les classes nécessaires
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;
import sn.esmt.jobsearch.dao.CVRepository;
import sn.esmt.jobsearch.entities.CVEntity;

import java.util.List;
import java.util.Optional;

@RestController // On indique que cette classe est un contrôleur REST
@RequestMapping("/api/cv") // On définit la racine pour les URL de cette classe
public class CVController {

    @Autowired // On injecte l'objet CVRepository à partir du conteneur IoC
    private CVRepository cvRepository;

    // Endpoint pour récupérer tous les CV
    @GetMapping("/all")
    public ResponseEntity<List<CVEntity>> getAllCVs() {
        // On utilise la méthode findAll() du CVRepository pour récupérer tous les CV
        List<CVEntity> cvList = cvRepository.findAll();
        // On retourne la liste des CV dans une réponse HTTP avec le code de statut 200 OK
        return new ResponseEntity<>(cvList, HttpStatus.OK);
    }

    // Endpoint pour récupérer un CV par son id
    @GetMapping("/{id}")
    public ResponseEntity<CVEntity> getCVById(@PathVariable int id) {
        // On utilise la méthode findById() du CVRepository pour récupérer le CV correspondant à l'id
        Optional<CVEntity> optionalCVEntity = cvRepository.findById(id);
        if (optionalCVEntity.isPresent()) {
            // Si le CV est trouvé, on le retourne dans une réponse HTTP avec le code de statut 200 OK
            CVEntity cvEntity = optionalCVEntity.get();
            return new ResponseEntity<>(cvEntity, HttpStatus.OK);
        } else {
            // Sinon, on retourne une réponse HTTP avec le code de statut 404 NOT FOUND
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    // Endpoint pour créer un nouveau CV
    @PostMapping("/new")
    public ResponseEntity<CVEntity> createCV(@RequestBody CVEntity cvEntity) {
        // On utilise la méthode save() du CVRepository pour créer un nouveau CV
        CVEntity newCV = cvRepository.save(cvEntity);
        // On retourne le nouveau CV dans une réponse HTTP avec le code de statut 201 CREATED
        return new ResponseEntity<>(newCV, HttpStatus.CREATED);
    }

    // Endpoint pour mettre à jour un CV existant
    @PutMapping("/{id}")
    public ResponseEntity<CVEntity> updateCV(@PathVariable int id, @RequestBody CVEntity cvEntity) {
        // On utilise la méthode findById() du CVRepository pour récupérer le CV correspondant à l'id
        Optional<CVEntity> optionalCVEntity = cvRepository.findById(id);
        if (optionalCVEntity.isPresent()) {
            // Si le CV est trouvé, on met à jour ses informations et on l'enregistre dans la base de données
            CVEntity existingCVEntity = optionalCVEntity.get();
            existingCVEntity.setNom(cvEntity.getNom());
            existingCVEntity.setPrenom(cvEntity.getPrenom());
            existingCVEntity.setAge(cvEntity.getAge());
            existingCVEntity.setAdresse(cvEntity.getAdresse());
            existingCVEntity.setEmail(cvEntity.getEmail());
            existingCVEntity.setTelephone(cvEntity.getTelephone());
            existingCVEntity.setSpecialite(cvEntity.getSpecialite());
            existingCVEntity.setNiveauEtude(cvEntity.getNiveauEtude());
            existingCVEntity.setExperienceProfessionnelle(cvEntity.getExperienceProfessionnelle());
            cvRepository.save(existingCVEntity);
            // retourne une instance de ResponseEntity contenant l'entité existingCVEntity
            // qui vient d'être mise à jour et le code de statut HTTP OK.
            return new ResponseEntity<>(existingCVEntity, HttpStatus.OK);
        } else {
            // Si le CV n'existe pas, le code d'état HTTP renvoyé est "NOT_FOUND".
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    // Endpoint pour supprimer un CV existant
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCV(@PathVariable int id) {
        Optional<CVEntity> optionalCVEntity = cvRepository.findById(id);
        if (optionalCVEntity.isPresent()) {
            cvRepository.deleteById(id);
            // Le code d'état HTTP renvoyé est "NO_CONTENT"
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        } else {
            // Si le CV n'existe pas, le code d'état HTTP renvoyé est "NOT_FOUND".
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}
