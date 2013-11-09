package org.agilemore.agilegrid.a;

import java.text.MessageFormat;
import org.agilemore.agilegrid.J;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.TraverseEvent;
import org.eclipse.swt.graphics.Cursor;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;

public class d extends J
{
  private String[] a;
  int n;
  private CCombo o;
  private static final int p = 0;
  private Cursor q = new Cursor(Display.getDefault(), 0);

  public d(org.agilemore.agilegrid.e parame)
  {
    super(parame, 0);
  }

  public d(org.agilemore.agilegrid.e parame, int paramInt)
  {
    super(parame, paramInt);
  }

  public d(org.agilemore.agilegrid.e parame, String[] paramArrayOfString, int paramInt)
  {
    super(parame, paramInt);
    a(paramArrayOfString);
  }

  public String[] M()
  {
    return this.a;
  }

  public void a(String[] paramArrayOfString)
  {
    this.a = paramArrayOfString;
    P();
  }

  protected Control a(org.agilemore.agilegrid.e parame)
  {
    this.o = new CCombo(parame, h());
    this.o.setFont(parame.getFont());
    P();
    this.o.addSelectionListener(new e(this));
    this.o.addFocusListener(new f(this));
    return this.o;
  }

  protected Object d()
  {
    return this.o.getText();
  }

  protected void a(Object paramObject)
  {
    if ((paramObject instanceof Integer))
    {
      this.n = ((Integer)paramObject).intValue();
      this.o.select(this.n);
    }
    else if ((paramObject instanceof String))
    {
      d((String)paramObject);
    }
    else
    {
      d(paramObject.toString());
    }
  }

  private void P()
  {
    if ((this.o != null) && (this.a != null))
    {
      this.o.removeAll();
      for (int i = 0; i < this.a.length; i++)
        this.o.add(this.a[i], i);
      a(true);
      this.n = 0;
    }
  }

  void N()
  {
    this.n = this.o.getSelectionIndex();
    Object localObject = d();
    s();
    boolean bool = b(localObject);
    a(bool);
    if (!bool)
      if ((this.a.length > 0) && (this.n >= 0) && (this.n < this.a.length))
        b(MessageFormat.format(j(), new Object[] { this.a[this.n] }));
      else
        b(MessageFormat.format(j(), new Object[] { this.o.getText() }));
    f();
    b();
  }

  protected void a()
  {
    if (n())
      N();
  }

  protected void a(KeyEvent paramKeyEvent)
  {
    if (paramKeyEvent.character == '\033')
      g();
    else if (paramKeyEvent.character == '\t')
      N();
  }

  protected void a(TraverseEvent paramTraverseEvent)
  {
    switch (paramTraverseEvent.keyCode)
    {
    case 16777217:
    case 16777218:
      break;
    default:
      if ((paramTraverseEvent.detail == 2) || (paramTraverseEvent.detail == 4))
        paramTraverseEvent.doit = false;
      else
        super.a(paramTraverseEvent);
    }
  }

  private void d(String paramString)
  {
    paramString = paramString.toLowerCase();
    String[] arrayOfString1 = this.o.getItems();
    String[] arrayOfString2 = new String[arrayOfString1.length];
    for (int i = 0; i < arrayOfString1.length; i++)
      arrayOfString2[i] = arrayOfString1[i].toLowerCase();
    for (i = paramString.length(); i >= 0; i--)
    {
      String str = paramString.substring(0, i);
      for (int j = 0; j < arrayOfString2.length; j++)
      {
        if (!arrayOfString2[j].startsWith(str))
          continue;
        this.o.select(j);
        return;
      }
    }
  }

  public void c()
  {
    if (this.q != null)
    {
      this.q.dispose();
      this.q = null;
    }
    super.c();
  }

  public int O()
  {
    return this.n;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     org.agilemore.agilegrid.a.d
 * JD-Core Version:    0.6.0
 */