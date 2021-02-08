# Építő (builder) tervezési minta

## Ellenőrző kérdések

* Hogyan könnyíti meg a minta részek létrehozását?
* Milyen feltételeknek kell megfelelnie a settereknek, hogy láncolhatóak legyenek?
* Miért nem statikusak a metódusok?

## Robot vezérlő keretek létrehozása builder minta segítségével

A robot egységeit soros poron (usb) keresztül vezéreljük úgy, hogy byte
folyamokat írunk arra. Egy beágyazott rendszer fut, amely értelmezi a kereteket, és 
kiadja a hardverre a megfelelő feszültségeket. A keretek fix hosszúságúak,
szabályok rögzítik a felépítésüket, melyek a következők:
* Minden keret a parancs azonosítójával kezdődik. 
* Minden keret egy checksummal fejeződik be!
(A checksumot úgy állítjuk elő, hogy egy byte változóban összegezzük az összes értéket. 
Nem probléma, ha túlcsordulás következik be.)
Érdemes egy `private byte checksum()` metódust létrehozni a builderekben erre, a következő tartalommal.
```java
for (byte i = 0; i < bytes.length; i++) {
    checksum += bytes[i];
}
```

Hozz létre egy keret `Frame` osztályt, amely attribútumként tartalmazza a byte tömböt!
Hozz létre egy konstruktort, amellyel az attribútum értéke beállítható!
Definiálj egy getter metódust az attribútum kinyerésére!
Definiálj egy `public String toHex()` metódust, amely visszaadja a tárolt byte tömb string reprezentációját!
A byte-okat `-` jellel válaszd el, és a tömb elemek értékeit hexadecimális értékben fűzd be! (Célszerű használni a 
`String.format` metódust. Formátum string-nek használd a `%02X` értéket). Figyelj, mert kötőjel nincs az első byte előtt,
 és az utolsó után sem. (pl.: `7D-01-02-03-04-87`)

* Minden konkrét builder példány metódusokat definiáljon (injektálható)!
* Minden konkrét builder tartalmazzon egy `public Frame build()` metódust, amely majd létrehozza, és visszaadja a keretet!
* Minden konkrét builder tartalmazzon egy private mezőt (byte tömb), amibe gyűjti, változtatja a leendő keret tartalmát!
* Minden konkrét builder tartalmazzon egy private `checksum()` metódust, ami visszaadja az ellenőrző összeg értékét!

Hozz létre egy mozgató parancs buildert `MoveFrameBuilder`! Ez képes olyan kereteket létrehozni, amelyek
mozgatják a robotot.
* parancs kód: 7D (hexa) =  125 (decimális)
* általános felépítés: `7D-XX-YY-RR-MV-CM`
* ahol a paraméterek:
  * XX velocity: a sebesség vektor X komponense (oldalra) világkoordinátában értelmezve. Értéke 127 - -127 lehet. YY velocity: a sebesség vektor y komponense (előre) világkoordinátában értelmezve. Értéke 127 - -127 lehet. 
  * RR - forgás sebessége:
    * 0 értékre balra forog teljes sebességgel, 
    * 62 értékre nem forog (0x3e)
    * 124 értékre jobbra forog teljes sebességgel
  * MV - maximális sebesség: maga a sebesség a 127 érték mind x, mind y komponenseknél ezt a sebességet jelenti.
  * CM - checksum: ellenőrző összeg
* példák:
  * `7D-00-5E-3E-80-99`  1 m/s előre
  * `7D-00-00-3E-80-3B` megállít
* használat:
```java
  moveFrameBuilder
    				.setXSpeed((byte)1)
    				.setYSpeed((byte)2)
    				.setRotationSpeed((byte)3)
    				.setMaximumSpeed((byte)4)
    				.build();
```

Hozz létre egy beállító parancs buildert, lásd `SetMovementCapabilityFrameBuilderTest`! Ez képes olyan kereteket létrehozni, amellyel
a robot sebessége, gyorsulása beállítható. A default értékeket a builder konstruktorában érdemes beállítani.
* parancs kód: 04 (hexa) =  4 (decimális)
* általános felépítés: `04-VE-AV-AC-AA-CM`
* ahol a paraméterek:
  * VE - Maximális sebesség (**default érték: 96**)
  * AV - Maximális forgási sebesség (**default érték: 10**)
  * AC - Maximális gyorsulás (**default érték: 98**)
  * AA - Maximális forgási gyorsulás (**default érték: 8**)
  * CM - checkSum: ellenörző összeg
* Példák:
  * `04-0C-05-0C-02-23` - jelentése 101,10,101,10-re állítja a megfelelő értékeket.
* Használat: 

```java
new SetMovementCapabilityFrameBuilder()
             				.setMaximumAcceleration((byte)0)
             				.setMaximumRotationalAcceleration((byte)0)
             				.setMaximumSpeed((byte)0)
             				.setMaximumRotationSpeed((byte)0)
             				.build();
```
  
  