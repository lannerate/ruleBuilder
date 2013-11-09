package org.agilemore.agilegrid.a;

import java.text.MessageFormat;
import org.agilemore.agilegrid.J;
import org.agilemore.agilegrid.N;
import org.agilemore.agilegrid.ad;
import org.agilemore.agilegrid.e;
import org.eclipse.core.runtime.Assert;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.TraverseEvent;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Text;

public class p extends J
{
  protected Text n;
  private ModifyListener a;
  private boolean o = false;
  private boolean p = false;
  private boolean q = false;
  private static final int r = 4;

  public p(e parame)
  {
    this(parame, 4);
  }

  public p(e parame, int paramInt)
  {
    super(parame, paramInt);
  }

  private void N()
  {
    boolean bool = this.p;
    this.p = q();
    if (bool != this.p)
      a("delete");
  }

  private void O()
  {
    boolean bool = this.q;
    this.q = w();
    if (bool != this.q)
      a("selectall");
  }

  private void P()
  {
    boolean bool = this.o;
    this.o = (this.n.getSelectionCount() > 0);
    if (bool != this.o)
    {
      a("copy");
      a("cut");
    }
  }

  protected Control a(e parame)
  {
    this.n = new Text(parame, h());
    this.n.addSelectionListener(new q(this));
    this.n.addMouseListener(new r(this));
    this.n.addFocusListener(new s(this));
    this.n.setFont(parame.getFont());
    this.n.setText("");
    this.n.addModifyListener(Q());
    return this.n;
  }

  protected Object d()
  {
    return this.n.getText();
  }

  protected void e()
  {
    if (this.n != null)
    {
      this.n.selectAll();
      this.n.setFocus();
      P();
      N();
      O();
    }
  }

  protected void a(Object paramObject)
  {
    this.n.removeModifyListener(Q());
    this.n.setText(paramObject == null ? "" : paramObject.toString());
    this.n.addModifyListener(Q());
  }

  protected void a(ModifyEvent paramModifyEvent)
  {
    String str1 = this.n.getText();
    if (str1 == null)
      str1 = "";
    String str2 = str1;
    boolean bool1 = y();
    boolean bool2 = b(str2);
    if ((str2 == null) && (bool2))
      Assert.isTrue(false, "Validator isn't limiting the cell editor's type range");
    if (!bool2)
      b(MessageFormat.format(j(), new Object[] { str1 }));
    b(bool1, bool2);
  }

  public N k()
  {
    return new N();
  }

  private ModifyListener Q()
  {
    if (this.a == null)
      this.a = new t(this);
    return this.a;
  }

  protected void a(SelectionEvent paramSelectionEvent)
  {
    f();
    b();
  }

  public boolean o()
  {
    if ((this.n == null) || (this.n.isDisposed()))
      return false;
    return this.n.getSelectionCount() > 0;
  }

  public boolean p()
  {
    if ((this.n == null) || (this.n.isDisposed()))
      return false;
    return this.n.getSelectionCount() > 0;
  }

  public boolean q()
  {
    if ((this.n == null) || (this.n.isDisposed()))
      return false;
    return (this.n.getSelectionCount() > 0) || (this.n.getCaretPosition() < this.n.getCharCount());
  }

  public boolean u()
  {
    return (this.n != null) && (!this.n.isDisposed());
  }

  public boolean M()
  {
    return (this.n != null) && (!this.n.isDisposed());
  }

  public boolean w()
  {
    if ((this.n == null) || (this.n.isDisposed()))
      return false;
    return this.n.getCharCount() > 0;
  }

  public void z()
  {
    this.n.copy();
  }

  public void A()
  {
    this.n.cut();
    P();
    N();
    O();
  }

  public void B()
  {
    if (this.n.getSelectionCount() > 0)
    {
      this.n.insert("");
    }
    else
    {
      int i = this.n.getCaretPosition();
      if (i < this.n.getCharCount())
      {
        this.n.setSelection(i, i + 1);
        this.n.insert("");
      }
    }
    P();
    N();
    O();
  }

  public void D()
  {
    this.n.paste();
    P();
    N();
    O();
  }

  public void F()
  {
    this.n.selectAll();
    P();
    N();
  }

  protected boolean I()
  {
    return getClass() != p.class;
  }

  public void a(ad paramad)
  {
    if ((paramad.f instanceof KeyEvent))
    {
      KeyEvent localKeyEvent = (KeyEvent)paramad.f;
      if (localKeyEvent.keyCode == 127)
      {
        this.n.setText("");
        f();
        return;
      }
    }
    super.a(paramad);
    this.n.selectAll();
  }

  protected void a(TraverseEvent paramTraverseEvent)
  {
    if (paramTraverseEvent.keyCode == 16777219)
    {
      if ((this.n.getCaretPosition() == 0) && (this.n.getSelectionCount() == 0))
        super.a(paramTraverseEvent);
    }
    else if (paramTraverseEvent.keyCode == 16777220)
    {
      if ((this.n.getCaretPosition() == this.n.getText().length()) && (this.n.getSelectionCount() == 0))
        super.a(paramTraverseEvent);
    }
    else if ((paramTraverseEvent.detail == 2) || (paramTraverseEvent.detail == 4))
      paramTraverseEvent.doit = false;
    else
      super.a(paramTraverseEvent);
  }

  protected void a(KeyEvent paramKeyEvent)
  {
    Control localControl = i();
    if ((localControl != null) && (!localControl.isDisposed()))
    {
      P();
      N();
      O();
    }
    super.a(paramKeyEvent);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     org.agilemore.agilegrid.a.p
 * JD-Core Version:    0.6.0
 */