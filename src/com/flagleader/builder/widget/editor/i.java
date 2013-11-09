package com.flagleader.builder.widget.editor;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import org.eclipse.jface.text.Document;
import org.eclipse.jface.text.DocumentEvent;
import org.eclipse.jface.text.IDocumentListener;

public class i extends Document
  implements m, IDocumentListener
{
  private String b;
  private boolean c;
  ArrayList a = new ArrayList();
  private n d;

  public i(n paramn)
  {
    addDocumentListener(this);
    this.d = paramn;
  }

  public void a()
  {
    if (this.b == null)
      throw new IllegalStateException("文件名不为空！");
    BufferedWriter localBufferedWriter = null;
    try
    {
      localBufferedWriter = new BufferedWriter(new FileWriter(this.b));
      localBufferedWriter.write(get());
      this.c = false;
    }
    finally
    {
      try
      {
        if (localBufferedWriter != null)
          localBufferedWriter.close();
      }
      catch (IOException localIOException1)
      {
      }
    }
  }

  public void b()
  {
    if (this.b == null)
      throw new IllegalStateException("文件名不为空！");
    BufferedReader localBufferedReader = null;
    try
    {
      localBufferedReader = new BufferedReader(new FileReader(this.b));
      StringBuffer localStringBuffer = new StringBuffer();
      int i;
      while ((i = localBufferedReader.read()) != -1)
        localStringBuffer.append((char)i);
      set(localStringBuffer.toString());
      if (this.d != null)
        this.d.b(localStringBuffer.toString());
      this.c = false;
    }
    finally
    {
      try
      {
        if (localBufferedReader != null)
          localBufferedReader.close();
      }
      catch (IOException localIOException1)
      {
      }
    }
  }

  public boolean c()
  {
    return this.c;
  }

  public void a(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }

  public String d()
  {
    return this.b;
  }

  public void a(String paramString)
  {
    this.b = paramString;
  }

  public void documentAboutToBeChanged(DocumentEvent paramDocumentEvent)
  {
  }

  public void documentChanged(DocumentEvent paramDocumentEvent)
  {
    this.c = true;
    try
    {
      String str = get();
      if (this.d != null)
        this.d.a(str);
      b(str);
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }

  public void b(String paramString)
  {
    this.a.clear();
    StringReader localStringReader = new StringReader(paramString);
    int j = 0;
    int k = 0;
    int[] arrayOfInt = new int[2];
    int m = 0;
    try
    {
      while (m == 0)
      {
        int i;
        switch (i = localStringReader.read())
        {
        case -1:
          if (j != 0)
          {
            arrayOfInt[1] = k;
            this.a.add(arrayOfInt);
          }
          m = 1;
          break;
        case 47:
          i = localStringReader.read();
          if ((i == 42) && (j == 0))
          {
            arrayOfInt = new int[2];
            arrayOfInt[0] = k;
            j = 1;
            k++;
          }
          else
          {
            k++;
          }
          k++;
          break;
        case 42:
          if (j != 0)
          {
            i = localStringReader.read();
            k++;
            if (i == 47)
            {
              j = 0;
              arrayOfInt[1] = k;
              this.a.add(arrayOfInt);
            }
          }
          k++;
          break;
        default:
          k++;
        }
      }
    }
    catch (IOException localIOException)
    {
    }
  }

  public boolean a(int paramInt)
  {
    return false;
  }

  public boolean b(int paramInt)
  {
    for (int i = 0; i < this.a.size(); i++)
    {
      int[] arrayOfInt = (int[])this.a.get(i);
      if ((arrayOfInt[0] <= paramInt) && (arrayOfInt[1] >= paramInt))
        return true;
    }
    return false;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.widget.editor.i
 * JD-Core Version:    0.6.0
 */