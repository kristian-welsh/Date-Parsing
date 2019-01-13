package date.parsing;

public class Date {
	public Integer day;
	public Integer month;
	public Integer year;

	public Date(int day, int month, int year) {
		this.day = day;
		this.month = month;
		this.year = year;
	}
	
	@Override
	public String toString() {
		return "date: " + day.toString() + ", " + month.toString() + ", " + year.toString() + ";";
	}
	
	public String sortString() {
		return year.toString() + month.toString() + day.toString();
	}
}
