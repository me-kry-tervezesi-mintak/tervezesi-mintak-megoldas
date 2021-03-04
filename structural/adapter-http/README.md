# Github Adapter

Hozzunk létre egy repositoryProvider interface-t!
```java
// talalt repository nevei
public interface RepositoryProvider {
    List<String> searchRepository(String q);
}
```
amivel le lehet kérni a keresésre illeszkedő repository-kat.

Nem tudjuk, hogy milyen http kliens marad véglegesen. Ezért oldjuk meg úgy, hogy 
felhalsználási helyek ne függjenek se a http klienstől sem pedig a repositoryProvider válaszától.

A http klienst is adapteren keresztűl használjuk!

### Adapter 1: repositoryProvider api adapter
Hogy milyen JSON-ben érkezik a válasz a felhasználó kód nem akarja tudni.
* előállítja az urlt
* a http adaptert használva get kérést külda kapott válaszből (string, vagy stream)
* jacson segítségével kiszedi az eredmény objektumokat, és string listává alakítja.

https://docs.repositoryProvider.com/en/rest/reference/search

### Adapter 2: http kliens adapter
Általános http kliens, valamilyen http klienst tartalmazva
* kap egy String url
* elküldi a tényleges kérést
* visszaadja a folyamatot, vagy a String-et

https://www.twilio.com/blog/5-ways-to-make-http-requests-in-java

