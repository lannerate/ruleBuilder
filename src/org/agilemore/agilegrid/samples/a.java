package org.agilemore.agilegrid.samples;

import org.agilemore.agilegrid.a.l;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.CoolBar;
import org.eclipse.swt.widgets.CoolItem;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;

public class a extends l
{
  private org.agilemore.agilegrid.e a;

  public a(org.agilemore.agilegrid.e parame)
  {
    super(parame);
  }

  protected Control a(Composite paramComposite)
  {
    Display localDisplay = paramComposite.getDisplay();
    this.a = new org.agilemore.agilegrid.e(paramComposite, 134349634);
    this.a.setLayoutData(new GridData(4, 4, true, true));
    this.a.setBackground(localDisplay.getSystemColor(1));
    this.a.a(new b(this, this.a));
    this.a.a(new c(this, this.a));
    this.a.a(new d(this));
    this.a.a(new e(this, this.a));
    this.a.a(new f(this, this.a));
    this.a.forceFocus();
    return this.a;
  }

  protected void b(Composite paramComposite)
  {
    CoolBar localCoolBar = new CoolBar(paramComposite, 0);
    localCoolBar.setLayoutData(new GridData(4, 16777216, true, false));
    CoolItem localCoolItem = new CoolItem(localCoolBar, 8);
    ToolBar localToolBar = new ToolBar(localCoolBar, 0);
    localCoolItem.setControl(localToolBar);
    ToolItem localToolItem1 = new ToolItem(localToolBar, 8);
    localToolItem1.addSelectionListener(new g(this));
    localToolItem1.setToolTipText("Add Company");
    localToolItem1.setImage(com.a.c.b(a.class, "/icons/add_company.png"));
    ToolItem localToolItem2 = new ToolItem(localToolBar, 8);
    localToolItem2.addSelectionListener(new h(this));
    localToolItem2.setToolTipText("Delete Company");
    localToolItem2.setImage(com.a.c.b(a.class, "/icons/delete_company.png"));
    com.a.c.a(localCoolBar);
    localCoolBar.setLocked(true);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     org.agilemore.agilegrid.samples.a
 * JD-Core Version:    0.6.0
 */