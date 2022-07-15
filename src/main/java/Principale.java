import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Principale {
    public static void main(String[] args) {
        Etudiant etudiant1 = new Etudiant("bansept", "franck");
        etudiant1.getListeNote().add(new Note("JAVA", 15));
        etudiant1.getListeNote().add(new Note("PHP", 10));
        etudiant1.getListeNote().add(new Note("UML", 5));

        Etudiant etudiant2 = new Etudiant("doe", "simon");
        etudiant2.getListeNote().add(new Note("JAVA", 5));
        etudiant2.getListeNote().add(new Note("PHP", 18));

        Etudiant etudiant3 = new Etudiant("stark", "sansa");
        etudiant3.getListeNote().add(new Note("C#", 5));
        etudiant3.getListeNote().add(new Note("AVA", 19));


        List<Etudiant> listeEtudiant = new ArrayList<>();
        listeEtudiant.add(etudiant1);
        listeEtudiant.add(etudiant2);
        listeEtudiant.add(etudiant3);

        System.out.println("Premier exo :");

        System.out.println(
                listeEtudiant.stream()
                        .map(personne -> personne.nom + "." + personne.prenom + "@cesi.com")
                        .collect(Collectors.joining(" - ")));

        System.out.println("Deuxieme  exo :");


        Etudiant test = listeEtudiant.stream()
            .filter(etudiant -> etudiant.getPrenom().toLowerCase().startsWith("s")).max(Comparator.comparing(
                    personne -> personne.getListeNote().stream()
                            .mapToInt(note -> note.getNote()).max().getAsInt()
            )).get();

        System.out.println(test.getNom() + " " + test.getPrenom());



        System.out.println("Troisieme  exo :");
        ArrayList<Evaluation> listeEvaluation = new ArrayList<>();
        listeEtudiant.stream().forEach(
                (etudiant) -> etudiant.getListeNote().stream().
                        forEach((note) -> listeEvaluation.add(new Evaluation(etudiant, note.getNote()))));

        listeEvaluation.forEach(evaluation -> System.out.println(evaluation.getPersonne().nom + " " + evaluation.getPersonne().prenom + " - " + evaluation.getNote()));



        System.out.println("Quatrieme  exo :");

        System.out.println(
                listeEtudiant.stream()
                        .sorted(Comparator.comparing(personne -> personne.getListeNote().stream()
                                .mapToInt(note -> note.getNote()).average().getAsDouble()))
                        .map(personne ->
                                personne.nom.toUpperCase().charAt(0) + "." +
                                        personne.prenom.toUpperCase().charAt(0) + " (" +
                                        personne.getListeNote().stream()
                                                .mapToInt(note -> note.getNote()).max().getAsInt() + ")"
                        )
                        .collect(Collectors.joining(" > ")));

    }
}
