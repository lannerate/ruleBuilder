package com.flagleader.builder.dialogs.method;

import org.eclipse.swt.events.MenuAdapter;
import org.eclipse.swt.events.MenuEvent;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Table;

class C extends MenuAdapter
{
  C(MethodShell paramMethodShell)
  {
  }

  public void menuShown(MenuEvent paramMenuEvent)
  {
    Menu localMenu = (Menu)paramMenuEvent.widget;
    MenuItem[] arrayOfMenuItem = localMenu.getItems();
    arrayOfMenuItem[1].setEnabled(MethodShell.c(this.a).getSelectionCount() != 0);
    arrayOfMenuItem[5].setEnabled((MethodShell.d(this.a) != null) && (MethodShell.e(this.a)));
    arrayOfMenuItem[6].setEnabled(MethodShell.c(this.a).getItemCount() != 0);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.dialogs.method.C
 * JD-Core Version:    0.6.0
 */