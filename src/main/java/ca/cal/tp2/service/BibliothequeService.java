package ca.cal.tp2.service;

import ca.cal.tp2.exceptions.DatabaseException;
import ca.cal.tp2.modele.*;
import ca.cal.tp2.repository.*;
import ca.cal.tp2.service.dto.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BibliothequeService {

    private EmprunteurRepositoryJPA emprunteurRepository;
    private DocumentRepositoryJPA documentRepository;
    private EmpruntRepositoryJPA empruntRepository;
    private EmpruntDetailsRepositoryJPA empruntDetailsRepository;

    public BibliothequeService(
            EmprunteurRepositoryJPA emprunteurRepository,
            DocumentRepositoryJPA documentRepository,
            EmpruntRepositoryJPA empruntRepository,
            EmpruntDetailsRepositoryJPA empruntDetailsRepository
    ) {
        this.emprunteurRepository = emprunteurRepository;
        this.documentRepository = documentRepository;
        this.empruntRepository = empruntRepository;
        this.empruntDetailsRepository = empruntDetailsRepository;
    }

    public void saveEmprunteur(String nom, String email, String phoneNumber) throws DatabaseException {
        emprunteurRepository.saveEmprunteur(new Emprunteur(nom, email, phoneNumber));
    }

    public EmprunteurDTO getEmprunteur(String nom, String email) throws DatabaseException {
        return EmprunteurDTO.toDTO(emprunteurRepository.findEmprunteur(nom, email));
    }

    public EmprunteurDTO getEmprunteur(int id) throws DatabaseException {
        return EmprunteurDTO.toDTO(emprunteurRepository.findEmprunteur(id));
    }

    public List<LivreDTO> rechercherLivres(String titre, String auteur) throws DatabaseException {
        List<Livre> livres = documentRepository.rechercherLivres(titre, auteur);
        return livres.stream().map(LivreDTO::toDTO).collect(Collectors.toList());
    }

    public List<CdDTO> rechercherCDs(String titre, String artiste) throws DatabaseException {
        List<Cd> cds = documentRepository.rechercherCds(titre, artiste);
        return cds.stream().map(CdDTO::toDTO).collect(Collectors.toList());
    }

    public List<DvdDTO> rechercherDVDs(String titre, String director) throws DatabaseException {
        List<Dvd> dvds = documentRepository.rechercherDvds(titre, director);
        return dvds.stream().map(DvdDTO::toDTO).collect(Collectors.toList());
    }

    public void saveDVD(String titre, int nbExemplaire, String director, int duree, String rating) throws DatabaseException {
        documentRepository.save(new Dvd(titre, nbExemplaire, director, duree, rating));
    }

    public void saveCD(String titre, int nbExemplaire, String artiste, int duree, String genre) throws DatabaseException {
        documentRepository.save(new Cd(titre, nbExemplaire, artiste, duree, genre));
    }

    public void saveLivre(String titre, int nbExemplaire, String isbn, String auteur, String publicateur, int nbPage) throws DatabaseException {
        documentRepository.saveDocument(new Livre(titre, nbExemplaire, isbn, auteur, publicateur, nbPage));
    }

    public CdDTO getCD(int id) throws DatabaseException {
        return CdDTO.toDTO((Cd) documentRepository.getDocument(id));
    }

    public LivreDTO getLivre(int id) throws DatabaseException {
        return LivreDTO.toDTO((Livre) documentRepository.getDocument(id));
    }

    public DvdDTO getDVD(int id) throws DatabaseException {
        return DvdDTO.toDTO((Dvd) documentRepository.getDocument(id));
    }

    public void emprunterDocument(int emprunteurId, List<Integer> documentIds) throws DatabaseException {
        try {
            verifierEmprunteurExiste(emprunteurId);
            Emprunteur emprunteur = emprunteurRepository.findEmprunteur(emprunteurId);

            List<Document> documentsDispo = new ArrayList<>();
            for (Integer docId : documentIds) {
                Document document = verifierDocumentDispo(docId);
                documentsDispo.add(document);
            }

            Emprunt emprunt = new Emprunt(LocalDate.now(), "En cours", emprunteur);
            empruntRepository.save(emprunt);

            for (Document doc : documentsDispo) {
                EmpruntDetails details = new EmpruntDetails();
                details.setEmprunt(emprunt);
                details.setDocument(doc);
                details.setStatus("Emprunté");
                details.setDateRetourPrevue(LocalDate.now().plusWeeks(nbSemaineDateRetourPrevue(doc)));
                empruntDetailsRepository.save(details);
            }
        } catch (Exception e) {
            throw new DatabaseException(e);
        }
    }

    private void verifierEmprunteurExiste(int emprunteurId) throws DatabaseException {
        if (emprunteurRepository.findEmprunteur(emprunteurId) == null) {
            throw new DatabaseException(new Exception("Emprunteur introuvable"));
        }
    }

    private Document verifierDocumentDispo(int documentId) throws DatabaseException {
        Document document = documentRepository.getDocument(documentId);
        if (document == null) {
            throw new DatabaseException(new Exception("Document introuvable"));
        }
        if (!document.verifieDisponibilite()) {
            throw new DatabaseException(new Exception("Le document " + documentId + " est indisponible"));
        }
        return document;
    }

    private int nbSemaineDateRetourPrevue(Document document) {
        if (document instanceof Livre) return 3;
        if (document instanceof Cd) return 2;
        if (document instanceof Dvd) return 1;
        return 0;
    }
}
