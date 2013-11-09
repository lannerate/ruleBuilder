package com.flagleader.repository.export;

import java.util.Hashtable;

public class e
{
  private static e a = new e();
  private Hashtable b = new Hashtable();

  public static e a()
  {
    return a;
  }

  public d a(String paramString)
  {
    Object localObject = this.b.get(paramString);
    if ((localObject != null) && ((localObject instanceof d)))
      return (d)localObject;
    f localf = new f();
    this.b.put(paramString, localf);
    return localf;
  }

  public static String b(String paramString)
  {
    StringBuffer localStringBuffer = new StringBuffer(paramString);
    b(localStringBuffer, 0);
    a(localStringBuffer, 0);
    c(localStringBuffer, 0);
    return localStringBuffer.toString();
  }

  public static StringBuffer a(StringBuffer paramStringBuffer)
  {
    b(paramStringBuffer, 0);
    a(paramStringBuffer, 0);
    c(paramStringBuffer, 0);
    return paramStringBuffer;
  }

  private static void a(StringBuffer paramStringBuffer, int paramInt)
  {
    int i = paramStringBuffer.indexOf("#[", paramInt);
    if (i >= 0)
    {
      int j = paramStringBuffer.indexOf("]", i);
      if (j > i)
        paramStringBuffer.replace(i, j + 1, "<rsp:common.fieldValue displayName=\"" + paramStringBuffer.substring(i + 2, j) + "\"/>");
      a(paramStringBuffer, i + 2);
    }
  }

  private static void b(StringBuffer paramStringBuffer, int paramInt)
  {
    int i = paramStringBuffer.indexOf("#{", paramInt);
    if (i >= 0)
    {
      int j = paramStringBuffer.indexOf("}", i);
      if (j > i)
        paramStringBuffer.replace(i, j + 1, "<rsp:common.fieldValue fieldName=\"" + paramStringBuffer.substring(i + 2, j) + "\"/>");
      b(paramStringBuffer, i + 2);
    }
  }

  private static void c(StringBuffer paramStringBuffer, int paramInt)
  {
    int i = paramStringBuffer.indexOf("<rsp:", 0);
    int j;
    if (i >= 0)
    {
      j = paramStringBuffer.indexOf(">", i);
      if (j > i)
        c(paramStringBuffer, a(paramStringBuffer, i, j));
      else
        c(paramStringBuffer, i + 5);
    }
    i = paramStringBuffer.indexOf("</rsp:");
    if (i > 0)
    {
      j = paramStringBuffer.indexOf(">", i);
      if (j > i)
      {
        String str = paramStringBuffer.substring(i + 6, j);
        Tag localTag = RspTags.getInstance().getTag(str.trim());
        if (localTag != null)
        {
          StringBuffer localStringBuffer = new StringBuffer(localTag.getPostCode());
          paramStringBuffer.replace(i, j + 1, localStringBuffer.toString());
          c(paramStringBuffer, i + localStringBuffer.toString().length());
        }
      }
      c(paramStringBuffer, i + 5);
    }
  }

  private static String c(String paramString)
  {
    Tag localTag = RspTags.getInstance().getTag(paramString.trim());
    if (localTag != null)
      return localTag.getPreCode();
    return "";
  }

  private static int a(StringBuffer paramStringBuffer, int paramInt1, int paramInt2)
  {
    String str1 = paramStringBuffer.substring(paramInt1, paramInt2 + 1);
    int i = str1.indexOf(" ");
    if (i < 0)
      i = str1.indexOf("/>");
    if (i < 0)
      i = str1.indexOf(">");
    if (i > 5)
    {
      String str2 = str1.substring(5, i);
      StringBuffer localStringBuffer = new StringBuffer(c(str2.trim()));
      if (localStringBuffer.length() > 0)
      {
        while (localStringBuffer.indexOf("$") >= 0)
        {
          int j = localStringBuffer.indexOf("$");
          int k = localStringBuffer.indexOf("$", j + 1);
          if (k <= j)
            continue;
          localStringBuffer.replace(j, k + 1, a(str1, localStringBuffer.substring(j + 1, k)));
        }
        paramStringBuffer.replace(paramInt1, paramInt2 + 1, localStringBuffer.toString());
        return paramInt1 + localStringBuffer.toString().length();
      }
    }
    paramStringBuffer.replace(paramInt1, paramInt2 + 1, "");
    return paramInt1;
  }

  private static String a(String paramString1, String paramString2)
  {
    int i = paramString1.indexOf(paramString2 + "=");
    if (i < 0)
      return "";
    int j = paramString1.indexOf(" ", i);
    if (j < 0)
      j = paramString1.indexOf("/>", i);
    if (j < 0)
      j = paramString1.indexOf(">", i);
    if (j > i)
    {
      String str = paramString1.substring(i + paramString2.length() + 1, j);
      if ((str.startsWith("\"")) && (str.endsWith("\"")))
        return str.substring(1, str.length() - 1);
      return str;
    }
    return "";
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.export.e
 * JD-Core Version:    0.6.0
 */