# Adapter

Adott egy `FileManagerUtil` interfész, ami koncepció idegen,

Feladat írni egy `FileManagerAdapter`-t, ami átalakítja a felületet
`FileManagerUtil`-ról `FileManager`-re.
Az adapter tárolja a `FileManagerUtil` egy referenciáját, és minden kérést a FileManagerUtil
referenciájának delegál tovább, elvégezve a megfelelő konverziókat paraméteren, és visszatérési értéken.