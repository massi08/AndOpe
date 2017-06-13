Bouneffa Massinissa p13109390 & Abebe Fanuel p1311388

Contenu du projet:

12/06/2017  16:31             3 306 andope.sql // Script pour créer notre BDD
12/06/2017  10:16             9 368 pom.xml // Script pour compiler avec maven
13/06/2017  17:09                74 Readme.txt // Ce fichier
13/06/2017  17:08    <DIR>          src // Dossier contenant nos fichiers java. Le backend dans /java et le frontend dans webapp/
13/06/2017  13:24    <DIR>          target // Dossier contenant l'executable (.war) de l'application web
               5 File(s)         19 762 bytes
               5 Dir(s)  23 232 376 832 bytes free

Adresse du site:
Si le problème des VMs de la fac est réglé le lien pour accéder au site depuis le réseau de l'université serait:
http://192.168.77.7/

Pour compiler:
mvn -T 4 clean install tomcat7:run (lance un serveur tomcat sur localhost:8080