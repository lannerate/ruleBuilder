import com.flagleader.util.StringUtil;
import com.flagleader.util.filesystem.FileUtil;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class CreateMyIni
{
  public static void main(String[] paramArrayOfString)
  {
    String str1 = "";
    for (int i = 0; i < paramArrayOfString.length; i++)
    {
      str1 = str1 + paramArrayOfString[i];
      if (i == paramArrayOfString.length - 1)
        continue;
      str1 = str1 + " ";
    }
    if (str1.length() == 0)
      str1 = FileUtil.getCurrentDir() + File.separator + "mysql";
    str1 = str1.replace(File.separatorChar, '/');
    File localFile1 = new File(str1, "myt.ini");
    String str2 = null;
    try
    {
      if (localFile1.exists())
      {
        String str3 = FileUtil.readFromFile(localFile1);
        str2 = StringUtil.replace("{mysqlpath}", str1, str3);
      }
    }
    catch (IOException localIOException1)
    {
      localIOException1.printStackTrace();
    }
    if (str2 == null)
      str2 = "[mysqld]\nbasedir=" + str1 + "/\ndatadir=" + str1 + "/data/\ndefault-character-set=gbk\n";
    Object localObject;
    try
    {
      File localFile2 = new File(str1, "my.ini");
      if (!localFile2.exists())
        localFile2.createNewFile();
      localObject = new FileOutputStream(localFile2, false);
      ((FileOutputStream)localObject).write(str2.getBytes());
      ((FileOutputStream)localObject).close();
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      localFileNotFoundException.printStackTrace();
    }
    catch (IOException localIOException2)
    {
      localIOException2.printStackTrace();
    }
    try
    {
      File localFile3 = new File(FileUtil.getCurrentDir(), "REGISTER.REG");
      if (localFile3.exists())
      {
        localObject = FileUtil.readFromFile(localFile3);
        str2 = StringUtil.replace("c:\\VisualRules", FileUtil.getCurrentDir(), (String)localObject);
        FileOutputStream localFileOutputStream = new FileOutputStream(localFile3, false);
        localFileOutputStream.write(str2.getBytes());
        localFileOutputStream.close();
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     CreateMyIni
 * JD-Core Version:    0.6.0
 */