package com.flagleader.builder.a.b;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.dialogs.a.l;
import com.flagleader.repository.IBusinessObjectContainer;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.graphics.Point;

class j extends KeyAdapter
{
  j(e parame, int paramInt, CCombo paramCCombo)
  {
  }

  public void keyPressed(KeyEvent paramKeyEvent)
  {
    if ((this.b == 1) && (paramKeyEvent.character == '.'))
    {
      String str1 = this.c.getText();
      if ((this.c.getSelection().x >= 0) && (this.c.getSelection().y > this.c.getSelection().x))
        str1 = this.c.getText().substring(0, this.c.getSelection().x);
      paramKeyEvent.doit = false;
      e.g(this.a);
      Object localObject;
      if (e.e(this.a).isPlugInApp())
      {
        localObject = e.e(this.a).loadNewClass(String.valueOf(paramKeyEvent.character));
        if ((localObject != null) && (((String)localObject).length() > 0))
        {
          e.a(this.a, (String)localObject, this.b);
          return;
        }
      }
      else
      {
        localObject = new l(e.e(this.a), this.a.K().getEnvionment(), str1 + String.valueOf(paramKeyEvent.character));
        if (((l)localObject).open() == 0)
        {
          String str2 = ((l)localObject).a();
          if ((str2 != null) && (str2.length() > 0))
          {
            e.a(this.a, str2, this.b);
            return;
          }
        }
      }
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.b.j
 * JD-Core Version:    0.6.0
 */