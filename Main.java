import java.util.*;
class Supplier{
    String name;
    String id;
}
class Item{
    String id;
    String supId;
    String category;
    String desc;
    double price;
    int qtyOnHand;
}
class Category{
    String name;
}
class Main {
    public static Scanner input = new Scanner(System.in);
    public static Supplier [] suppliers = new Supplier[0];
    public static Item [] items =new Item[0];
    public static Category [] category =new Category [0];
    public static String name = "sandun";
    public static String password = "1234";
    
    public static void main(String[] args){
        printLoginPage();
    }
    
    public static void printLoginPage(){
        clearConsole();
        System.out.println("+---------------------------------------------------------------+");
		System.out.println("|\t\t\tLOGIN PAGE\t\t\t\t|");
		System.out.println("+---------------------------------------------------------------+");
		System.out.println();
        while (true) {
            System.out.print("User name : ");
            String un = input.next();
            System.out.println();
            if (un.equals(name)){
                break;
            }
            System.out.println("User name invalid. please try again! ");
        }
        while (true) {
            System.out.print("password : ");
            String pw = input.next();
            System.out.println();
            if (pw.equals(password)){
                break;
            }
            System.out.println("password is incorrect. please try again! ");
        }
        homePage();
    }
    public static void homePage(){
        clearConsole();
        System.out.println("+---------------------------------------------------------------+");
		System.out.println("|\t\tWELCOME TO IJSE STOCK MANAGEMENT SYSTEM\t\t|");
		System.out.println("+---------------------------------------------------------------+");
		System.out.println();
        System.out.println("[1] Change the Credentials                    [2] Supplier Manage");
        System.out.println("[3] Stock Manage                              [4] Log out");
        System.out.println("[5] Exit the System");
        System.out.println();
        System.out.print("Enter an option to continue > ");
        int options = input.nextInt();
        switch (options) {
            case 1:
                credentialManage();
                break;
            case 2:
                supplierManage();
                break;
            case 3:
                stockManage();
                break;
            case 4:
                logOut();
                break;
            case 5:
                exit();
                break;
            default:
                System.out.println("Invalid Option. Please Try again");
        }
    }
    public static void credentialManage() {
        clearConsole();
        System.out.println("+---------------------------------------------------------------+");
		System.out.println("|\t\t\tCREDENTIAL MANAGE\t\t\t|");
		System.out.println("+---------------------------------------------------------------+");
        while (true) {
            System.out.print("Please enter the user name to verify it's you : ");
			String un = input.next();
            if (un.equals(name)) {
                System.out.println("Hey " + un);
                break;
            }
            System.out.println("Invalid user name. Try again! ");
            System.out.println();
        }
        while(true){
            System.out.print("Enter your current password: ");
            String pw = input.next();
            if (pw.equals(password)) {
                break;
            }
            System.out.println("Incorrect password.try again!");
            System.out.println();
        }
        System.out.print("Enter your New password:");
        password = input.next();
        System.out.print("password changed successfully! ");
        while(true){
            System.out.print("Do you want to go home Page (Y/N)?");
            char option = input.next().charAt(0);
            if(option == 'Y' || option == 'y') {
                homePage();
            } else
                System.exit(0);
        }
    }
    public static void logOut() {
        printLoginPage();
    }
    public static void exit(){
        System.exit(0);
    }
    public static void supplierManage() {
        clearConsole();
        while (true){
        System.out.println("+---------------------------------------------------------------+");
		System.out.println("|\t\t\tSUPPLIER MANAGE\t\t\t\t|");
		System.out.println("+---------------------------------------------------------------+");
		System.out.println();
        System.out.println("[1] Add Supplier              		          [2] Update Supplier");
        System.out.println("[3] Delete Supplier							  [4] View suppliers");
        System.out.println("[5] Search Supplier                 	      [6] Home Page");
        System.out.println();
        System.out.print("Enter an option to continue > ");
        int options = input.nextInt();
            switch (options) {
                case 1:
                    addingSuppliers();
                    break;
                case 2:
                    updateSupplier();
                    break;
                case 3:
                    deleteSupplier();
                    break;
                case 4:
                    viewSupplier();
                    break;
                case 5:
                    searchSupplier();
                    break;
                case 6:
                    homePage();
                    break;
                default:
                    System.out.println("Invalid Option. Please Try again");
            }
        }
    }

