import java.util.Scanner;

class User 
{
    private String username;
    private String password;

    public User(String username, String password) 
	{
        this.username = username;
        this.password = password;
    }

    public String getUsername()                     {return username;}
	
    public String getPassword()                     {return password;}

    public void setPassword(String newPassword)     {this.password = newPassword;}
}

abstract class SmartDevice 
{
     Scanner scanner;

    public SmartDevice(Scanner scanner) 
	{
        this.scanner = scanner;
    }

    public abstract void controlDevice();
}

class SmartLock extends SmartDevice 
{
    private boolean isSmartLockUnlocked = true;

    public SmartLock(Scanner scanner)
	{
        super(scanner);
    }

    //Override
    public void controlDevice() {
        System.out.println("Smart Lock Control Menu:");
        System.out.println("1. Lock Doors");
        System.out.println("2. Unlock Doors");
        System.out.println("3. Generate Access Code");
        System.out.println("4. Go Back");
        System.out.print("Enter your choice: ");
        int smartLockChoice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (smartLockChoice) 
		{
            case 1:
                isSmartLockUnlocked = false;
                System.out.println("Doors locked.");
                break;
				
				
            case 2:
                isSmartLockUnlocked = true;
                System.out.println("Doors unlocked.");
                break;
				
				
            case 3:
               
                System.out.println("Access code generated: 1234");
                break;
				
				
            case 4:
               
                break;
				
				
            default:
                System.out.println("Invalid choice.");
        }
    }

    public boolean isSmartLockUnlocked() {return isSmartLockUnlocked;}
	
	
}

class LightingSystem extends SmartDevice
 {
    private boolean[] lights; 

    public LightingSystem(Scanner scanner, int roomCount)
	{
        super(scanner);
        lights = new boolean[roomCount];
    }

   //Override
    public void controlDevice() 
	{
        System.out.println("Lighting System Control Menu:");
		
		
        while (true)
			{
              System.out.println("Available Rooms:");

           
            for (int i = 0; i < lights.length; i++) 
			{
                String roomStatus = lights[i] ? "On" : "Off";
				
                System.out.println((i + 1) + ". Room " + (i + 1) + " - Lights are " + roomStatus);
            }

            System.out.println("0. Go Back");
            System.out.print("Enter the room number to update lights (0 to go back): ");
            int roomChoice = scanner.nextInt();

            if (roomChoice == 0) 
			{
                break;
			} 
			
			
			else if (roomChoice >= 1 && roomChoice <= lights.length)
				{
                int roomIndex = roomChoice - 1;
                lights[roomIndex] = !lights[roomIndex]; 
                String roomStatus = lights[roomIndex] ? "On" : "Off";
                System.out.println("Lights in Room " + roomChoice + " are now " + roomStatus);
                }

				else 
				{
                System.out.println("Invalid room choice.");
                 }
        }
    }
}

class EntertainmentSystem extends SmartDevice
 {
    public EntertainmentSystem(Scanner scanner)
	{
        super(scanner);
    }

    //Override
    public void controlDevice() 
	{
        System.out.println("Entertainment System Control Menu:");
        
    }
}

class SmartDeviceControls 
{
    private double thermostatTemperature = 72.0;
    private Scanner scanner;

    public SmartDeviceControls(Scanner scanner)
	{
        this.scanner = scanner;
    }

    public void controlThermostat() 
	{
        System.out.println("Thermostat Control Menu:");
        System.out.print("Enter the desired temperature: ");
        double desiredTemperature = scanner.nextDouble();
        scanner.nextLine(); // Consume newline
        thermostatTemperature = desiredTemperature;
        System.out.println("Thermostat set to " + thermostatTemperature + " degrees.");
    }

    public void controlLightingSystem()
	{
        int roomCount = 3;
         LightingSystem lightingSystem = new LightingSystem(scanner, roomCount);

        lightingSystem.controlDevice();
    }

    public void controlEntertainmentSystem() 
	{
        EntertainmentSystem entertainmentSystem = new EntertainmentSystem(scanner);
        entertainmentSystem.controlDevice();
    }
}

class FamilyInformation 
{
    private String[] familyMembers;
    private boolean[] inHome;
    private int familyMemberCount;

    public FamilyInformation(int maxFamilyMembers)
	{
        familyMembers = new String[maxFamilyMembers];
        inHome = new boolean[maxFamilyMembers];
        familyMemberCount = 0;
    }

    public void addFamilyMember(String name) 
	{
        if (familyMemberCount < familyMembers.length) {
            familyMembers[familyMemberCount] = name;
            familyMemberCount++;
        }
		else
			{
            System.out.println("Family member limit reached.");
        }
    }

    public void updateArrivalStatus(int memberIndex, boolean arrived) 
	{
        if (memberIndex >= 0 && memberIndex < familyMembers.length)
			{
            inHome[memberIndex] = arrived;
            String status = arrived ? "arrived" : "left";
            System.out.println(familyMembers[memberIndex] + " has " + status + " home.");
        } else 
		{
            System.out.println("Invalid family member index.");
        }
    }

