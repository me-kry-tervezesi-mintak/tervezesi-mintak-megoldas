# Immutable

## Ellenőrző kérdések

* Hogyan kell egy attribútum változását megakadályozni?
* A final tagot csak korlátozottan lehet módosítani. Hol lehetnek `final` attribútumot módosító kódok?

## Bolygók felfedezése

A fő feladat az `Astronomer` osztály elkészítése, de annak vannak előfeltételei, függőségei. Olvasd el az egészet, majd haladj szépen sorban. Ha mindenzeket megcsináltad, lefodul, de nem fog csinálni semmit!

Hozz létre egy `Planet` nevű osztályt, amelynek állapota nem változhat! Most csak olyan attribútumok vannak,
amelyek nem változnak. A Bolygót, amikor felfedezik, akkor meghatározzák az átmérőjét, és 
el is nevezik (tároljuk azeket a radius, name attribútumokba). (A bolygó életében ezek az adatok nem fognak változni.)
Hozz létre egy konstruktort, amelyben az objektum megkapja a két adatot kívülről, és rendre beállítja azokat!
Hozz létre getter metódusokat az addatogokra!

Szükség van még egy `EquatorialCoordinate` osztályra is, amely azt tárolja, hogy hol látjuk a bolygót (relatív adat). 
Két `long` típusú attribútummal rendelkezik: `longitude`, `azimuth`.
(Ezek az adatok sem változnak egy rögzített origójú rendszerben. Ha a megfigyelt entitás változik, pl. bolygó
kering a nap körül, akkor nem a koordinátájának az értéke változik, hanem egy másik koordinátára kerül.) Legyen
ezért a két attribútuma `final`! Hozzunk létre egy konstruktort, amely megkap két `long` típust, és beállítja az attribútumok 
értékét! Hozzunk létre getter metódusokat az attribútumokra!

Hozz létre egy interfészt `PlanetCalculator`, amely segít meghatározni egy adott helyen levő bolygó átmérőjét!
Egy long `getPlanetRadiusInPosition(Point point)` metódust tartalmaz! Ennek az implementációját majd megadják a 
felhasználás során (a valóságban is más megvalósítása volt 300 éve és más most), neked csak használni kell.

Hozz létre egy osztály amely tárolja a bolygó abszolút koordinátáit (`Point`). A bolygó abszolút helyzetét írja le.
Ennek az osztálynak három attribútuma van,  `x`, `y`, `z`. 
Hozzunk létre egy konstruktort, amely megkap három `long` típust, és beállítja az attribútumok értékét! 
Hozzunk létre getter metódusokat az attribútumokra!

Hozz létre egy interfészt, amely a nemzetközi csillagász szövetség szolgáltatásait definiálja `InternationalActronomicalUnion` néven, 
amelyek legyenek a következök:

```java
boolean isThePlanetDiscovered(Date noticeDate, EquatorialCoordinate equatorialCoordinate)
```

Visszaadja, hogy az adott pillanatban adott helyen látszó bolygót felfedezték e már (igaz, ha már ismert)

```java
Point getRealPosition(Date noticeDate, EquatorialCoordinate equatorialCoordinate)
```

Visszaadja az abszolút koordinátát a viszonylagos koordináta függvényében.

```java
boolean register(Planet planet, Point position)
```

Beregisztrálja az új bolygót. Hamissal tér vissza, ha a regisztrációt nem sikerült. (Már felfedezték, vagy egyéb akadálya van.)
(Az implementációt, majd megadják később.)

Végül hozzunk létre egy központi csillagász osztályt (`Astronomer`), amely az előzőeket használja! Minden csillagásznak van neve, 
nyilvántartja hogy milyen bolygókat fedezett fel (`List<Planet>` típusú). 
Működéséhez szükség van továbbá két külső entitásra: a már létező `InternationalActronomicalUnion` és a `PlanetCalculator` 
egy egy példányára (4 attribútum). 
Szükség van egy konstruktorra, amellyel az attribútumok beállíthatóak (név + két függőség). 
Szükség van egy getterre, amely visszaadja a felfedezett bolygókat (`getDiscoveredPLanets`).

A csillagász figyeli az égboltot. Adott pillanatban, adott helyet figyeli, amelyet a következő metódus szimulál:

```java
public boolean observeTheSky(Date date, EquatorialCoordinate equatorialCoordinate)`
```

Ez a metódus lekérdezi a nemzetközi szövetséget, hogy az adott helyen látszó valamit felfedezték-e már (`isThePlanetDiscovered`).
Ha még nem, akkor lekérdezi a szövetségtől a valódi abszolút koordinátát (`getRealPosition`), majd kiszámíttatja az adott 
koordinátán levő égitest átmérőjét (`getPlanetRadiusInPosition`). 
Az új adatok birtokában beregisztrálja az új égitestet, használva a saját nevét (magáról nevezi el).

Ha a regisztráció sikeres volt, akkor eltárolja az új bolygót a saját listáján.

Hamissal tér vissza, ha új bolygót sikerült felfedeznie, de a nemzetközi regisztráció sikertelen volt (minden más eset sikeres).

## Bónusz feladat 1.

Hozz létre egy Naprendszer (`SolarSystem`) nevű osztályt, amelyben négy bolygót tárolsz el (Mercury, Venus, Earth, Mars). 
Ezen értékei nem változhatnak.

## Bónusz feladat 2.

Hozz létre egy factory-t a bolygók létrehozására, amely `create` metódusa megkapja a
bolygó nevét, és visszatér az adott bolygó példányával.



