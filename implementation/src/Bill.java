public class Bill {
    private String billName;
    public Bill(){

    }
    public Double pay(){
        /// some logic here
        return 1000.0;
    }
    public String getBillName(){
        return billName;
    }
    public void setBillName(String billName){
        this.billName = billName;
    }
    public void displayBillMenu(){
        System.out.println("which bill you want to pay?");
        System.out.println("1- Electricity");
        System.out.println("2- Water");
        System.out.println("3- Gas");
    }
}


