package ro.pub.cs.systems.eim.lab06.singlethreadedserver.network;

import android.util.Log;
import android.widget.EditText;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import ro.pub.cs.systems.eim.lab06.singlethreadedserver.general.Constants;
import ro.pub.cs.systems.eim.lab06.singlethreadedserver.general.Utilities;

public class CommunicationThread extends Thread {
    private Socket socket;
    private EditText serverTextEditText;

    public CommunicationThread(Socket socket, EditText serverTextEditText) {
        this.socket = socket;
        this.serverTextEditText = serverTextEditText;
    }

    @Override
    public void run() {
        try {
            Log.v(Constants.TAG, "CommunicationThread started for " + socket.getInetAddress());

            // TODO exercise 5c: Simulare întârziere 3 secunde
            Thread.sleep(3000);

            // Trimitere mesaj (codul de la liniile 56-59 din ServerThread)
            PrintWriter printWriter = Utilities.getWriter(socket);
            printWriter.println(serverTextEditText.getText().toString());
            printWriter.flush();

            socket.close();
            Log.v(Constants.TAG, "CommunicationThread finished and socket closed");
        } catch (IOException | InterruptedException e) {
            Log.e(Constants.TAG, "Error in CommunicationThread: " + e.getMessage());
        }
    }
}