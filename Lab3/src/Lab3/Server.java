package Lab3;
import java.io.*;
import java.net.Socket;
import java.net.ServerSocket;
import java.util.LinkedList;

public class Server {

    public static final int Port = 8080;
    public static LinkedList<Connection> serverList = new LinkedList<Connection>(); // список всех нитей
    public static DAOStudents students = new DAOStudents("Students.xml");
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(Port);
        try {
            while (true) {
                // Блокируется до возникновения нового соединения:
                Socket socket = server.accept();
                try { serverList.add(new Connection(socket, students)); }
                catch (IOException e) {
                    // Если завершится неудачей, закрывается сокет,
                    // в противном случае, нить закроет его при завершении работы:
                    socket.close();
                }
            }
        } finally {
            server.close();
        }
    }
}