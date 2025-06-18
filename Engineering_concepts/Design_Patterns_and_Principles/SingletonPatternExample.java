package Engineering_concepts.Design_Patterns_and_Principles;

class Logger {
    // Step 1: Create a private static instance of Logger (eager initialization)
    private static Logger instance = new Logger();

    // Step 2: Make the constructor private so no other class can instantiate it
    private Logger() {
        System.out.println("Logger instance created");
    }

    // Step 3: Provide a public static method to get the single instance
    public static Logger getInstance() {
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
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();
        Logger logger3 = Logger.getInstance();

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
