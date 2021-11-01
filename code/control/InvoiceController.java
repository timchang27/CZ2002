import java.util.ArrayList;

public class InvoiceController {
    private ArrayList<Invoice> invoices;
    private MemberController memberController;
    private OrderController orderController;
    private final  double GST_RATE = 0.07;
    private final double SERVICE_RATE = 0.1;

    public InvoiceController(){
        invoices = new ArrayList<>(); // need to have file
        memberController = new MemberController();
    }

    public void printInvoice(int id, String number){
        Invoice invoice = addInvoice(id,number);
        invoice.toString();
    }

    private Invoice addInvoice(int id, String number){
        int invoiceId = invoices.size();       // USE arrayList size to get the invoice ID
        Order order = orderController.getOrderById(id);
        double subtotal = order.getOrderPrice();
        double total;
        double afterDiscount = subtotal;

        String name =  memberController.getMember(number).getName();
        if(memberController.checkMembership(number)){
            System.out.println(name+" (" + number +") is a member");
            afterDiscount = subtotal *  memberController.getDiscountRate(); //discount rate should belong to?
        }
        else System.out.println(name+" (" + number +") is not a member");

        double GST = subtotal * GST_RATE;
        double serviceCharge = subtotal * SERVICE_RATE;
        total = subtotal + GST + serviceCharge;

        Invoice invoice = new Invoice(invoiceId,id,order,subtotal, afterDiscount, serviceCharge,GST,total);
        invoices.add(invoice);
        return invoice;
    }

}
