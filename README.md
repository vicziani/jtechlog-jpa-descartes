JTechLog JPA több one-to-many kapcsolat
=======================================

Ez a program a JTechLog (<http://jtechlog.blogspot.com>) blog "JPA több one-to-many kapcsolat" cikkéhez készült példaprogram. 
Prezentálja a több one-to-many kapcsolat esetén jelentkező problémákat Hibernate perzistence provider esetén.
A projekt letöltése után az 'mvn test' paranccsal futtatható a teszt eset. Ez egy JUnit teszt eset, mely felépíti a Spring context-et, 
elindít egy beépített HSQLDB adatbáziskezelőt, létrehozza a táblákat, feltölti adatokkal, majd meghívja a service-t, mely JPA 
lekérdezéseket használ, és a visszatérési értéket Hamcresttel ellenőrzi.

Felhasznált technológiák: Spring 3.2.2, Hibernate 4.1.10, HSQLDB 2.2.9, SLF4J 1.6.4, Log4J 1.2.17, JUnit 4.11, Hamcrest 1.3, 
Maven 3.0.3

viczian.istvan a gmail-en