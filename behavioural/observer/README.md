# Observer

Egy roboton belül együttműködő rendszert fogunk szimulálni. A robotot mozgató (Rower) és a robot karját emelő (Arm) 
egységek csak akor működhetnek, ha biztonságos. Ahalyett, hogy ezek az egységek folyamatosan lekérdeznék a távolság 
érzékelő egységtől az adott értéket, feliratkoznak, mint megfigyelők, és amikor változás következik be,
akkor értesítést kapnak. Haliwood elv alapján működik. (álló robot esetében nem árasztják el a rendszert felesleges 
lekérdezéssel)

Hozz létre két interfészt:
* `DistanceObserver`
  * előírja az értesítés módját, paraméterét: `void update(int distance);`
* `DistanceSensor`
  * metódusokat deklarál a fel és leiratkozásra
    * `void register(DistanceObserver distanceObserver);`
  	* `void unregister(DistanceObserver distanceObserver);`
  	
Hozz létre egy `DistanceSersorImpl` osztályt, ami implementálja a `DistanceSensor` interfészt.
* Amely nyilvántartja a megfigyelőket
  * privát `distanceObservers` listában tárolja (`DistanceObserver`-ek)
  * `register` eltárolja a listában a megfigyelőt  
  * `unregister` törli a listából a megfigyelőt
* Értesíti a megfigyelőket a változásról
  *  publikus `simulateData(int data)`, értesíti a megfigyelőket. 
  (végigjárja a `distanceObservers` listán és hívja a `DistanceObserver`-ek `update` metódusát.)
  
Hozz létre egy `Arm` osztályt, amely a `DistanceObserver` interfészt implementálja.
* legyen egy `blocked` adattagja, amely ha igaz, akkor az egység működik.
* definiálj gettert a `blocked` attribútumra.
* szükség van egy `MINIMUM_DISTANCE` final attribútumra is, aminek értéke 350.
* konstruktor 
  * megkapja a `DistanceSensor` függőségét, és eltárolja egy privát attribútumban.
  * beregisztrálja az eszközt a Senzorra.
  * beállítja a `MINIMUM_DISTANCE` 350-re
* implementálja az interfész metódusát ugy, hogy
  * ha a kapott távolság kisebb, mint a `MINIMUM_DISTANCE`, akkor letiltja az eszközt.
* `switchOff` metódus, ami kikapcsolja az egységet
  * blokkoltá teszi, és
  * törli a regisztrációt a szenzornál.
* lift valósában mozgatná a kart, ha nincs tiltva. Itt csak visszatér, hogy sikerült-e a művelet.
(sikerült, ha nincs tiltva)

Hozz létre egy `Rower` osztályt, amely a `DistanceObserver` interfészt implementálja.
* legyen egy `blocked` (igaz, akkor az egység működik) és egy `movingForward` adattagja (igaz, akkor az egység mozog)
* definiálj gettereket az attribútumokra.
* szükség van egy `MINIMUM_DISTANCE` final attribútumra is, aminek értéke 650.
* konstruktor 
  * megkapja a `DistanceSensor` függőségét, és eltárolja egy privát attribútumban.
  * beregisztrálja az eszközt a Senzorra.
  * beállítja a `MINIMUM_DISTANCE` 650-re
* szükség van egy `emergencyStop` privát metódusra, amely most csak 
* implementálja az interfész metódusát ugy, hogy
  * ha a kapott távolság kisebb, mint a `MINIMUM_DISTANCE`, akkor letiltja az eszközt.
  * Ha túl közel van, akkor meghívja az `emergencyStop` metódust.
* `switchOff` metódus, ami kikapcsolja az egységet
  * blokkoltá teszi, és
  * törli a regisztrációt a szenzornál.
* `moveForward` valósában mozgatná a robot, ha nincs tiltva. Itt csak visszatér, hogy sikerült-e a művelet, és bebillenti 
a `movingForward` attribútumot. (sikerült, ha nincs tiltva)

Érdemes lenne bevezetni egy `Actuator` osztályt bevezetni, mert az `Arm` és `Rower` osztályok viselkedése, 
működése nagyon hasonló.
