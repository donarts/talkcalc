package arts.g.d.talkcalc;

import java.io.ByteArrayInputStream;

import arts.g.d.talkcalc.jj.calculator;

/**
 * Created by 2nd_user on 2015-09-13.
 */
public class Control {
    calculator calc;
    public Control()
    {

    }

    public void init(CustomAdapter listAdapter)
    {

    }

    public void calcAll(CustomAdapter listAdapter,String input)
    {
        String newline = input+"\n";
        calc = new calculator(new ByteArrayInputStream(newline.getBytes()));
        String output = calc.calc(new ByteArrayInputStream(newline.getBytes()));
        listAdapter.add(input, CustomAdapter.DP_RIGHT);
        listAdapter.add(output,CustomAdapter.DP_LEFT);
    }
}
