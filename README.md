# Nutrisearch-API
Dans le cadre de la loi de modernisation du système de santé, un système
d’étiquetage nutritionnel a été mise en place en Europe pour faciliter la compréhension
et le choix de produits plus sains pour le consommateur. Ce système permet
également de participer à la lutte contre l’augmentation des maladies cardiovasculaire
et l’obésité. Alors pourquoi par allier l’informatique à la santé.

#Tables des matière
- [Les Cibles](#cible)
- [Description](#description)
- [Contexte](#contexte)
- [Spécifications Techniques](#specTech)
<div id='cible'/>  
  <h1>Les Cibles</h1>
  Les cibles de ce projet sont l’ensemble des personnes souhaitant consommer des
  produits de façon plus saines. Cette application s’adresse également aux personnes
  qui souhaitent s’informer sur les produits qu’il consomme tous les jours.
</div>

<div id='description'/>  
  <h1>Description</h1>
  L’application Nutrisearch est un produit développé en 1 semaine par un <a href="https://github.com/Dagga78">ami</a> et moi <a href="https://github.com/Darman09">même</a>. Il rentre dans le cadre d’un cours de MongoDb. Cette
  application a été imaginée afin de mieux s’informer sur les produits que nous consommons tous les jours.
</div>

<div id='contexte'/> 
  <h1>Contexte</h1>
  Les données sont issues d’une base de données collaborative appelé Open
  Fodd Facts. Open Food Facts est un projet collaboratif en ligne et sur mobile dont le
  but est de constituer une base de données libres et ouverte sur les produits
  alimentaires commercialisés dans le monde entier. Ce projet a été lancé en 2012 et
  évolue au fur et à mesure des années. Bien entendu pour la réalisation de ce projet
  nous avons récupérer qu’une partie de la base de données. La base de données est
  décomposée en 13 fichiers compressé dans un fichier zip de 1.3 Go. Voici le lien pour
  la télécharger si cela vous intéresse (https://fr.openfoodfacts.org/data).
</div>

<div id='specTech'/> 
<h1>Spécifications Techniques</h1>
Pour ce qui est de l’architecture globale du projet nous avons choisi de créer un
projet en 2 parties :</br>
<ul>
  <li>
    Une Api développé avec le Framework Spring présente sur ce projet.
  </li>
  <li>
    Un client développé en en Java JEE présent sur un autre <a href="https://github.com/Darman09/Nutrisearch-Web-App">projet</a>.
  </li>
</ul>
Nous avons choisi de développer notre application à partir d’une architecture
distribuée car elle nous permet d’alléger l’application web.</br> C'est-à-dire que l’accès à
la base de données se fait à partir d’une API développée et l’affichage se fait à partir
d’une application web. Les informations sont distribuées par l’API qui peut être
distante de l’application.</br>
A terme, il est possible de sécuriser la donnée à partir de Mongo Db en
mettant en place des Replicat set contenant les informations présentes dans notre
serveur de base de données dont l’API est la principale porte d’entrée.

## API décomposéee
L'API est décomposée en 2 parties distinctes : la partie pour la gestion des produits et la celle pour la gestion des favoris
### Produit
Chemin initial : 
``` http
GET rest/nutri
```
#### Lister tout les produits
``` http
GET rest/nutri/all
```
#### Un seul résultat ?
```http
GET rest/nutri//findOne?id=<Valeur>
```
#### Une liste par pays ?
```http
GET rest/nutri/allBy/?pays=<Valeur>
```
#### Lister les produits par score
```http
GET rest/nutri/allByScore/?nutriscore=<Valeur>
```
#### Une liste en fonction du nutriscore, de la provenance ainsi que du pays de vente
```http
GET rest/nutri/allByElement/?nutriscore=<Valeur>&paysOrigine=<Valeur>&paysVente=<Valeur>
```
#### Une liste par pays d'origine ?
```http
GET rest/nutri/allByPaysOrigine/?paysOrigine=<Valeur>
```
#### Une liste par pays de vente?
```http
GET rest/nutri/allByPaysVente/?paysVente=<Valeur>
```
#### Ajouter une nouveau produit
```http
GET rest/nutri/add/?nom=<Valeur>&grade=<Valeur>&packaging=<Valeur>&paysOrigine=<Valeur>&paysVente=<Valeur>&categorie=<Valeur>&ingredientDescription=<Valeur>&quantity=<Valeur>
```
#### Modifier un produit
```http
GET rest/nutri/modify/?id=<Valeur>&nom=<Valeur>&grade=<Valeur>&packaging=<Valeur>&paysOrigine=<Valeur>&paysVente=<Valeur>&categorie=<Valeur>&ingredientDescription=<Valeur>&quantity=<Valeur>
```
#### Supprimer un produit 
```http
GET rest/nutri/delete/?id=<Valeur>
```
---
### Favoris
Chemin initial : 
``` http
GET rest/favoris
```
#### Lister tout les favoris
```http
GET rest/favoris/all/
```
#### Ajoute un nouveau favoris
```http
GET rest/favoris/add/?idproduit=<Valeur>
```
#### Lister les favoris par IdProduit
```http
GET rest/favoris/findByIdProduct/?idproduit=<Valeur>
```
#### Supprimer un favoris
```http
GET rest/favoris/delete/?id=<Valeur>
```
</div>