    public void displayArrivalStatus()
	{
        System.out.println("Family Arrival Status:");
        for (int i = 0; i < familyMemberCount; i++) 
		{
            String status = inHome[i] ? "arrived" : "left";
            System.out.println(familyMembers[i] + " has " + status + " home.");
        }
    }
}

class ReminderSystem 
{
    private String[] reminders;
    private int reminderCount;

    public ReminderSystem(int maxReminders)
	{
        reminders = new String[maxReminders];
        reminderCount = 0;
    }

    public void addReminder(String reminder) {
        if (reminderCount < reminders.length) 
		{
            reminders[reminderCount] = reminder;
            reminderCount++;
            System.out.println("Reminder added: " + reminder);
        } else 
		{
            System.out.println("Reminder limit reached.");
        }
    }

    public void viewReminders() 
	{
        if (reminderCount == 0) 
		{
            System.out.println("No reminders available.");
        } else 
		{
            System.out.println("Reminders:");
            for (int i = 0; i < reminderCount; i++)
			{
                System.out.println("- " + reminders[i]);
            }
        }
    }
}

class Kitchen {
    private boolean isMealReady;
    private String menu;

    public Kitchen() 
	{
        isMealReady = false;
       
               
    }
    
 
 
    public void setMenu(String menu)
	{
        this.menu = menu;
    }

    public void prepareMeal(String mealType) 
	{
        if (!isMealReady) 
		{
            isMealReady = true;
            System.out.println(mealType + " is prepared and ready to serve.");
        } else 
		{
            System.out.println("Meal is already prepared.");
        }
    }

    public void checkMealStatus()
	{
        if (isMealReady)
			{
            System.out.println("Meal is ready to serve.");
        } else 
		{
            System.out.println("Meal is not yet prepared.");
        }
    }

    public void displayMenu() 
	{
        System.out.println("Today's Menu:");
        System.out.println("1.griled chiken with parotta for Lunch");
        System.out.println("2.String Hoppers with dhal- for Dinner" );
    }
}

