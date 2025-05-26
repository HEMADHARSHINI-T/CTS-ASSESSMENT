

 29. Records (Java 16+)
record Person(String name, int age) {}

import java.sql.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.stream.*;
import java.net.http.*;
import java.net.URI;
import java.io.IOException;

public class Main {
    30. Pattern Matching for switch (Java 21)
    static void checkObjectType(Object obj) {
        switch (obj) {
            case Integer i -> System.out.println("Integer: " + i);
            case String s -> System.out.println("String: " + s);
            case Double d -> System.out.println("Double: " + d);
            default -> System.out.println("Unknown type");
        }
    }

    public static void main(String[] args) throws Exception {
        29. Records
        List<Person> people = List.of(
            new Person("Alice", 30),
            new Person("Bob", 20),
            new Person("Charlie", 25)
        );
        people.forEach(System.out::println);
        people.stream().filter(p -> p.age() >= 25).forEach(System.out::println);

        30. Pattern Matching
        checkObjectType("Hello");
        checkObjectType(100);
        checkObjectType(99.9);

        36. HTTP Client API (Java 11+)
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.github.com"))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println("Status: " + response.statusCode());
        System.out.println("Body: " + response.body());

         40. Virtual Threads (Java 21)
        long start = System.currentTimeMillis();
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 100_000; i++) {
            threads.add(Thread.startVirtualThread(() -> System.out.println("Hello from virtual thread!")));
        }
        for (Thread t : threads) t.join();
        System.out.println("Time taken: " + (System.currentTimeMillis() - start) + " ms");

        41. ExecutorService and Callable
        ExecutorService executor = Executors.newFixedThreadPool(5);
        List<Callable<String>> tasks = IntStream.range(0, 5)
                .mapToObj(i -> (Callable<String>) () -> "Task " + i + " result")
                .collect(Collectors.toList());
        List<Future<String>> results = executor.invokeAll(tasks);
        for (Future<String> f : results) {
            System.out.println(f.get());
        }
        executor.shutdown();
    }
}

31. Basic JDBC Connection and 32. Insert/Update Operations
class StudentDAO {
    private Connection conn;

    public StudentDAO() throws Exception {
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/yourdb", "root", "password");
    }

    public void fetchStudents() throws Exception {
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM students");
        while (rs.next()) {
            System.out.println(rs.getInt("id") + ", " + rs.getString("name"));
        }
    }

    public void insertStudent(int id, String name) throws Exception {
        PreparedStatement ps = conn.prepareStatement("INSERT INTO students VALUES (?, ?)");
        ps.setInt(1, id);
        ps.setString(2, name);
        ps.executeUpdate();
    }

    public void updateStudent(int id, String name) throws Exception {
        PreparedStatement ps = conn.prepareStatement("UPDATE students SET name=? WHERE id=?");
        ps.setString(1, name);
        ps.setInt(2, id);
        ps.executeUpdate();
    }
}

 33. JDBC Transaction
class AccountService {
    private Connection conn;

    public AccountService() throws Exception {
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/yourdb", "root", "password");
    }

    public void transfer(int fromId, int toId, double amount) throws Exception {
        conn.setAutoCommit(false);
        try {
            PreparedStatement debit = conn.prepareStatement("UPDATE accounts SET balance = balance - ? WHERE id = ?");
            debit.setDouble(1, amount);
            debit.setInt(2, fromId);
            debit.executeUpdate();

            PreparedStatement credit = conn.prepareStatement("UPDATE accounts SET balance = balance + ? WHERE id = ?");
            credit.setDouble(1, amount);
            credit.setInt(2, toId);
            credit.executeUpdate();

            conn.commit();
        } catch (Exception e) {
            conn.rollback();
            e.printStackTrace();
        } finally {
            conn.setAutoCommit(true);
        }
    }
}






39. Reflection
class ReflectionDemo {
    public void sayHello(String name) {
        System.out.println("Hello, " + name);
    }

    public static void main(String[] args) throws Exception {
        Class<?> cls = Class.forName("ReflectionDemo");
        Object obj = cls.getDeclaredConstructor().newInstance();
        for (var method : cls.getDeclaredMethods()) {
            System.out.println("Method: " + method.getName());
            if (method.getName().equals("sayHello")) {
                method.invoke(obj, "World");
            }
        }
    }
}
