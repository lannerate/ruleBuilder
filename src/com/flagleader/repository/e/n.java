package com.flagleader.repository.e;

import com.flagleader.util.StringUtil;
import com.flagleader.util.filesystem.FileUtil;
import java.io.IOException;
import java.io.PrintWriter;

public class n extends o
{
  private static String d = "";

  static
  {
    try
    {
      d = FileUtil.readFromStream(o.class.getClassLoader().getResourceAsStream("vmlHtmlHeader.html"));
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
    }
  }

  public n()
  {
  }

  public n(PrintWriter paramPrintWriter)
  {
    super(paramPrintWriter);
  }

  public n(PrintWriter paramPrintWriter, boolean paramBoolean)
  {
    super(paramPrintWriter, paramBoolean);
  }

  protected void a(String paramString)
  {
    d(StringUtil.replace("<TITLE></TITLE>", "<TITLE>" + paramString + "</TITLE>", d));
  }

  protected boolean a()
  {
    return false;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.e.n
 * JD-Core Version:    0.6.0
 */