# Getting Started

### Reference Documentation

For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/3.5.13/maven-plugin)
* [Create an OCI image](https://docs.spring.io/spring-boot/3.5.13/maven-plugin/build-image.html)
* [Spring Data JPA](https://docs.spring.io/spring-boot/3.5.13/reference/data/sql.html#data.sql.jpa-and-spring-data)
* [Thymeleaf](https://docs.spring.io/spring-boot/3.5.13/reference/web/servlet.html#web.servlet.spring-mvc.template-engines)
* [Spring Web](https://docs.spring.io/spring-boot/3.5.13/reference/web/servlet.html)

### Guides
La principale différence réside dans la localisation des données dans l'URL : @PathVariable extrait des valeurs directement du chemin de l'URI (ex: /users/1), idéal pour identifier une ressource, tandis que @RequestParam récupère des paramètres de requête après le ? (ex: /users?id=1), idéal pour le filtrage ou les paramètres optionnels.

redirection vers page index
```java
return "redirect:/index";
```
Status code 300 redirection
200 ok 
404 not found cad que server nap pas trouve une resrs demande
403 not authorized ou bien forbidden  cad server refuse de traiter une requette
401  not authenticated cad server recoit req ms refuse la traitr a cause dune auth incomplete/manqute ou incorrecte

⚙️ Pourquoi th:href est important ?

Dans Spring Boot, les URLs ne sont pas toujours fixes (elles passent par des contrôleurs, context path, routing dynamique, etc.).

✅ Avec th:href
<a th:href="@{/users}">Users</a>

➡️ Thymeleaf va :
interpréter @{}
générer automatiquement la bonne URL
gérer le context path (ex: /app/users au lieu de /users)
❌ Sans th:href
<a href="/users">Users</a>
➡️ Ici :
c’est du HTML pur
aucune adaptation dynamique
si ton app change de contexte
(/app par ex), ça devient faux 🚨

@ResponseBody envoie res en corps de reponse cad auto il va rnvoye json
conroller retrn vue
restcontroller retrn resultat durectemnt en json
si annotation rst controller   ❌ c pas la epin de response body c auto 

```java
//cad id vient du path
@GetMapping("/product/{id}")
public Product getProduct(@PathVariable(name = "id"));
```

une api c un web service qu on peut consommer avec une interface cad on integrer ou on ajout un documentation swagger
Et on teste avec ce url la on une interface commsomable
```thymeleafurlexpressions
 http://localhost:8086/swagger-ui.html
```

api docs a mettre dans postman

```thymeleafurlexpressions
http://localhost:8086/v3/api-docs

```
ca c json pas wsdl
Code de rest controller lui memme il contient restbody+controller annotations c pour cela c pas al peine de lajouter
```java
//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package org.springframework.web.bind.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.springframework.core.annotation.AliasFor;
import org.springframework.stereotype.Controller;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Controller
@ResponseBody
public @interface RestController {
    @AliasFor(
        annotation = Controller.class
    )
    String value() default "";
}

```

Sonar c un outil qui prend ton code et te redige un rapport pour dire c qui est respecte dans votre code ou nn
```text
SonarQube (précédemment Sonar) est un logiciel libre de qualimétrie en continu de code. Il aide à la détection, la classification et la résolution de défaut dans le code source, permet d'identifier les duplications de code, de mesurer le niveau de documentation et connaître la couverture de test déployée.
```
JPA Repository continet elle meme des methodes :
ms on eput ajouter dautre

```text
🔹 un contrôleur REST (@RestController) → API JSON
🔹 un contrôleur MVC (@Controller) → pages Thymeleaf
```