public class SmartHomeApp 
{
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args)
	{
        User user = null;
        boolean isAuthenticated = false;

        SmartDeviceControls smartDeviceControls = new SmartDeviceControls(scanner);
        FamilyInformation familyInformation = new FamilyInformation(5);
        ReminderSystem reminderSystem = new ReminderSystem(10);
        Kitchen kitchen = new Kitchen();

        while (true) {
            if (!isAuthenticated) {
                System.out.println("Smart Home Automation System:");
                System.out.println("1. Register");
                System.out.println("2. Login");
                System.out.println("3. Exit");
                System.out.print("Enter your choice: ");

                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (choice) {
                    case 1:
                        // Register
                        System.out.print("Enter a new username: ");
                        String newUsername = scanner.nextLine();
                        System.out.print("Enter a new password: ");
                        String newPassword = scanner.nextLine();
                        user = new User(newUsername, newPassword);
                        System.out.println("User registered successfully.");
                        break;

                    case 2:
                        // Login
                        if (user == null) {
                            System.out.println("No user registered. Please register first.");
                            break;
                        }
                        System.out.print("Enter your username: ");
                        String enteredUsername = scanner.nextLine();
                        System.out.print("Enter your password: ");
                        String newPassword2 = scanner.nextLine();

                        if (user.getUsername().equals(enteredUsername) && user.getPassword().equals(newPassword2)) {
                            isAuthenticated = true;
                            System.out.println("User authenticated. Access granted.");
                        } else 
						{
                            System.out.println("Authentication failed. Access denied.");
                            System.out.println("1. Reset Password");
                            System.out.println("2. Go Back");
                            System.out.print("Enter your choice: ");
                            int resetChoice = scanner.nextInt();
                            scanner.nextLine(); // Consume newline
                            if (resetChoice == 1) {
                                System.out.print("Enter a new password: ");
                                newPassword2 = scanner.nextLine();
                                user.setPassword(newPassword2);
                                System.out.println("Password reset successfully.");
                            }
                        }
                        break;

                    case 3:
                        // Exit
                        System.out.println("Exiting Smart Home Automation System.");
                        scanner.close();
                        System.exit(0);
                        break;

                    default:
                        System.out.println("Invalid choice.");
                }
            } else 
			{
                displayMainMenu();
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (choice) {
                    case 1:
                        // Kitchen Details
                        System.out.println("1. Check Meal Status");
                        System.out.println("2. Prepare Lunch");
                        System.out.println("3. Prepare Dinner");
                        System.out.println("4. Display Menu");
                        System.out.println("5. Go Back");
                        System.out.print("Enter your choice: ");
                        int kitchenChoice = scanner.nextInt();
                        scanner.nextLine(); // Consume newline

                        switch (kitchenChoice)
						{
                            case 1:
                                kitchen.checkMealStatus();
                                break;
                            case 2:
                                kitchen.prepareMeal("Lunch");
                                break;
                            case 3:
                                kitchen.prepareMeal("Dinner");
                                break;
                            case 4:
                                kitchen.displayMenu();
                                break;
                            case 5:
                                // Go back to the main menu
                                break;
                            default:
                                System.out.println("Invalid choice.");
                        }
                        break;

                    case 2:
                        // Control Lights
                        int roomCount = 3; // Adjust as needed
                        LightingSystem lightingSystem = new LightingSystem(scanner, roomCount);
                        lightingSystem.controlDevice();
                        break;


                    case 3:
                        // Smart Device Controls
                        System.out.println("Smart Device Controls:");
                        System.out.println("1. Thermostat Control");
                        System.out.println("2. Smart Lock Control");
                        System.out.println("3. Entertainment System Control");
                        System.out.println("4. Go Back");
                        System.out.print("Enter your choice: ");
                        int smartDeviceChoice = scanner.nextInt();
                        scanner.nextLine(); // Consume newline

                        switch (smartDeviceChoice) {
                            case 1:
                                smartDeviceControls.controlThermostat();
                                break;
                            case 2:
                                SmartLock smartLock = new SmartLock(scanner);
                                smartLock.controlDevice();
                                break;
                            case 3:
                                EntertainmentSystem entertainmentSystem = new EntertainmentSystem(scanner);
                                entertainmentSystem.controlDevice();
                                break;
                            case 4:
                                // Go back to the main menu
                                break;
                            default:
                                System.out.println("Invalid choice.");
                        }
                        break;

                    case 4:
                        // Security System
                        System.out.println("1. Activate Alarm");
                        System.out.println("2. Deactivate Alarm");
                        System.out.println("3. Go Back");
                        System.out.print("Enter your choice: ");
                        int securityChoice = scanner.nextInt();
                        scanner.nextLine(); // Consume newline

                        switch (securityChoice) {
                            case 1:
                                System.out.println("Security alarm activated.");
                                break;
                            case 2:
                                System.out.println("Security alarm deactivated.");
                                break;
                            case 3:
                                // Go back to the main menu
                                break;
                            default:
                                System.out.println("Invalid choice.");
                        }
                        break;

                    case 5:
                        // Family Information
                        System.out.println("1. Add Family Member");
                        System.out.println("2. Update Arrival Status");
                        System.out.println("3. Display Arrival Status");
                        System.out.println("4. Go Back");
                        System.out.print("Enter your choice: ");
                        int familyChoice = scanner.nextInt();
                        scanner.nextLine(); // Consume newline

                        switch (familyChoice) {
                            case 1:
                                System.out.print("Enter family member's name: ");
                                String familyMemberName = scanner.nextLine();
                                familyInformation.addFamilyMember(familyMemberName);
                                break;
                            case 2:
                                familyInformation.displayArrivalStatus();
                                System.out.print("Enter family member's index: ");
                                int memberIndex = scanner.nextInt();
                                scanner.nextLine(); // Consume newline
                                System.out.print("Has the family member arrived? (true/false): ");
                                boolean arrived = scanner.nextBoolean();
                                familyInformation.updateArrivalStatus(memberIndex, arrived);
                                break;
                            case 3:
                                familyInformation.displayArrivalStatus();
                                break;
                            case 4:
                                // Go back to the main menu
                                break;
                            default:
                                System.out.println("Invalid choice.");
                        }
                        break;

                    case 6:
                        // Reminder System
                        System.out.println("1. Add Reminder");
                        System.out.println("2. View Reminders");
                        System.out.println("3. Go Back");
                        System.out.print("Enter your choice: ");
                        int reminderChoice = scanner.nextInt();
                        scanner.nextLine(); // Consume newline

                        switch (reminderChoice) {
                            case 1:
                                System.out.print("Enter reminder: ");
                                String reminder = scanner.nextLine();
                                reminderSystem.addReminder(reminder);
                                break;
                            case 2:
                                reminderSystem.viewReminders();
                                break;
                            case 3:
                                // Go back to the main menu
                                break;
                            default:
                                System.out.println("Invalid choice.");
                        }
                        break;

                    case 7:
                        // Logout
                        isAuthenticated = false;
                        System.out.println("Logged out.");
                        break;

                    case 8:
                        // Exit
                        System.out.println("Exiting Smart Home Automation System.");
                        scanner.close();
                        System.exit(0);
                        break;

                    default:
                        System.out.println("Invalid choice.");
                }
            }
        }
    }

    public static void displayMainMenu() {
        System.out.println("\nSmart Home Automation System Menu:");
        System.out.println("1. Kitchen Details");
        System.out.println("2. Control Lights");
        System.out.println("3. Smart Device Controls");
        System.out.println("4. Security System");
        System.out.println("5. Family Information");
        System.out.println("6. Reminder System");
        System.out.println("7. Logout");
        System.out.println("8. Exit");
        System.out.print("Enter your choice: ");
    }
}
