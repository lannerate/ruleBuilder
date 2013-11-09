package com.flagleader.builder.shell;

import com.flagleader.builder.ResourceTools;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;

class aD extends MouseAdapter
{
  aD(StyledText paramStyledText)
  {
  }

  public void mouseDown(MouseEvent paramMouseEvent)
  {
    if (paramMouseEvent.button == 3)
    {
      if ((aC.a() != null) && (!aC.a().isDisposed()))
        aC.a().dispose();
      aC.a(new Menu(this.a.getShell(), 8));
      MenuItem localMenuItem = new MenuItem(aC.a(), 8);
      localMenuItem.setText(ResourceTools.getMessage("selectall.popup"));
      localMenuItem.addSelectionListener(new aE(this, this.a));
      localMenuItem.setAccelerator(SWT.MOD1 + 65);
      if (this.a.getSelectionText().length() > 0)
      {
        localMenuItem = new MenuItem(aC.a(), 8);
        localMenuItem.setText(ResourceTools.getMessage("cut.popup"));
        localMenuItem.setAccelerator(SWT.MOD1 + 88);
        localMenuItem.addSelectionListener(new aF(this, this.a));
        localMenuItem = new MenuItem(aC.a(), 8);
        localMenuItem.setText(ResourceTools.getMessage("copy.popup"));
        localMenuItem.addSelectionListener(new aG(this, this.a));
        localMenuItem.setAccelerator(SWT.MOD1 + 67);
      }
      localMenuItem = new MenuItem(aC.a(), 8);
      localMenuItem.setText(ResourceTools.getMessage("paste.popup"));
      localMenuItem.addSelectionListener(new aH(this, this.a));
      localMenuItem.setAccelerator(SWT.MOD1 + 86);
      aC.a().setVisible(true);
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.shell.aD
 * JD-Core Version:    0.6.0
 */