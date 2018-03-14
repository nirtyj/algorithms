package careercup.facebook;

/**
Can you achieve the following without using enums? Given the last two lines stay the same.
enum DayHalf
{
AM,PM;
DayHalf dh1=DayHalf.AM;
DayHalf dh2=DayHalf.PM;
}
*/
public class ReplicateEnum {
	public static class DayHalf {
		
		private String val;
		
		public static DayHalf AM = new DayHalf("AM");
		public static DayHalf PM = new DayHalf("PM");

		public DayHalf(String val) {
			super();
			this.val = val;
		}

		public static void main(String[] args) {
			DayHalf dh1 = DayHalf.AM;
			DayHalf dh2 = DayHalf.PM;
		}
	}
}
