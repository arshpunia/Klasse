/**
 * 
 * @author Arsh Punia
 * <p>
 * A class that predicts your exam mark based on your historical performance in a course in relation
 * to the class average before and after the exam.
 * </p>
 * 
 */
public class MarkPredictor {
	/**
	 * The class average before the exam
	 */
	public  double classPrevious;
	/**
	 * Your average before the exam
	 */
	public  double yourPrevious;
	/**
	 * The class average on the exam 
	 */
	public  double classAfter;
	
	public MarkPredictor(double classPrevious,double yourPrevious, double classAfter)
	{
		if(classPrevious<0 || classPrevious>100)
		{
			throw new IllegalArgumentException();
		}
		if(yourPrevious<0 || yourPrevious>100)
		{
		throw new IllegalArgumentException();	
		}
		if(classAfter<0 || classAfter>100)
		{
			throw new IllegalArgumentException();
		}
		else
		{
		this.classPrevious = classPrevious;
		this.yourPrevious = yourPrevious;
		this.classAfter = classAfter;
		}
	}
	/**
	 * <p>
	 * Calculates your final exam mark assuming performance consistent with historical precedent.
	 * The method first calculates the ratio of your average with that of the class average, which 
	 * it then multiplies with the class average on the exam.
	 * </p>
	 * <p>
	 * 
	 * </p>
	 * @return Your final exam mark
	 * 
	 */
	
	public double examMark()
	{
		double difference = this.yourPrevious-this.classPrevious;
		double relativePerformance = difference/this.classPrevious;
		return ((1+relativePerformance)*this.classAfter);
	}
	/**
	 * Returns your final mark in the course. The computation is based on the weight of the final exam,
	 * your predicted mark from <code> examMark() </code> and your average before the exam.
	 * @param weightage: The weight of the final exam
	 * @return The final mark in the course
	 */
	public double finalMark(double weightage)
	{
		if(weightage<0 || weightage>100)
		{
			throw new IllegalArgumentException();
		}
		return(((weightage/100)*this.examMark())+((1-(weightage/100))*this.yourPrevious));
	}
	
	/**
	 * Returns your letter grade in the course depending upon your final mark in that course
	 * @param mark: Your final mark in the course
	 * @return Your final letter grade in a particular course
	 */
	public String finalGrade(double mark)
	{
		if(mark>=90 && mark<=100)
		{
			return "A+";
		}
		else if(mark>=80&&mark<90)
		{
			return "A";
		}
		else if(mark>=75 && mark<80)
		{
			return "B+";
		}
		else if(mark>=70&&mark<75)
		{
			return "B";
		}
		else if(mark>=65&&mark<70)
		{
			return "C+";
		}
		else if(mark>=60&&mark<65)
		{
			return "C";
		}
		else if(mark>=55&&mark<60)
		{
			return "D+";
		}
		else if(mark>=50&&mark<55)
		{
			return "D";
		}
		else if(mark>=40&&mark<50)
		{
			return "E";
		}
		return "F";
	}
	
}