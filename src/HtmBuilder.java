import com.flagleader.builder.shell.bu;
import java.io.File;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class HtmBuilder
{
  public static void main(String[] paramArrayOfString)
  {
    Display localDisplay = new Display();
    bu localbu = new bu();
    Shell localShell = localbu.b(localDisplay);
    String str = "";
    for (int i = 0; i < paramArrayOfString.length; i++)
      str = str + paramArrayOfString[i] + " ";
    if (new File(str).exists())
      localbu.b(str);
    while (!localShell.isDisposed())
    {
      if (localDisplay.readAndDispatch())
        continue;
      localDisplay.sleep();
    }
    localDisplay.dispose();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     HtmBuilder
 * JD-Core Version:    0.6.0
 */