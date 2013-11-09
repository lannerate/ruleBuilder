import com.flagleader.builder.shell.aQ;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import org.apache.commons.lang.SystemUtils;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class RspBuilder
{
  public static void main(String[] paramArrayOfString)
  {
    Display localDisplay = new Display();
    try
    {
      File localFile = new File(SystemUtils.USER_HOME + File.separator + ".visualrules", "rsperror.txt");
      if (!localFile.exists())
        localFile.createNewFile();
      System.setErr(new PrintStream(new FileOutputStream(localFile)));
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
    }
    catch (IOException localIOException)
    {
    }
    aQ localaQ = new aQ();
    Shell localShell = localaQ.b(localDisplay);
    String str = "";
    for (int i = 0; i < paramArrayOfString.length; i++)
      str = str + paramArrayOfString[i] + " ";
    if (new File(str).exists())
      localaQ.b(str);
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
 * Qualified Name:     RspBuilder
 * JD-Core Version:    0.6.0
 */