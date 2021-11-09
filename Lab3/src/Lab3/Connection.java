package Lab3;
import java.net.Socket;
import java.net.ServerSocket;
import java.io.*;

public class Connection extends Thread {

    private Socket socket; // сокет, через который сервер общается с клиентом,
    // кроме него - клиент и сервер никак не связаны
    private BufferedReader in; // поток чтения из сокета
    private BufferedWriter out; // поток записи в сокет
    private DAOStudents students;

    public Connection(Socket socket, DAOStudents students) throws IOException {
        this.socket = socket;
        this.students = students;
        // если потоку ввода/вывода приведут к генерированию исключения, оно проброситься дальше
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        start(); // вызываем run()
    }

    private class IdEquals implements DAOStudents.ProcessFunction {
        private int id;
        private DAOStudents.Student student;

        public IdEquals(int id){
            this.id = id;
        }
        public void ProcessStudent(DAOStudents.Student student) {
            if (student.GetId() == id) {
                this.student = student;
            }
        }
        DAOStudents.Student GetStudent(){
            return student;
        }
    }
    @Override
    public void run() {
        String inputData;
        try {
            while (true) {
                inputData = in.readLine();
                if(inputData.equals("get student with id")) {
                    inputData = in.readLine();
                    int id = Integer.parseInt(inputData);
                    IdEquals idEquals = new IdEquals(id);
                    students.EnumStudents(idEquals);
                    DAOStudents.Student student = idEquals.GetStudent();
                    out.write(student.GetName());
                    out.newLine();
                    out.write(student.GetGroup());
                    out.newLine();
                    out.write(student.GetId());
                    out.newLine();
                    out.flush();
                } else if(inputData.equals("delete student with id")){
                    inputData = in.readLine();
                    int id = Integer.parseInt(inputData);
                    students.DeleteStudentWithId(id);
                }
            }

        } catch (IOException e) {
        }

    }
    private void send(String msg) {

    }
}