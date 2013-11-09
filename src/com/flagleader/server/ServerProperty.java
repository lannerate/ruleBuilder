package com.flagleader.server;

import com.flagleader.engine.MessageUtil;
import com.flagleader.engine.RuleEngine;
import com.flagleader.util.StringUtil;
import com.flagleader.util.filesystem.FileUtil;
import com.flagleader.xml.XMLReceiveBean;
import java.io.File;
import java.io.FileOutputStream;
import java.net.URL;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ServerProperty
{
  private static ServerProperty a = new ServerProperty();
  private static final String b = "ruleserver.conf";
  private static boolean c = false;
  private String d = "";
  private int e = 1508;
  private int f = 1509;
  private int g = 0;
  private int h = 0;
  private int i = 0;
  private int j = 0;
  private int k = 0;
  private String l = "com.flagleader.pdf.ITextPdfFactory";
  private static Log m = LogFactory.getLog("ruleengine");

  private ServerProperty()
  {
    l();
  }

  public static ServerProperty a()
  {
    return a;
  }

  private void l()
  {
    Properties localProperties = null;
    try
    {
      localProperties = new Properties();
      if (getClass().getClassLoader().getResource("ruleserver.conf") != null)
      {
        localProperties.load(getClass().getClassLoader().getResourceAsStream("ruleserver.conf"));
        this.d = localProperties.getProperty("ruleServerAccept", this.d);
        this.g = Integer.parseInt(localProperties.getProperty("streamtype", "0"));
        this.e = Integer.parseInt(localProperties.getProperty("ruleServerPort", "1508"));
        this.f = Integer.parseInt(localProperties.getProperty("ruleThreadServerPort", "1509"));
        this.h = Integer.parseInt(localProperties.getProperty("receivelogtype", "0"));
        this.i = Integer.parseInt(localProperties.getProperty("executelogtype", "0"));
        this.j = Integer.parseInt(localProperties.getProperty("dbupdatetype", "0"));
        this.k = Integer.parseInt(localProperties.getProperty("tracelogtype", "0"));
        this.l = localProperties.getProperty("pdfImplement", this.l);
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    finally
    {
      c = true;
    }
  }

  public void b()
  {
    Properties localProperties = null;
    try
    {
      localProperties = new Properties();
      File localFile = null;
      if ((getClass().getClassLoader().getResource("ruleserver.conf") != null) && (new File(getClass().getClassLoader().getResource("ruleserver.conf").getFile()).exists()))
        localFile = new File(getClass().getClassLoader().getResource("ruleserver.conf").getFile());
      if (localFile == null)
        localFile = new File(FileUtil.getCurrentDir() + File.separator + "rules", "ruleserver.conf");
      if (!localFile.exists())
      {
        localFile.getParentFile().mkdirs();
        localFile.createNewFile();
      }
      localProperties.setProperty("ruleServerAccept", this.d);
      localProperties.setProperty("streamtype", String.valueOf(this.g));
      localProperties.setProperty("pdfImplement", this.l);
      localProperties.setProperty("receivelogtype", String.valueOf(this.h));
      localProperties.setProperty("executelogtype", String.valueOf(this.i));
      localProperties.setProperty("dbupdatetype", String.valueOf(this.j));
      localProperties.setProperty("tracelogtype", String.valueOf(this.k));
      localProperties.setProperty("ruleServerPort", String.valueOf(this.e));
      localProperties.setProperty("ruleThreadServerPort", String.valueOf(this.f));
      localProperties.store(new FileOutputStream(localFile), "Rule Engine Config File");
    }
    catch (Exception localException)
    {
    }
  }

  public static String a(XMLReceiveBean paramXMLReceiveBean)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(paramXMLReceiveBean.getRuleName());
    localStringBuffer.append(" ");
    localStringBuffer.append(paramXMLReceiveBean.getRuleVersion());
    localStringBuffer.append("{");
    Object localObject1;
    if (paramXMLReceiveBean.getValues().size() > 0)
    {
      localObject1 = paramXMLReceiveBean.getValues().keySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = ((Iterator)localObject1).next();
        Object localObject3 = paramXMLReceiveBean.getValue(String.valueOf(localObject2));
        if ((!(localObject3 instanceof String)) && (!(localObject3 instanceof Number)) && (!(localObject3 instanceof Date)))
          (localObject3 instanceof Boolean);
        localStringBuffer.append(localObject2).append(":").append(StringUtil.stringValue(localObject3)).append(";");
      }
    }
    else
    {
      localObject1 = paramXMLReceiveBean.getDymicValues();
      for (int n = 0; (localObject1 != null) && (n < localObject1.length); n++)
        localStringBuffer.append(StringUtil.stringValue(localObject1[n])).append(";");
    }
    localStringBuffer.append("}");
    return (String)localStringBuffer.toString();
  }

  private String a(RuleEngine paramRuleEngine)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("{");
    String[] arrayOfString = paramRuleEngine.getOutputVariables();
    for (int n = 0; n < arrayOfString.length; n++)
    {
      String str = arrayOfString[n];
      Object localObject = paramRuleEngine.get(str);
      if ((!(localObject instanceof String)) && (!(localObject instanceof Number)) && (!(localObject instanceof Date)) && (!(localObject instanceof Boolean)))
        continue;
      localStringBuffer.append(str).append(":").append(StringUtil.stringValue(localObject)).append(";");
    }
    localStringBuffer.append("}");
    return localStringBuffer.toString();
  }

  public void a(String paramString1, String paramString2)
  {
    if (this.h >= 1)
    {
      String str = MessageUtil.format("rulereceived.text", new String[] { paramString2, paramString1 });
      m.info(str);
    }
  }

  public void a(XMLReceiveBean paramXMLReceiveBean, String paramString1, String paramString2)
  {
    if (this.h >= 1)
    {
      String str = MessageUtil.format("ruleexecuteerror.text", new String[] { paramString1, a(paramXMLReceiveBean), paramString2 });
      m.info(str);
    }
  }

  public void a(RuleEngine paramRuleEngine, String paramString1, String paramString2)
  {
    if (this.h >= 1)
    {
      String str = MessageUtil.format("ruleexecuted.text", new String[] { paramString1, paramString2 + a(paramRuleEngine) });
      m.info(str);
    }
  }

  public static void main(String[] paramArrayOfString)
  {
    a().b();
  }

  public String c()
  {
    return this.d;
  }

  public void a(String paramString)
  {
    this.d = paramString;
  }

  public int d()
  {
    return this.e;
  }

  public void a(int paramInt)
  {
    this.e = paramInt;
  }

  public int e()
  {
    return this.g;
  }

  public void b(int paramInt)
  {
    this.g = paramInt;
  }

  public int f()
  {
    return this.f;
  }

  public void c(int paramInt)
  {
    this.f = paramInt;
  }

  public String g()
  {
    return this.l;
  }

  public void b(String paramString)
  {
    this.l = paramString;
  }

  public int h()
  {
    return this.h;
  }

  public void d(int paramInt)
  {
    this.h = paramInt;
  }

  public int i()
  {
    return this.i;
  }

  public void e(int paramInt)
  {
    this.i = paramInt;
  }

  public int j()
  {
    return this.j;
  }

  public void f(int paramInt)
  {
    this.j = paramInt;
  }

  public int k()
  {
    return this.k;
  }

  public void g(int paramInt)
  {
    this.k = paramInt;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.server.ServerProperty
 * JD-Core Version:    0.6.0
 */