# Role-Based Access Control (RBAC) System

## 📌 Overview
This project is a **Role-Based Access Control (RBAC) system** implemented in Java. The system assigns **roles** to users, and each role has a specific set of **permissions** (Read, Write). Users can perform actions based on their assigned role's permissions.

## ⚙️ Features
- Users have assigned roles.
- Roles define a set of permissions.
- Supports Read and Write permissions.
- Dynamic permission checks.
- No usage of Java Collection Framework (uses arrays instead).

## 🛠️ How It Works
1. **Permissions (`Permission` Interface)**
   - Defines `hasAccess()` method to check access.
   - Defines `getPermissionName()` to retrieve permission name.
   
2. **Permissions Implementations**
   - `ReadPermission` → Grants read access.
   - `WritePermission` → Grants write access.
   
3. **Roles (`Role` Abstract Class)**
   - Holds an array of permissions.
   - Allows adding permissions.
   - Retrieves a list of assigned permissions.
   
4. **Role Implementations**
   - `Admin` → Has Read & Write permissions.
   - `Editor` → Has Write permission.
   - `Viewer` → Has Read permission.
   
5. **User Class**
   - Each user is assigned a role.
   - Can retrieve their role's permissions.

## 📌 Example Usage
### Code
```java
public class Example81 {
    public static void main(String[] args) {
        User admin = new User("Dileepa", new Admin());
        User editor = new User("Nimal", new Editor());
        User viewer = new User("Kamal", new Viewer());
        User editor1 = new User("Amal", new Editor());

        System.out.println(admin.getName() + " has permissions: " + admin.getPermissions());
        System.out.println(editor.getName() + " has permissions: " + editor.getPermissions());
        System.out.println(viewer.getName() + " has permissions: " + viewer.getPermissions());
        System.out.println(editor1.getName() + " has permissions: " + editor1.getPermissions());
    }
}
```

### Output
```
Dileepa has permissions: Read, Write
Nimal has permissions: Write
Kamal has permissions: Read
Amal has permissions: Write
```

## 🚀 How to Run
1. Clone the repository:
   ```sh
   git clone <repository-url>
   ```
2. Navigate to the project directory:
   ```sh
   cd rbac-system
   ```
3. Compile the Java files:
   ```sh
   javac Example81.java
   ```
4. Run the program:
   ```sh
   java Example81
   ```

## 📜 License
This project is open-source and available under the **MIT License**.

