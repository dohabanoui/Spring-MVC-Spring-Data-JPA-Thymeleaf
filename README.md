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
- 
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
