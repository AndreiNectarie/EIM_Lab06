
Server-CLient

1) echo "hello world" | nc -l 5000 -> trimite mesajul device urilor care se conecteaza la server
ul deschis pe portul 5000 
2) adb forward tcp:8000 tcp:5000   -> deschide tunelul intre tel -> server.
3) export PATH=$PATH:~/Library/Android/sdk/platform-tools -> ca sa folosesc adb
4) adb shell -> sa deschid terminal in telefon
5) nc 127.0.0.1 8000 -> ma conectez la server ul local pe portul 8000
6) lsof -i :5000 -> verific ce procese sunt pe portul 5000
7) 