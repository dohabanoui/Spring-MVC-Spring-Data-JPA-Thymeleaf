# projet sur Spring MVC

Ce projet permet de créer une application Web JEE basée sur Spring MVC, Thymeleaf et Spring Data JPA qui permet de gérer les patients. L'application doit permettre les fonctionnalités suivantes :
- Afficher les patients
- Faire la pagination
- Chercher les patients
- Supprimer un patient
- Faire des améliorations supplémentaires
- Créer une page template
- Faire la validation des formulaires
- Faire la sécurité avec Spring Security
## Utilisation de JPA

JPA (Java Persistence API) est une spécification créée pour standardiser le mapping Objet-Relationnel (ORM). Elle définit un ensemble d'interfaces, de classes abstraites et d'annotations qui facilitent la description du mapping objet-relationnel. L'utilisation de JPA permet à votre application d'être indépendante du framework ORM utilisé.

## Configuration du Projet

Le projet a été initialement créé avec Spring Initializer, en incluant les dépendances suivantes :

- `spring-boot-starter-data-jpa` : Dépendance pour l'intégration de JPA avec Spring Boot.
- `spring-boot-starter-web` : Dépendance pour le développement d'applications web avec Spring Boot.
- `h2` : Base de données H2 en tant que dépendance de runtime pour les tests et le développement.
- `lombok` : Bibliothèque Lombok pour la génération automatique de code boilerplate.
- `spring-boot-starter-test` : Dépendance pour les tests unitaires avec Spring Boot.
- `mysql-connector-java` : Driver JDBC pour MySQL.
- `bootstrap` : Framework CSS pour le design d'interfaces web.
- `bootstrap-icons` : Icônes Bootstrap.
- `thymeleaf-layout-dialect` : Dialecte Thymeleaf pour la gestion des mises en page.
- `spring-boot-starter-validation` : Dépendance pour la validation des formulaires avec Spring Boot.
- `spring-boot-starter-security` : Dépendance pour la sécurité avec Spring Security.
- `spring-security-test` : Dépendance pour les tests de sécurité avec Spring Security.
- `thymeleaf-extras-springsecurity6` : Extensions Thymeleaf pour Spring Security.


