# Ghid Conectare Server (PC) - Client (Telefon)

### 0) Adăugare ADB în PATH (Windows)
Pentru a folosi `adb` direct, adaugă această cale în variabilele de mediu (Environment Variables):
`C:\Users\marcu\AppData\Local\Android\Sdk\platform-tools`

Sau rulează comenzile de mai jos folosind calea întreagă:
`& "C:\Users\marcu\AppData\Local\Android\Sdk\platform-tools\adb.exe" <comandă>`

### 1) Deschide serverul pe PC (Port 5000)
În terminalul WSL:
```bash
echo "Salut de pe server!" | nc -l 5000
```

### 2) Creare tunel (Telefon -> PC)
Dacă vrei ca telefonul să se conecteze la serverul de pe PC, folosim **reverse**:
```bash
adb reverse tcp:8000 tcp:5000
```
*Explicație: Orice cerere trimisă de telefon pe portul 8000 va fi redirecționată către PC pe portul 5000.*

### 3) Verificare conexiune telefon
```bash
adb devices
```

### 4) Intrare în shell-ul telefonului
```bash
adb shell
```

### 5) Conectare la server de pe telefon
În interiorul `adb shell`, rulează:
```bash
nc 127.0.0.1 8000
```

### 6) Utilitare
- `lsof -i :5000` -> (Linux/WSL) Vezi ce proces ascultă pe portul 5000.
- `netstat -ano | findstr :5000` -> (Windows) Vezi ce proces ascultă pe portul 5000.
- `kill -9 <PID>` -> Închide un proces care blochează portul.
