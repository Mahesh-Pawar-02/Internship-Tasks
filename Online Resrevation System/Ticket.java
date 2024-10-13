// Ticket.java
public class Ticket {
    String pnr;
    String trainNumber;
    String trainName;
    String from;
    String to;

    public Ticket(String pnr, String trainNumber, String trainName, String from, String to) {
        this.pnr = pnr;
        this.trainNumber = trainNumber;
        this.trainName = trainName;
        this.from = from;
        this.to = to;
    }

    @Override
    public String toString() {
        return "PNR: " + pnr + ", Train: " + trainNumber + " - " + trainName + ", From: " + from + ", To: " + to;
    }
}
