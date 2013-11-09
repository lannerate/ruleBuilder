import com.flagleader.builder.FlagLeader;
import com.flagleader.util.NumberUtil;
import com.flagleader.util.filesystem.FileUtil;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import org.apache.commons.lang.SystemUtils;

public class RuleBuilder
{
  public static void main(String[] paramArrayOfString)
  {
    try
    {
      File localFile = new File(SystemUtils.USER_HOME + File.separator + ".visualrules", "systemerr.txt");
      if (!localFile.exists())
        localFile.createNewFile();
      else if (localFile.length() > 0L)
        try
        {
          FileUtil.copy(localFile, new File(SystemUtils.USER_HOME + File.separator + ".visualrules" + File.separator + "logs", "builder" + a() + ".txt"), true);
        }
        catch (Exception localException)
        {
        }
      System.setErr(new PrintStream(new FileOutputStream(localFile)));
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
    }
    catch (IOException localIOException)
    {
    }
    FlagLeader.main(paramArrayOfString);
  }

  private static int a()
  {
    File localFile = new File(SystemUtils.USER_HOME + File.separator + ".visualrules", "logs");
    int i = 0;
    if ((localFile.exists()) && (localFile.isDirectory()))
    {
      File[] arrayOfFile = localFile.listFiles();
      for (int j = 0; j < arrayOfFile.length; j++)
      {
        if ((!arrayOfFile[j].isFile()) || (!arrayOfFile[j].getName().startsWith("builder")) || (!arrayOfFile[j].getName().endsWith(".txt")))
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
 * Qualified Name:     RuleBuilder
 * JD-Core Version:    0.6.0
 */