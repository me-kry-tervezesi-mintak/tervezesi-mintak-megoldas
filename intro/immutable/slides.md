# Immutable objektumok

---
# Állandó állapotú objektumok (immutable)

* Osztályok attribútumai lehetnek állandóak, állapota módosíthatatlan
* Beállításuk csak a deklarációban vagy konstruktorban lehetséges
* `final` kulcsszóval lehetséges
* Nincs módosító metódus, `final` miatt nem is módosítható az attribútum
* Az ilyen osztályok szálbiztosak
* Ez a megoldás biztonságosabb, mert nincs véletlen módosítás kívülről
* Amennyiben referenciát tartalmaz más objektumra, az is legyen immutable, vagy másolatot adjon vissza
