# 🌿 Redouane Paysagiste - API Backend (Spring Boot)

Ce projet constitue le serveur Backend RESTful pour le site web **Redouane Paysagiste**. Développé avec **Java 17** et **Spring Boot**, il fournit les données dynamiques au Frontend (services, réalisations filtrables) et intègre le moteur d'estimation automatique des demandes de devis.

---

## 🚀 Technologies utilisées

* **Langage :** Java 17
* **Framework :** Spring Boot 3.2.3 (Starter Web)
* **Build Tool :** Maven
* **Conteneurisation :** Docker (Multi-stage build)
* **Hébergement :** Render.com

---

## 🛠️ Documentation des Endpoints API

### 1. Obtenir la liste des services
* **URL :** `/api/services`
* **Méthode :** `GET`
* **Description :** Renvoie la liste complète des prestations avec leurs tarifs de base au $m^2$.

### 2. Obtenir les réalisations
* **URL :** `/api/realisations`
* **Méthode :** `GET`
* **Paramètre Query (optionnel) :** `category` (`taille`, `gazon`, `terrasse`, `all`)
* **Exemple :** `/api/realisations?category=terrasse`

### 3. Calculer & créer un devis
* **URL :** `/api/devis`
* **Méthode :** `POST`
* **Corps de la requête (JSON) :**
  ```json
  {
    "name": "Jean Dupont",
    "email": "jean.dupont@example.com",
    "phone": "0612345678",
    "serviceId": 1,
    "surface": 150.0
  }
  ```
* **Réponse (JSON) :**
  ```json
  {
    "success": true,
    "message": "Devis généré avec succès !",
    "estimate": {
      "service": "Tonte de pelouse",
      "surface": 150.0,
      "totalEstimatedPrice": "75.00"
    }
  }
  ```

---

## 💻 Exécution en Local

### Prérequis
* Java 17 SDK
* Maven 3.x

### Lancement de l'application
```bash
mvn clean spring-boot:run
```
L'API sera accessible localement sur : `http://localhost:8080/api/services`

---

## 🐳 Conteneurisation Docker

### 1. Créer l'image Docker
```bash
docker build -t paysagiste-backend .
```

### 2. Lancer le conteneur
```bash
docker run -p 8080:8080 paysagiste-backend
```

---

## ☁️ Déploiement sur Render

1. Assurez-vous que le projet est poussé sur votre dépôt GitHub.
2. Sur **Render.com**, créez un **New Web Service**.
3. Associez votre dépôt GitHub `paysagiste-backend`.
4. Sélectionnez l'environnement **Docker**.
5. Validez le déploiement. Render construira le conteneur et attribuera le port dynamiquement via la variable `${PORT}`.
