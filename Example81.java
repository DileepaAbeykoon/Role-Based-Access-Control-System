class Example81{
    public static void main(String[] args){
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

interface Permission {
    boolean hasAccess();
    String getPermissionName();
}

class ReadPermission implements Permission {
    public boolean hasAccess() {
        return true;
    }
    public String getPermissionName() {
        return "Read";
    }
}

class WritePermission implements Permission {
    public boolean hasAccess() {
        return true;
    }
    public String getPermissionName() {
        return "Write";
    }
}

abstract class Role {
    private Permission[] permissions;
    private int count = 0;
    
    public Role(int maxPermissions) {
        permissions = new Permission[maxPermissions];
    }
    
    public void addPermission(Permission permission) {
        if (count < permissions.length) {
            permissions[count++] = permission;
        }
    }
    
    public String getPermissionNames() {
        StringBuilder permissionList = new StringBuilder();
        for (int i = 0; i < count; i++) {
            if (i > 0) permissionList.append(", ");
            permissionList.append(permissions[i].getPermissionName());
        }
        return permissionList.toString();
    }
}

class Admin extends Role {
    public Admin() {
        super(2);
        addPermission(new ReadPermission());
        addPermission(new WritePermission());
    }
}

class Editor extends Role {
    public Editor() {
        super(1);
        addPermission(new WritePermission());
    }
}

class Viewer extends Role {
    public Viewer() {
        super(1);
        addPermission(new ReadPermission());
    }
}

class User {
    private String name;
    private Role role;
    
    public User(String name, Role role) {
        this.name = name;
        this.role = role;
    }
    
    public String getName() {
        return name;
    }
    
    public String getPermissions() {
        return role.getPermissionNames();
    }
}
