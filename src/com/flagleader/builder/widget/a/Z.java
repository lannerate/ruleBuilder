package com.flagleader.builder.widget.a;

import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.graphics.Point;

class Z extends MouseAdapter
{
  Z(X paramX, StyledText paramStyledText)
  {
  }

  public void mouseDoubleClick(MouseEvent paramMouseEvent)
  {
    try
    {
      int i;
      int j;
      if (this.b.getSelectionText().startsWith("{"))
      {
        i = this.b.getSelection().x + 1;
        j = i;
        try
        {
          if (X.a(this.a).a(i, i))
            j = X.a(this.a, i + 1, 0, this.b.getCharCount());
          this.b.setSelection(i, j);
        }
        catch (Throwable localThrowable3)
        {
          localThrowable3.printStackTrace();
        }
      }
      else if (this.b.getSelectionText().startsWith("}"))
      {
        try
        {
          i = this.b.getSelection().x;
          j = i;
          if (X.a(this.a).a(j, j))
            j = X.a(this.a, i - 1, 0);
          this.b.setSelection(j + 1, i);
        }
        catch (Throwable localThrowable1)
        {
          localThrowable1.printStackTrace();
        }
      }
    }
    catch (Throwable localThrowable2)
    {
      localThrowable2.printStackTrace();
    }
  }

  public void mouseUp(MouseEvent paramMouseEvent)
  {
    String str = this.b.getSelectionText();
    if ((str != null) && (str.length() > 0))
    {
      X.a(this.a).b(str);
      X.a(this.a).a(this.b.getText());
      this.a.e.redraw();
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.widget.a.Z
 * JD-Core Version:    0.6.0
 */