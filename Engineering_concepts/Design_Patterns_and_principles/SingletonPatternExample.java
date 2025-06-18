
class SingletonPattern {
    // Step 1: Create a private static instance of Logger (eager initialization)
    private static SingletonPattern instance = new SingletonPattern();

    // Step 2: Make the constructor private so no other class can instantiate it
    private SingletonPattern() {
        System.out.println("Logger instance created");
    }

    // Step 3: Provide a public static method to get the single instance
    public static SingletonPattern getInstance() {
        return instance;
    }

    // Logging method
    public void log(String message) {
        System.out.println("[LOG] " + message);
    }
}

// TestSingleton.java - Test class to verify Singleton

public class SingletonPatternExample {
    public static void main(String[] args) {
        // Attempt to create multiple Logger instances
        SingletonPattern logger1 = SingletonPattern.getInstance();
        SingletonPattern logger2 = SingletonPattern.getInstance();
        SingletonPattern logger3 = SingletonPattern.getInstance();

        logger1.log("This is the first log message.");
        logger2.log("This is the second log message.");
        logger3.log("This is the third log message.");

        // Verify if all instances are same
        if (logger1 == logger2 && logger2 == logger3) {
            System.out.println("Only one instance of Logger exists.");
        } else {
            System.out.println("Multiple instances detected! Singleton failed.");
        }
    }
}
