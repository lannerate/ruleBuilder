package com.flagleader.repository.d;

import com.flagleader.engine.Property;
import com.flagleader.repository.e.e;
import com.flagleader.repository.e.q;
import com.flagleader.repository.tree.Rule;
import com.flagleader.repository.tree.RuleHistory;
import com.flagleader.util.filesystem.FileUtil;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class x
{
  private String a = "";
  private static x b = null;

  public static x a()
  {
    if (b == null)
      b = new x();
    return b;
  }

  public String b()
  {
    return this.a;
  }

  public void a(String paramString)
  {
    this.a = paramString;
  }

  public void a(Rule paramRule)
  {
    try
    {
      File localFile = new File(this.a, paramRule.getUuid().substring(4) + ".his");
      StringBuffer localStringBuffer = null;
      if (!localFile.exists())
      {
        localFile.createNewFile();
        localStringBuffer = new StringBuffer();
        localStringBuffer.append("<?xml version=\"1.0\" encoding=\"" + System.getProperty("file.encoding") + "\"?>");
        localStringBuffer.append("<rulehistory>\n");
        localStringBuffer.append("</rulehistory>\n");
      }
      else
      {
        byte[] arrayOfByte = new byte[new Long(localFile.length() + 1L).intValue()];
        int j = 0;
        FileInputStream localFileInputStream = new FileInputStream(localFile.getPath());
        j = localFileInputStream.read(arrayOfByte, 0, new Long(localFile.length() + 1L).intValue());
        localStringBuffer = new StringBuffer(new String(arrayOfByte));
        localFileInputStream.close();
      }
      int i = localStringBuffer.indexOf("</rulehistory>");
      localStringBuffer.insert(i, e.a(paramRule));
      FileUtil.saveToFile(localFile.getPath(), localStringBuffer.toString(), Property.getInstance().getFileEncoding());
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      localFileNotFoundException.printStackTrace();
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }

  public RuleHistory b(Rule paramRule)
  {
    File localFile = new File(this.a, paramRule.getUuid().substring(5) + ".his");
    if ((!localFile.exists()) || (localFile.length() == 0L))
      return null;
    return (RuleHistory)new q().load(localFile);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.d.x
 * JD-Core Version:    0.6.0
 */