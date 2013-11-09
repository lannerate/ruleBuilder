package com.flagleader.builder.actions;

import com.flagleader.builder.ResourceTools;
import com.flagleader.manager.d.b;
import com.flagleader.repository.m;
import org.eclipse.jface.action.IMenuCreator;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;

class B
  implements IMenuCreator
{
  Menu a;

  B(A paramA)
  {
  }

  public void dispose()
  {
    if ((this.a != null) && (!this.a.isDisposed()))
      this.a.dispose();
    this.a = null;
  }

  public Menu getMenu(Control paramControl)
  {
    if ((this.a != null) && (!this.a.isDisposed()))
      this.a.dispose();
    this.a = new Menu(paramControl);
    MenuItem localMenuItem1 = new MenuItem(this.a, 32);
    localMenuItem1.setText(ResourceTools.getMessage("autoCheck.SetDialog", "autoCheck"));
    localMenuItem1.setSelection(b.a().E());
    localMenuItem1.addListener(13, new C(this, localMenuItem1));
    MenuItem localMenuItem2 = new MenuItem(this.a, 32);
    localMenuItem2.setText(ResourceTools.getMessage("logTrace.SetDialog", "logTrace"));
    localMenuItem2.setSelection(b.a().G());
    localMenuItem2.addListener(13, new D(this, localMenuItem2));
    MenuItem localMenuItem3 = new MenuItem(this.a, 32);
    localMenuItem3.setText(ResourceTools.getMessage("stringAssign.SetDialog", "logTrace"));
    localMenuItem3.setSelection(m.a().d() == 1);
    localMenuItem3.addListener(13, new E(this, localMenuItem3));
    this.a.setEnabled(true);
    return this.a;
  }

  public Menu getMenu(Menu paramMenu)
  {
    if ((this.a != null) && (!this.a.isDisposed()))
      this.a.dispose();
    this.a = new Menu(paramMenu);
    MenuItem localMenuItem1 = new MenuItem(this.a, 32);
    localMenuItem1.setText(ResourceTools.getMessage("autoCheck.SetDialog", "autoCheck"));
    localMenuItem1.setSelection(b.a().E());
    localMenuItem1.addListener(13, new F(this, localMenuItem1));
    MenuItem localMenuItem2 = new MenuItem(this.a, 8);
    localMenuItem2.setText(ResourceTools.getMessage("logTrace.SetDialog", "logTrace"));
    localMenuItem2.setSelection(b.a().G());
    localMenuItem2.addListener(13, new G(this, localMenuItem1));
    MenuItem localMenuItem3 = new MenuItem(this.a, 8);
    localMenuItem3.setText(ResourceTools.getMessage("stringAssign.SetDialog", "logTrace"));
    localMenuItem3.setSelection(m.a().d() == 1);
    localMenuItem3.addListener(13, new H(this, localMenuItem3));
    this.a.setEnabled(true);
    return this.a;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.B
 * JD-Core Version:    0.6.0
 */