import dao.StudentDao;
import dao.impl.StudentDaoImpl;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Server {

    private static Socket clientSocket;
    private static ServerSocket server;
    private static BufferedReader in;
    private static BufferedWriter out;
    private static StudentDao studentDao;

    public static void main(String[] args) {
        try {
            studentDao = new StudentDaoImpl(new File("database.json"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            try {
                server = new ServerSocket(4004);
                System.out.println("Start server!");
                clientSocket = server.accept();
                try {
                    in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                    out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));

                    String word = in.readLine();
                    Pattern p = Pattern.compile("\\d+");
                    Matcher m = p.matcher(word);
                    int id = 0;
                    while (m.find()) {
                        id = Integer.parseInt(m.group());
                    }
                    System.out.println(id);
                    if (word.contains(String.valueOf(id))) {
                        word = word.substring(0, word.indexOf(String.valueOf(id))).trim();
                    }
                    switch (word) {
                        case "all":
                            out.write(studentDao.getAllStudents().toString());
                            break;
                        case "by id":
                            out.write(studentDao.getStudentById(id).toString());
                            break;
                        case "marks of":
                            out.write(studentDao.getStudentMarksForSubjectsById(id).toString());
                        default:
                            out.write("Your request is incorrect");
                    }
                    out.flush();
                } finally {
                    clientSocket.close();
                    in.close();
                    out.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                System.out.println("Stopped server!");
                server.close();
            }
        } catch (IOException e) {
            System.err.println(e);
        }
    }
}
