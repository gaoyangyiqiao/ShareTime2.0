package turingmachine.com.sharetime20.weekview;

/**
 * Created by hello on 2015/5/30.
 */
import java.util.Calendar;

/**
 * Created by Raquib on 1/6/2015.
 */
public interface DateTimeInterpreter {
    String interpretDate(Calendar date);
    String interpretTime(int hour);
}
