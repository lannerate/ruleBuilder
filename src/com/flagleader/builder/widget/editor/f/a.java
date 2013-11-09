package com.flagleader.builder.widget.editor.f;

import com.flagleader.builder.widget.editor.i;
import com.flagleader.builder.widget.editor.n;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;

public class a extends i
{
  ArrayList b = new ArrayList();

  public a(n paramn)
  {
    super(paramn);
  }

  public void b(String paramString)
  {
    this.b.clear();
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
            this.b.add(arrayOfInt);
          }
          m = 1;
          break;
        case 60:
          i = localStringReader.read();
          if ((i == 37) && (j == 0))
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
        case 37:
          if (j != 0)
          {
            i = localStringReader.read();
            k++;
            if (i == 62)
            {
              j = 0;
              arrayOfInt[1] = k;
              this.b.add(arrayOfInt);
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
    super.b(paramString);
  }

  public boolean b(int paramInt)
  {
    if (a(paramInt))
      return true;
    return super.b(paramInt);
  }

  public boolean a(int paramInt)
  {
    int i = 0;
    for (int j = 0; j < this.b.size(); j++)
    {
      int[] arrayOfInt = (int[])this.b.get(j);
      if ((arrayOfInt[0] <= paramInt) && (arrayOfInt[1] >= paramInt))
        return false;
    }
    return true;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.widget.editor.f.a
 * JD-Core Version:    0.6.0
 */