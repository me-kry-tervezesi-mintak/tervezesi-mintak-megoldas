# Builder tervezési minta

---

# Építő (builder) tervezési minta

* Új összetett példány létrehozását segíti, elrejti annak lépéseit
* Elkülönül az osztály, és annak példányát létrehozó kód
* A kliensnek nem kell tudni a bonyolult szerkezetről, a létrehozás részleteiről
* A kódban látszik, hogy mit mire állítunk (olvasható a kód)
* A beállító, munkát végző metódusok általában láncolhatók
* Utolsó lépésként egy build metódust hív a használó kód, amely visszaadja a kész
összetett terméket
* Érdemes minden metódust példány metódusnak definiálni, mert így injektálható, mint
függőség, tesztnél kitakarható.
* Alapértelmezett állapot
* Ellenőrzések
