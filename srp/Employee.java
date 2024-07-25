package net.media.training.live.srp;


public class Employee {
    private int empId;
    private static int TOTAL_LEAVES_ALLOWED = 30;

    private String name;
    private double monthlySalary;
    private String addressStreet;
    private String addressCity;
    private String addressCountry;
    private int leavesTaken;
    private int totalLeaveAllowed;
    private int leaveTaken;
    private String manager;
    private int yearsInOrg;
    private int thisYeard;

    private int[] leavesLeftPreviously;

    public Employee(int empId, double monthlySalary, String name, String addressStreet, String addressCity, String addressCountry, int leavesTaken, int[] leavesLeftPreviously) {
        this.empId = empId;
        this.monthlySalary = monthlySalary;
        this.name = name;
        this.addressStreet = addressStreet;
        this.addressCity = addressCity;
        this.addressCountry = addressCountry;
        this.leavesTaken = leavesTaken;
        this.leavesLeftPreviously = leavesLeftPreviously;
        this.yearsInOrg = leavesLeftPreviously.length;
    }

    public Employee(){

    }

    public int getEmpId() {
        return this.empId;
    }

    public static int getTotalLeavesAllowed() {
        return TOTAL_LEAVES_ALLOWED;
    }

    public String getName() {
        return this.name;
    }

    public double getMonthlySalary() {
        return this.monthlySalary;
    }

    public String getAddressStreet() {
        return this.addressStreet;
    }

    public String getAddressCity() {
        return this.addressCity;
    }

    public String getAddressCountry() {
        return this.addressCountry;
    }

    public int getLeavesTaken() {
        return this.leavesTaken;
    }

    public int getTotalLeaveAllowed() {
        return this.totalLeaveAllowed;
    }

    public int getLeaveTaken() {
        return this.leaveTaken;
    }

    public String getManager() {
        return this.manager;
    }

    public int getYearsInOrg() {
        return this.yearsInOrg;
    }

    public int getThisYeard() {
        return this.thisYeard;
    }

    public int[] getLeavesLeftPreviously() {
        return this.leavesLeftPreviously;
    }

    public String convertToHtml(){
        EmployeeFormat object = new EmployeeFormat(this);
        return object.toHtml();
    }
}
class EmployeeFormat extends Employee{
    Employee employee;
    public EmployeeFormat(Employee employee){
        this.employee = employee;
    }
    public String toHtml() {
        String str = "<div>" +
                "<h1>Employee Info</h1>" +
                "<div id='emp" + this.employee.getEmpId() + "'>" +
                "<span>" + this.employee.getName() + "</span>" +
                "<div class='left'>" +
                "<span>Leave Left :</span>" +
                "<span>Annual Salary:</span>" +
                "<span>Manager:</span>" +
                "<span>Reimbursable Leave:</span>" +
                "</div>";
        str += "<div class='right'><span>" + (this.employee.getTotalLeaveAllowed() - this.employee.getLeaveTaken()) + "</span>";
        str += "<span>" + Math.round(this.employee.getMonthlySalary() * 12) + "</span>";
        if (this.employee.getManager() != null) str += "<span>" + this.employee.getManager() + "</span>";
        else str += "<span>None</span>";
        int years = 3;
        if (this.employee.getYearsInOrg() < 3) {
            years = this.employee.getYearsInOrg();
        }
        int totalLeaveLeftPreviously = 0;
        for (int i = 0; i < years; i++) {
            totalLeaveLeftPreviously += this.employee.getLeavesLeftPreviously()[this.employee.getYearsInOrg()-i-1];
        }
        str += "<span>" + totalLeaveLeftPreviously + "</span>";
        return str + "</div> </div>";
    }
}
