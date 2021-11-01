import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
public class Invoice {
    private int invoiceID;
    private int orderID;
    private Order order;
    private LocalDate date;   // LocalDateTime data type yyyy-MM-dd-HH-mm-ss-ns
    private LocalTime time;
    private double subtotal;
    private double serviceCharge;
    private double GST;
    private double total;
    private boolean isMember;
    private double afterDiscount;

    public Invoice(int id, int OrderId, Order order, double subtotal, double afterDiscount, double serviceCharge, double GST, double total){
        invoiceID = id;
        orderID = OrderId;
        this.order = order;
        this.subtotal = subtotal;
        this.serviceCharge = serviceCharge;
        this.GST = GST;
        this.total = total;
        date = LocalDate.now();
        time = LocalTime.now();
        this.afterDiscount = afterDiscount;
    }
    public String toString(){
        return(
                "\t\t\tOODP RESTAUTRANT\t\t\t"+
              "\n\tINVOICE #: "  + invoiceID + " \t\t\t"+
              "\n\tServer: " +order.getStaff() + "\t\tTable: " + order.getTableId() +
              "\n\tDate Time: " + date+time+
              "\n\tClient: " + order.getNumber()+
              "\n--------------------------------------------------------------" +
              order.toString()+
              "\n--------------------------------------------------------------" +
              "\n\t\t\t\t\t\t\t\t\t\tSubTotal:  " + subtotal+
              "\n\t\t\t\t\t\t\t\t\tafter discount :   " + afterDiscount+
              "\n\t\t\t\t\t\t\t\t\t\tGST:        " + GST+
              "\n\t\t\t\t\t\t\t\t\t10% SERVICE CHARGE " + serviceCharge+
              "\n--------------------------------------------------------------" +
              "\n\t\t\t\t\t\t\t\t\t\tTOTAL: " + total +
              "\n\n=============================================================="  +
              "\n\t\t Thank you for dining with us! "
                );
    }






}
