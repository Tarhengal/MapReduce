# MapReduce

## But du projet :

Compter les mots de manieres efficace dans des fichiers .txt volumineux, pour ca on va utiliser le principe de map ruduce implementé par Hadoop et du multi threading.

## Comment fonctionne le code :

On lit nos fichiers .txt et on recupère les données, on va créer a partir de ca des listes de mots.

On envoie nos listes de mots dans des mapeurs qui vont dans un premier temps compter le nombre d'occurences de chaques mots et les stockers dans un hashmap.
Puis on va shuffle ce Hasmap dans une liste de Hasmap (en fonction du nombre de reducer que l'on va utiliser). On va calculer le code ASCII de chaques mots puis recuperer le retse de la division Euclidienne de ce code avec le nombre de reducers que l'on auras, et on envoie le mot et ca value dans le Hashmap correspondant.

On envoie ensuite les listes de Hashmap dans les reducers qui vont retourner un seul Hashmap avec le bon nombre d'occurences de mot.

On a juste a passer les Hashmap recuperés une derniere fois dans un reduceur pour recuperer le Hashmap final avec les occurences de tous les mots de tous les ficheirs .txt.

## Multi Threading 

On attribue un thread par mappeur et par reducer. 
