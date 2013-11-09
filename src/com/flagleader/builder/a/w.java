package com.flagleader.builder.a;

import com.flagleader.builder.widget.h;
import com.flagleader.repository.k;
import com.flagleader.repository.rlm.editen.IModifierEditen;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;

class w extends MouseAdapter
{
  w(b paramb, k paramk, Label paramLabel, IModifierEditen paramIModifierEditen)
  {
  }

  public void mouseDown(MouseEvent paramMouseEvent)
  {
    if ((paramMouseEvent.button == 1) && (!this.a.g()))
    {
      this.b.a();
      this.c.dispose();
      this.a.update();
    }
    else if (paramMouseEvent.button == 3)
    {
      Menu localMenu = h.a();
      MenuItem localMenuItem;
      if ((!this.a.g()) && (this.d.canCut()))
      {
        localMenuItem = new MenuItem(localMenu, 64);
        localMenuItem.setText(this.a.c("cut.popup"));
        localMenuItem.addListener(13, new x(this, this.d));
      }
      if (this.d.canCopy())
      {
        localMenuItem = new MenuItem(localMenu, 64);
        localMenuItem.setText(this.a.c("copy.popup"));
        localMenuItem.addListener(13, new y(this, this.d));
      }
      if (!this.a.g())
      {
        localMenuItem = new MenuItem(localMenu, 64);
        localMenuItem.setText(this.a.c("paste.popup"));
        localMenuItem.addListener(13, new z(this, this.d));
      }
      localMenu.setEnabled(true);
      localMenu.setVisible(true);
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.w
 * JD-Core Version:    0.6.0
 */