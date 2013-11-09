package com.flagleader.builder.dialogs.method;

import org.eclipse.swt.events.MenuAdapter;
import org.eclipse.swt.events.MenuEvent;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Table;

class s extends MenuAdapter
{
  s(MethodShell paramMethodShell)
  {
  }

  public void menuShown(MenuEvent paramMenuEvent)
  {
    Menu localMenu = (Menu)paramMenuEvent.widget;
    MenuItem[] arrayOfMenuItem = localMenu.getItems();
    int i = MethodShell.c(this.a).getSelectionCount();
    arrayOfMenuItem[2].setEnabled(i != 0);
    arrayOfMenuItem[3].setEnabled(i != 0);
    arrayOfMenuItem[4].setEnabled(MethodShell.l(this.a) != null);
    arrayOfMenuItem[5].setEnabled(i != 0);
    arrayOfMenuItem[7].setEnabled(MethodShell.c(this.a).getItemCount() != 0);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.dialogs.method.s
 * JD-Core Version:    0.6.0
 */