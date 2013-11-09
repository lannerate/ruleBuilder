import com.flagleader.builder.shell.RuleExecuteViewer;
import com.flagleader.util.NumberUtil;
import com.flagleader.util.filesystem.FileUtil;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class RuleExecuter
{
  public static void main(String[] paramArrayOfString)
  {
    try
    {
      File localFile1 = new File(FileUtil.getCurrentDir() + File.separator + "logs", "executeerror.txt");
      if (!localFile1.exists())
      {
        localFile1.getParentFile().mkdirs();
        localFile1.createNewFile();
      }
      else if (localFile1.length() > 0L)
      {
        try
        {
          FileUtil.copy(localFile1, new File(FileUtil.getCurrentDir() + File.separator + "logs", "executer" + a("executer") + ".txt"), true);
        }
        catch (Exception localException1)
        {
        }
      }
      System.setErr(new PrintStream(new FileOutputStream(localFile1)));
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
    }
    catch (IOException localIOException)
    {
    }
    File localFile2 = new File("ruleengine.log");
    if (localFile2.exists())
    {
      if (localFile2.length() > 0L)
        try
        {
          FileUtil.copy(localFile2, new File(FileUtil.getCurrentDir() + File.separator + "logs", "enginelog" + a("enginelog") + ".txt"), true);
        }
        catch (Exception localException2)
        {
        }
      localFile2.delete();
    }
    RuleExecuteViewer.main(paramArrayOfString);
  }

  private static int a(String paramString)
  {
    File localFile = new File(FileUtil.getCurrentDir(), "logs");
    int i = 0;
    if ((localFile.exists()) && (localFile.isDirectory()))
    {
      File[] arrayOfFile = localFile.listFiles();
      for (int j = 0; j < arrayOfFile.length; j++)
      {
        if ((!arrayOfFile[j].isFile()) || (!arrayOfFile[j].getName().startsWith(paramString)) || (!arrayOfFile[j].getName().endsWith(".txt")))
          continue;
        String str = arrayOfFile[j].getName().substring(7, arrayOfFile[j].getName().length() - 4);
        if ((str == null) || (!NumberUtil.isParsedDouble(str)))
          continue;
        int k = NumberUtil.getInt(str);
        if (i >= k)
          continue;
        i = k;
      }
    }
    else
    {
      localFile.mkdirs();
    }
    return i + 1;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     RuleExecuter
 * JD-Core Version:    0.6.0
 */