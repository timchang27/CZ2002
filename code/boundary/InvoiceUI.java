import java.util.Date;
import java.util.Scanner;
import java.time.LocalDate;
public class InvoiceUI {
    private InvoiceController invoiceController;
    public InvoiceUI(InvoiceController controller){
        invoiceController = controller;         // = getInstance()
    }

    public void run(){
        Scanner sc = new Scanner(System.in);

        System.out.println("--------Invoice and Report Printer--------");
        System.out.println("1. printInvoice"+
                "\n2. print daily revenue report"+
                "\n3. print monthly revenue report");

        int choice = sc.nextInt();
        switch(choice){
            case 1:
                printInvoice();
                break;
            case 2:
                printRevenueReportByDay();
                break;
            case 3:
                printRevenueReportByMonth();
                break;
            case 4:
                break;
        }
    }

    private void printInvoice(){
        Scanner sc = new Scanner(System.in);
        int orderId;
        System.out.print("enter order ID:");
        orderId = sc.nextInt();

        System.out.println("enter your phoneNumber yyyymmdd"); // use phone number or name?

        String number = sc.nextLine();
        invoiceController.printInvoice(orderId, number);

    }

    private void printRevenueReportByDay(){
        Scanner sc= new Scanner(System.in);
        System.out.println("enter the date: ()");
        String dateString = sc.nextLine();
        Date date = new Date()
    }
    private void printRevenueReportByMonth(){}
}
