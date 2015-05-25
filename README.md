JTechLog JPA több one-to-many kapcsolat
=======================================

Ez a program a JTechLog (<http://www.jtechlog.hu>) blog "JPA több one-to-many kapcsolat" cikkéhez készült példaprogram. 
Prezentálja a több one-to-many kapcsolat esetén jelentkező problémákat Hibernate perzistence provider esetén.
A projekt letöltése után az 'mvn test' paranccsal futtatható a teszt eset. Ez egy JUnit teszt eset, mely felépíti a Spring context-et, 
elindít egy beépített HSQLDB adatbáziskezelőt, létrehozza a táblákat, feltölti adatokkal, majd meghívja a service-t, mely JPA 
lekérdezéseket használ, és a visszatérési értéket Hamcresttel ellenőrzi.

Felhasznált technológiák: Spring, Hibernate, HSQLDB, SLF4J, Log4J, JUnit, Hamcrest, Maven

viczian.istvan a gmail-en