Nous pouvons trouver les dernières versions des dépendances en utilisant le site principal de Maven ou en utilisant le site [Spring Initializr](https://start.spring.io/).

Voici le snippet XML de configuration Maven pour ces dépendances :

```xml
   <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-jpa</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-thymeleaf</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-devtools</artifactId>
            <scope>runtime</scope>
            <optional>true</optional>
        </dependency>
        <dependency>
            <groupId>com.h2database</groupId>
            <artifactId>h2</artifactId>
            <scope>runtime</scope>
        </dependency>
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <optional>true</optional>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
        <!-- https://mvnrepository.com/artifact/org.webjars/bootstrap -->
        <dependency>
            <groupId>org.webjars</groupId>
            <artifactId>bootstrap</artifactId>
            <version>5.3.2</version>
        </dependency>
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <version>8.0.33</version>
        </dependency>
        <!-- https://mvnrepository.com/artifact/org.webjars.npm/bootstrap-icons -->
        <dependency>
            <groupId>org.webjars.npm</groupId>
            <artifactId>bootstrap-icons</artifactId>
            <version>1.11.2</version>
        </dependency>
        <!-- https://mvnrepository.com/artifact/nz.net.ultraq.thymeleaf/thymeleaf-layout-dialect -->
        <dependency>
            <groupId>nz.net.ultraq.thymeleaf</groupId>
            <artifactId>thymeleaf-layout-dialect</artifactId>
            <version>3.2.1</version>
        </dependency>
        <!-- https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-validation -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-validation</artifactId>
            <version>3.2.1</version>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-security</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.security</groupId>
            <artifactId>spring-security-test</artifactId>
            <version>6.1.5</version>
        </dependency>
        <!-- https://mvnrepository.com/artifact/org.thymeleaf.extras/thymeleaf-extras-springsecurity6 -->
        <dependency>
            <groupId>org.thymeleaf.extras</groupId>
            <artifactId>thymeleaf-extras-springsecurity6</artifactId>
            <version>3.1.2.RELEASE</version>
        </dependency>
        <!-- https://mvnrepository.com/artifact/org.thymeleaf.extras/thymeleaf-extras-springsecurity6 -->
        <dependency>
            <groupId>org.thymeleaf.extras</groupId>
            <artifactId>thymeleaf-extras-springsecurity6</artifactId>
            <version>3.1.0.M1</version>
        </dependency>
        <!-- https://mvnrepository.com/artifact/org.webjars.npm/bootstrap-icons -->
        <dependency>
            <groupId>org.webjars.npm</groupId>
            <artifactId>bootstrap-icons</artifactId>
            <version>1.11.3</version>
        </dependency>
    </dependencies>
```
## Entities:
L'entité `Patient` représente les informations sur un patient.
Pour les annotations utilisées

- `@Entity`: Indique que cette classe est une entité JPA.
- `@Data`: Annotation de Lombok pour générer automatiquement les méthodes `toString`, `equals`, `hashCode`, etc.
- `@NoArgsConstructor`, `@AllArgsConstructor`, `@Builder`: Annotations de Lombok pour générer automatiquement des constructeurs sans argument, avec tous les arguments et un constructeur de construction.
- `@Id`: Indique que cet attribut est la clé primaire de l'entité.
- `@GeneratedValue`: Indique la stratégie de génération de la valeur de la clé primaire.
- `@NotEmpty`: Indique que la chaîne ne doit pas être vide.
- `@Size`: Indique la taille de la chaîne.
- `@Temporal`: Spécifie le type de données temporelles (DATE, TIME ou TIMESTAMP).
- `@DateTimeFormat`: Spécifie le format de la date lors du liage.
- `@DecimalMin`: Indique que la valeur doit être supérieure ou égale à la valeur spécifiée.

```java
@Entity
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class Patient {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    @Size(min = 3, max = 40)
    private String nom;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateNaissance;
    private boolean malade;
    @DecimalMin("10")
    private int score;
}
```

## Repository
L'interface `PatientRepository` est responsable de l'accès aux données des patients.
- `findByNomContains(String nom)`: Recherche les patients par nom en utilisant Spring Data.
- `search(String nom)`: Recherche les patients par nom en utilisant une requête JPQL personnalisée.
- `findByScoreGreaterThan(int score)`: Recherche les patients avec un score supérieur à une valeur donnée en utilisant Spring Data.
- `searchByScore(int score)`: Recherche les patients avec un score supérieur à une valeur donnée en utilisant une requête JPQL personnalisée.
- `findByNomContains(String keyword, Pageable pageable)`: Recherche paginée des patients par nom en utilisant Spring Data.

```java
public interface PatientRepository extends JpaRepository<Patient, Long> {
    List<Patient> findByNomContains(String nom);
    @Query("select p from Patient p where p.nom like :nom")
    List<Patient> search(@Param("nom") String nom);
    List<Patient> findByScoreGreaterThan(int score);
    @Query("select p from Patient p where p.score > :x")
    List<Patient> searchByScore(@Param("x") int score);
    Page<Patient> findByNomContains(String keyword, Pageable pageable);
}
```

## Templates 
### patients
Le fichier HTML des patients représente la page qui affiche la liste des patients dans notre application. 
Voici un extrait du code
```html

            <form method="get" th:action="@{/user/index}">
                <div class="input-group mb-3">
                    <input type="text" class="form-control" placeholder="Rechercher" name="keyword" th:value="${keyword}">
                    <button  type="submit">
                        <i class="bi bi-search"></i>
                    </button>
                </div>
            </form>
            <table class="table">
                <thead>
                <tr>
                    <th>Id</th>
                    <th>Nom</th>
                    <th>Date de naissance</th>
                    <th>Malade</th>
                    <th>Score</th>
                <tr>
                <tr th:each="patient : ${patients}">
                    <td th:text="${patient.id}"></td>
                    <td th:text="${patient.nom}"></td>
                    <td th:text="${patient.dateNaissance}"></td>
                    <td th:text="${patient.malade}"></td>
                    <td th:text="${patient.score}"></td>
                    <td th:if="${#authorization.expression('hasRole(''ADMIN'')')}">
                        <a onclick="return confirm('Etes vous sure?')" th:href="@{/admin/delete(id=${patient.id},keyword=${keyword},page=${currentPage})}" class="'btn btn-danger'">
                            <i class="bi bi-trash"></i>
                        </a>
                    </td>
                    <td th:if="${#authorization.expression('hasRole(''ADMIN'')')}">
                        <a  th:href="@{/admin/editPatient(id=${patient.id},keyword=${keyword},page=${currentPage})}" class="'btn btn-success'">
                            <i class="bi bi-pencil"></i>
                        </a>
                    </td>
                </tr>
                </thead>
            </table>
            <ul class="nav nav-pills">
                <li th:each ="page,status:${pages}">
                    <a th:href="@{/user/index(page=${status.index},keyword=${keyword})}"
                       th:class="${currentPage==status.index? 'btn btn-info ms-1':'btn btn-outline-info ms-1'}"
                       th:text = "${status.index}"></a>
                </li>
            </ul>
```

