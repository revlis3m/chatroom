# Projet de Chat Java RMI

## Description

Ce projet implémente une application de chat en ligne utilisant Java RMI (Remote Method Invocation). Plusieurs utilisateurs peuvent se connecter à une salle de chat, envoyer des messages et recevoir des messages en temps réel. L'interface utilisateur est construite en utilisant Swing pour offrir une interface graphique intuitive.

## Fichiers du projet

### 1. `ChatRoom.java`
**Description :**
Interface définissant les méthodes que le serveur de chat doit implémenter.

**Fonctions :**
- `subscribe(ChatUser user, String pseudo)` : Permet à un utilisateur de rejoindre la salle de chat.
- `unsubscribe(String pseudo)` : Permet à un utilisateur de quitter la salle de chat.
- `postMessage(String pseudo, String message)` : Envoie un message à la salle de chat.

### 2. `ChatRoomImpl.java`
**Description :**
Implémentation de l'interface `ChatRoom`. Gère les utilisateurs et les messages dans la salle de chat.

**Fonctions :**
- Gérer une liste d'utilisateurs abonnés.
- Envoyer les messages postés par un utilisateur à tous les autres utilisateurs abonnés.

### 3. `ChatServer.java`
**Description :**
Programme principal pour démarrer le serveur RMI. Instancie la salle de chat et la lie au registre RMI.

**Fonctions :**
- Créer une instance de `ChatRoomImpl`.
- Enregistrer cette instance dans le registre RMI pour qu'elle soit accessible aux clients.

### 4. `ChatUser.java`
**Description :**
Interface définissant les méthodes que chaque utilisateur du chat doit implémenter.

**Fonctions :**
- `displayMessage(String message)` : Affiche un message à l'utilisateur.

### 5. `ChatUserImpl.java`
**Description :**
Implémentation de l'interface `ChatUser` avec une interface graphique Swing pour l'utilisateur.

**Fonctions :**
- Créer une interface graphique pour envoyer et recevoir des messages.
- Gérer la connexion à la salle de chat via RMI.
- Afficher les messages reçus.

## Instructions pour exécuter l'application

1. **Démarrer le registre RMI** :
    ```sh
    rmiregistry 2000
    ```

2. **Compiler les fichiers Java** :
    ```sh
    javac ChatRoom.java ChatUser.java ChatRoomImpl.java ChatUserImpl.java ChatServer.java
    ```

3. **Lancer le programme serveur** :
    ```sh
    java ChatServer
    ```

4. **Lancer le programme client** :
    ```sh
    java ChatUserImpl
    ```

## Fonctionnalités

- **Multi-utilisateurs** : Permet à plusieurs utilisateurs de se connecter simultanément à la salle de chat.
- **Interface Graphique** : Utilise Swing pour offrir une interface utilisateur intuitive et conviviale.
- **Communication en temps réel** : Les messages envoyés par un utilisateur sont immédiatement diffusés à tous les autres utilisateurs.

## Exigences

- Java JDK (1.8 ou supérieur)
- Connaissance de base en Java et en programmation réseau

## Auteur

Silver

## Licence

Ce projet est sous licence [MIT].