    public static void addingSuppliers() {
        clearConsole();
        System.out.println("+---------------------------------------------------------------+");
		System.out.println("|\t\t\tADD SUPPLIER\t\t\t\t|");
		System.out.println("+---------------------------------------------------------------+");
		System.out.println();
        while (true) {
            System.out.print("Supplier ID : ");
            String id = input.next();
            boolean flag = false;
            for (int i = 0; i < suppliers.length; i++) {
                if (id.equals(suppliers[i].id)) {
                    System.out.println("already exists. try another supplier id! ");
                    System.out.println();
                    flag = true;
                    break;
                }
            }
            if (!flag) {
				grow();
                suppliers[suppliers.length - 1]= new Supplier();
                suppliers[suppliers.length - 1].id = id;
                System.out.print("Supplier name   :  ");
                suppliers[suppliers.length - 1].name = input.next();
                while(true) {
                    System.out.print("added Successfully! Do you want to add another Supplier(Y/N)? ");
                    char option = input.next().charAt(0);
                    if (option == 'Y' || option == 'y') {
                        break;
                    }else if (option =='N' || option=='n'){
                        supplierManage();
                    }else {
                        System.out.println("Wrong Character");
                    }
                }
            }
        }
    }
    public static void grow() {
        Supplier[] temp = new Supplier[suppliers.length + 1];
        for (int i = 0; i < suppliers.length; i++) {
                temp[i] = suppliers[i];

        }
        suppliers = temp;
    }
    public static void updateSupplier() {
        clearConsole();
		System.out.println("+---------------------------------------------------------------+");
		System.out.println("|\t\t\tUPDATE SUPPLIER\t\t\t\t|");
		System.out.println("+---------------------------------------------------------------+");
		System.out.println();
        while (true) {
            System.out.print("Supplier ID : ");
            String id = input.next();
            int index = -1;
            for (int i = 0; i < suppliers.length; i++) {
                if (suppliers[i].id.equals(id)) {
                    index = i;
                    break;
                }
            }
            if (index != -1) {
                System.out.println("Supplier name : "+suppliers[index].name);
                System.out.println();
                System.out.print("Enter the new Supplier name : ");
                suppliers[index].name = input.next();
                System.out.print("Updated Successfully! ");
                System.out.print("Do you want to Update another Supplier(Y/N)?");
                char option = input.next().charAt(0);
                if (option =='N' || option=='n'){
                    supplierManage();
                    break;
                }
            } else {
                System.out.println("Can't find supplier id.try again!");
                System.out.println();
            }
        }
    }
    public static void deleteSupplier() {
        clearConsole();
        System.out.println("+---------------------------------------------------------------+");
		System.out.println("|\t\t\tDELETE SUPPLIER\t\t\t\t|");
		System.out.println("+---------------------------------------------------------------+");
		System.out.println();
        while (true) {
            System.out.print("Supplier ID : ");
            String id = input.next();
            int index = -1;
            for (int i = 0; i < suppliers.length; i++) {
                if (suppliers[i].id.equals(id)) {
                    index = i;
                    break;
                }
            }
            if (index != -1) {
                suppliers[index].id = "null";
                removeSupplier();
                System.out.print("Deleted Successfully!");
                while (true) {
                    System.out.print("Do you want to Delete another Supplier(Y/N)?");
                    char option = input.next().charAt(0);
                    if (option == 'N' || option == 'n') {
						supplierManage();
                        break;
                    } else if (option == 'Y' || option == 'y')
                        deleteSupplier();
                     else 
                        System.out.println("wrong character.try again!");
                    
                }
            }
            else{
                System.out.println("can't find supplier id");
            }
        }
    }
    public static void viewSupplier() {
        clearConsole();
        System.out.println("+---------------------------------------------------------------+");
		System.out.println("|\t\t\tVIEW SUPPLIER\t\t\t\t|");
		System.out.println("+---------------------------------------------------------------+");
		System.out.println();
		System.out.println("+-----------------------------------------------+");
		System.out.println("|\tSUPPLIER ID\t|\tSUPPLIER NAME\t|");
		System.out.println("+-----------------------------------------------+");
        for (int i = 0; i < suppliers.length; i++) {
            System.out.printf("|\t"+suppliers[i].id+"\t\t|\t"+suppliers[i].name+"\t\t|");
        }
        System.out.println();
        System.out.println("+-----------------------------------------------+");
        while (true) {
            System.out.print("Do you want to go Supplier manage page(Y/N)?");
            char option = input.next().charAt(0);
            if (option == 'Y' || option == 'y') {
                supplierManage();
                break;
            } else if (option == 'N' || option == 'n') {
                System.exit(0);
            } else {
                System.out.println("Can't find supplier id.try again!");
            }
        }
    }
    public static void searchSupplier() {
        clearConsole();
        System.out.println("+---------------------------------------------------------------+");
		System.out.println("|\t\t\tSEARCH SUPPLIER\t\t\t\t|");
		System.out.println("+---------------------------------------------------------------+");
		System.out.println();
        while (true) {
            System.out.print("Supplier ID   : ");
            String id = input.next();
            int index = -1;

            for (int i = 0; i < suppliers.length; i++) {
                if (suppliers[i].id.equals(id)) {
                    index = i;
                    break;
                }
            }
            if (index != -1) {
                System.out.println("Supplier name : "+suppliers[index].name);

                while (true) {
                    System.out.print("Search Successfully! Do you want to search another supplier(Y/N)?");
                    char option = input.next().charAt(0);
                    if (option == 'Y' || option == 'y') {
                        break;
                    } else if (option == 'N' || option == 'n') {
                        supplierManage();
                        break;
                    }
                }
            }else {
                System.out.println("Can't find supplier id.try again!");
            }
        }
    }
    public static void stockManage(){
        clearConsole();
        System.out.println("+---------------------------------------------------------------+");
		System.out.println("|\t\t\tSTOCK MANAGEMENT\t\t\t|");
		System.out.println("+---------------------------------------------------------------+");
		System.out.println();
		System.out.println("[1] Manage Item Categories                           [2] Add Item");
        System.out.println("[3] Get Items Supplier Wise                          [4] View Items");
        System.out.println("[5] Rank Items Per Unit Price                        [6] Home Page");
        System.out.println();
        System.out.print("Enter an option to continue > ");
        int options = input.nextInt();
        switch (options) {
            case 1:
                manageItems();
                break;
            case 2:
                addItem();
                break;
            case 3:
                getItemsupplierWise();
                break;
            case 4:
                viewItems();
                break;
            case 5:
                rankItemsPerUnitPrice();
                break;
            case 6:
                homePage();
                break;
            default:
                System.out.println("Invalid Option. Please Try again");
        }
    }
    public static void manageItems() {
        clearConsole();
        System.out.println("+---------------------------------------------------------------+");
		System.out.println("|\t\t\t MANAGE ITEM CATEGORY\t\t\t|");
		System.out.println("+---------------------------------------------------------------+");
		System.out.println();
        System.out.println("[1] Add New Item Category                [2] Delete Item Category");
        System.out.println("[3] Update Item Category                 [4] Stock Management");
        System.out.println();
        System.out.print("Enter an option to continue > ");
        int options = input.nextInt();
        switch (options) {
            case 1:
                addItemCategory();
                break;
            case 2:
                deleteItemCategory();
                break;
            case 3:
                updateItemsCategory();
                break;
            case 4:
                stockManage();
                break;
            default:
                System.out.println("Invalid Option. Please Try again");
        }
    }
    public static void addItemCategory() {
        clearConsole();
        System.out.println("+---------------------------------------------------------------+");
		System.out.println("|\t\t\tADD NEW ITEM CATEGORY\t\t\t|");
		System.out.println("+---------------------------------------------------------------+");
		System.out.println();
        while (true){
            System.out.print("Enter the new item category: ");
            String item = input.next();
            boolean flag = false;
            for (int i = 0; i < category.length; i++) {
                if(item.equals(category[i].name)){
                    System.out.println("already exists. try another item category! ");
                    flag = true;
                    break;
                }
            }
            if (!flag){
                growcategory();
                category[category.length-1] = new Category();
                category[category.length-1].name = item;
                while (true) {
                    System.out.print("added Successfully! Do you want to add another item category(Y/N)?");
                    char option = input.next().charAt(0);
                    if (option == 'Y' || option == 'y') {
                        break;
                    } else if (option == 'N' || option == 'n') {
                        manageItems();
                        break;
                    } else {
                        System.out.println("Can't find supplier id.try again!");

					}
                }
            }
        }
    }
    public static void deleteItemCategory() {
        clearConsole();
        System.out.println("+---------------------------------------------------------------+");
		System.out.println("|\t\t\tDELETE ITEM CATEGORY\t\t\t|");
		System.out.println("+---------------------------------------------------------------+");
		System.out.println();	
        while(true){
            System.out.print("Enter category to Delete : ");
            String categoryId = input.next();
            int index = -1;

            for (int i = 0; i < category.length; i++) {
                if (category[i].equals(categoryId)) {
                    index = i;
                    break;
                }
            }
            if (index != -1) {
                category[index].name="null";
                removeCategory();
                System.out.print("Deleted Successfully!");
                while(true) {
                    System.out.println("Do you want to Delete another Category(Y/N)?");
                    char option = input.next().charAt(0);
                    if (option == 'Y' || option == 'y') {
                        break;
                    }else if (option =='N' || option=='n'){
                        manageItems();
                    }else {
                        System.out.println("Wrong Character");
                    }
                }
            } else{
                System.out.println("can't find category");
            }
        }
    }
    public static void updateItemsCategory() {
        clearConsole();
        System.out.println("+---------------------------------------------------------------+");
		System.out.println("|\t\t\tUPDATE ITEM CATEGORY\t\t\t|");
		System.out.println("+---------------------------------------------------------------+");
		System.out.println();
        while(true) {
            System.out.print("Enter category to Update : ");
            String Item = input.next();
            int index = -1;
            for (int i = 0; i < category.length; i++) {
                if (category[i].equals(Item)) {
                    index = i;
                    break;
                }
            }
            if (index != -1) {
                System.out.print("Updated New Item name :");
                String name = input.next();
                category[index].name = name;
                System.out.print("Updated Successfully!");
                while(true) {
                    System.out.print("Do you want to Update another Category(Y/N)?");
                    char option = input.next().charAt(0);
                    if (option == 'Y' || option == 'y') {
                        break;
                    }else if (option =='N' || option=='n'){
                        manageItems();
                    }else {
                        System.out.println("Wrong Character");
                    }
                }
            } else {
                System.out.println("Can't find category.try again!");
            }
        }
    }
    public static void addItem() {
        clearConsole();
        System.out.println("+---------------------------------------------------------------+");
		System.out.println("|\t\t\tADD ITEM \t\t\t\t|");
		System.out.println("+---------------------------------------------------------------+");
		System.out.println();
        if(category.length==0) {
            System.out.print("OOPS! It seems that you don't have any item categories in the System.");
				while(true) {
                System.out.print("Do you want to add a new item category?(Y/N)");
                char option = input.next().charAt(0);
                if (option == 'Y' || option == 'y') {
                    addItemCategory();
                }else
                    stockManage();
            }
        }
        if(suppliers.length==0) {
            System.out.print("OOPS! It seems that you don't have any suppliers in the System.");
            while(true) {
                System.out.print("Do you want to add a new Supplier?(Y/N)");
                char option = input.next().charAt(0);
                if (option == 'Y' || option == 'y') {
                    addingSuppliers();
                    //return;
                }else if (option =='N' || option=='n'){
                    stockManage();
                }else {
                    System.out.println("Wrong Character");
                }
            }
        }
        while (true) {
            boolean flag = false;
            System.out.print("Item Code   : " );
            String code = input.next();
            for (int i = 0; i < items.length; i++) {
                if(items[i].id.equals(code)){
                    flag = true;
                    System.out.println(" Item is already Exists" );
                    break;
                }
            }
            if(!flag){
                growItem();
                items[items.length-1] = new Item();
                items[items.length-1].id = code;
                System.out.println( );
                System.out.println("Supplier list:");
				System.out.println("+---------------------------------------------------------------+");
				System.out.println("|\t#\t|\tSUPPLIER ID\t|\tSUPPLIER NAME\t|");
				System.out.println("+---------------------------------------------------------------+");
                for (int i = 0; i < suppliers.length; i++) {
                    System.out.printf("|%8S       |%15S       |%16S       |%n",(i+1),suppliers[i].id,suppliers[i].name);
                }
                System.out.println("+---------------+----------------------+-----------------------+");
                System.out.print("Enter the Supplier Number > ");
                int index = input.nextInt();
                items[items.length-1].supId = suppliers[index-1].id;

                System.out.println("Item categories:");
				System.out.println("+---------------------------------------+");
				System.out.println("|\t#\t|\tCATEGORY NAME\t|");
				System.out.println("+---------------------------------------+");
                for (int i = 0; i < category.length; i++) {
                    System.out.printf("|%8S       |%18S         |%n",(i+1),category[i].name);
                }System.out.println("+---------------+---------------------------+");
                System.out.print("Enter the Category Number > ");
                index = input.nextInt();
                items[items.length-1].category = category[index-1].name;

                System.out.print("Description : ");
                items[items.length-1].desc = input.next();

                System.out.print("Unit Price : ");
                items[items.length-1].price = input.nextDouble();

                System.out.print("QTY on Hand : ");
                items[items.length-1].qtyOnHand = input.nextInt();
                while(true) {
                    System.out.print("added Successfully! Do you want to add another item(Y/N)?");
					char option = input.next().charAt(0);
                    if (option == 'Y' || option == 'y') {
                        break;
                    }else if (option =='N' || option=='n'){
                        stockManage();
                        break;
                    }else {
                        System.out.println("Wrong Character");
                    }
                }
            }
        }
    }
    public static void growItem() {
       Item[] temp = new Item[items.length + 1];
        for (int i = 0; i < items.length; i++) {
                temp[i] = items[i];
        }
        items = temp;
    }
    public static void growcategory() {
        Category[] temp = new Category[category.length + 1];
        for (int i = 0; i < category.length; i++) {
            temp[i] = category[i];
        }
        category = temp;
    }
    public static void getItemsupplierWise() {
        clearConsole();
        System.out.println("+---------------------------------------------------------------+");
		System.out.println("|\t\t\tSUPPLIER WISE ITEMS\t\t\t|");
		System.out.println("+---------------------------------------------------------------+");
		System.out.println();
        while (true) {
            System.out.print("Enter Supplier Id: ");
            String ID = input.next();
            int index = -1;

            for (int i = 0; i < suppliers.length; i++) {
                if (suppliers[i].id.equals(ID)) {
                    index = i;
                    break;
                }
            }
            if (index != -1) {
                System.out.println("Supplier Name :"+suppliers[index].name);
                System.out.println("+---------------------------------------------------------------+");
				System.out.printf("| %-8s | %-8s | %-8s | %-8s | %-8s |%n", "ITEM CODE", "DESCRIPTION", "UNIT PRICE", "QTY ON HAND", "CATEGORY");
				System.out.println("+---------------------------------------------------------------+");
                for (int i = 0; i < items.length; i++) {
                    if (ID.equals(items[i].supId)) {
                        System.out.printf("| %-8s | %-8s | %-10s | %-10s | %-12s |%n",items[i].id,items[i].desc,items[i].price,items[i].qtyOnHand,items[i].category);
                    }
                }
                System.out.println("+---------------------------------------------------------------+");
            } else {
                System.out.println("Supplier ID not found.");
            }
            while (true) {
                System.out.print("Search Successfully! Do you want to another search(Y/N)?");
                char option = input.next().charAt(0);
                if (option == 'Y' || option == 'y') {
                    break;
                } else if (option == 'N' || option == 'n') {
                    stockManage();
                } else {
                    System.out.println("Wrong Character");
                }
            }
        }
    }
    public static void viewItems() {
         clearConsole();
       System.out.println("+---------------------------------------------------------------+");
		System.out.println("|\t\t\tVIEW ITEMS\t\t\t\t|");
		System.out.println("+---------------------------------------------------------------+");
		System.out.println();
		for (int i = 0; i < category.length; i++) {
            System.out.println(category[i].name);
            System.out.println("+------------------------------------------------------+");
			System.out.printf("| %-8s | %-8s | %-8s | %-8s | %-8s |%n", "SID", "CODE", "DESC", "PRICE", "QTY");
			System.out.println("+------------------------------------------------------+");
            for (int j = 0; j < items.length; j++) {
                if (category[i].name.equals(items[j].category)) {
					System.out.printf("|%-8S | %-8S | %-8S | %-8S | %-8S |%n",items[j].supId,items[j].id, items[j].desc,items[j].price,items[j].qtyOnHand);                }
            }
            System.out.println("+---------------------------------------------------------------+");
        }
        while (true) {
            System.out.print("Do you want to go stock manage page(Y/N)?");
            char option = input.next().charAt(0);
            if (option == 'Y' || option == 'y') {
                stockManage();
            } else if (option == 'N' || option == 'n') {
                System.exit(0);
            } else {
                System.out.println("Wrong Character");
            }
        }
    }
    public static void rankItemsPerUnitPrice() {
        clearConsole();
        System.out.println("+---------------------------------------------------------------+");
		System.out.println("|\t\t\tRANKED UNIT PRICE\t\t\t|");
		System.out.println("+---------------------------------------------------------------+");
		System.out.println();
        double[] temp=new double[items.length];
        for (int i = 0; i < items.length; i++) {
            temp[i]=items[i].price;
        }
        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < temp.length-1; j++) {
                if (temp[j]>temp[j+1]){
                    double x=temp[j];
                    temp[j]=temp[j+1];
                    temp[j+1]=x;
                }
            }
        }
        System.out.println("+-----------------------------------------------------------------+");
		System.out.printf("| %-8s | %-8s | %-8s | %-8s | %-8s | %-8s |%n", "SID", "CODE", "DESC", "PRICE", "QTY", "CAT");
		System.out.println("+-----------------------------------------------------------------+");
        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < items.length; j++) {
                if (temp[i]==items[j].price){
                    System.out.printf("| %-8s | %-8s | %-8s | %-8s | %-8s | %-8s |%n",items[j].supId,items[j].id,items[j].desc,items[j].price,items[j].qtyOnHand,items[j].category);
                }
            }
        }
        System.out.println("+---------------------+-------------------------+----------------------------+------------------------------+------------------------------+---------------------------+");
        while (true) {
            System.out.print("Do you want to go stock manage page(Y/N)?");
            char option = input.next().charAt(0);
			if (option == 'Y' || option == 'y') {
                break;
            } else if (option == 'N' || option == 'n') {
                stockManage();
            } else {
                System.out.println("Wrong Character");
            }
        }
    }
    public static void removeSupplier(){
        Supplier [] temp = new Supplier[suppliers.length-1];
        for (int i = 0,k = 0; i < temp.length; i++) {
            if(suppliers[i].id.equals("null")){
                k++;
            }

                temp[i] = suppliers[i+k];

        }
        suppliers=temp;
    }
    public static void removeCategory(){
        Category [] temp = new Category[category.length-1];
        for (int i = 0,k = 0; i < temp.length; i++) {
            if(category[i].name.equals("null")){
                k++;
            }
            temp[i] = category[i+k];
        }
        category=temp;
    }
    private final static void clearConsole() {
        final String os = System.getProperty("os.name");
        try {
            if (os.equals("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (final Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
